package com.example.routercompiler.processor;

import com.example.routercompiler.utils.Logger;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import org.apache.commons.collections4.MapUtils;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import static com.example.routercompiler.utils.Constants.APPLICATION;
import static com.example.routercompiler.utils.Constants.BASEPLUGIN;
import static com.example.routercompiler.utils.Constants.KEY_APPLICATION_NAME;
import static com.example.routercompiler.utils.Constants.KEY_DEPEND_ON;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/16
 * @description:
 */
@AutoService(Processor.class)
@SupportedOptions({KEY_APPLICATION_NAME,KEY_DEPEND_ON})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class PluginProcessor extends AbstractProcessor {

    private Logger logger;

    private Elements elements;

    private String applicationName = null;

    private String dependsOn = null;

    private Filer mFiler;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        logger = new Logger(processingEnv.getMessager());

        elements = processingEnv.getElementUtils();

        mFiler = processingEnv.getFiler();

        Map<String, String> options = processingEnv.getOptions();

        if (MapUtils.isNotEmpty(options)) {
            applicationName = options.get(KEY_APPLICATION_NAME);
            dependsOn = options.get(KEY_DEPEND_ON);
            logger.info(">>> applicationName is " + applicationName + ", dependsOn : "+dependsOn+"<<<");
        } else {
            logger.info(">>> get params failed<<<");
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!isEmpty(applicationName)) {
            generateIPlugin();
        }
        return false;
    }

    private void generateIPlugin() {

        logger.info(">>> generateIPlugin is  start <<<");

        String applicationSampleName = applicationName.substring(applicationName.lastIndexOf(".") + 1);

        String claName = getApplicationName(applicationSampleName);
        logger.info(">>> claName is   "+claName+"<<<");

        String pkg = claName.substring(0, claName.lastIndexOf("."));
        logger.info(">>> pkg is   "+pkg+"<<<");

        ClassName superClass = ClassName.get(elements.getTypeElement(BASEPLUGIN));
        logger.info(">>> superClass is   "+superClass+"<<<");


        //simpleName
        String cn = claName.substring(claName.lastIndexOf(".") + 1);
        logger.info(">>> cn is   "+cn+"<<<");

        // superClassName
        MethodSpec initDependencyMethod = generateDependencyMethod();

        MethodSpec initConfigureMethod = generateConfigureMethod();

        MethodSpec initExecuteMethod = generateExecuteMethod();

        MethodSpec initInitMethod = generateInitMethod();

        try {
            JavaFile.builder(pkg, TypeSpec.classBuilder(cn)
                    .addModifiers(PUBLIC)
                    .superclass(superClass)
                    .addMethod(initDependencyMethod)
                    .addMethod(initConfigureMethod)
                    .addMethod(initExecuteMethod)
                    .addMethod(initInitMethod)
                    .build()
            ).build().writeTo(mFiler);
        } catch (IOException e) {
            logger.info(">>> processing is failed <<<");
            e.printStackTrace();
        }

        logger.info(">>> generateIPlugin is  end <<<");

    }

    private MethodSpec generateInitMethod() {
        logger.info(">>> generateInitMethod is  start <<<");
        ClassName applicationClass = ClassName.get(elements.getTypeElement(APPLICATION));
        MethodSpec.Builder initMethodSpecBuilder = MethodSpec.methodBuilder("init")
                .returns(TypeName.VOID)
                .addParameter(applicationClass,"application")
                .addModifiers(Modifier.PUBLIC);

        initMethodSpecBuilder.addStatement("doInit(application)");

        return initMethodSpecBuilder.build();
    }

    private MethodSpec generateExecuteMethod() {
        logger.info(">>> generateExecuteMethod is  start <<<");
        ClassName applicationClass = ClassName.get(elements.getTypeElement(APPLICATION));
        ClassName localApplicationClass = ClassName.get(elements.getTypeElement(applicationName));

        MethodSpec.Builder executeMethodSpecBuilder = MethodSpec.methodBuilder("execute")
                .returns(TypeName.VOID)
                .addParameter(applicationClass, "application")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC);
        executeMethodSpecBuilder.addCode(" if (application instanceof $T) {\n" +
                "            (($T) application).init();\n" +
                "        } else {\n" +
                "            $T myapp = new $T();\n" +
                "            myapp.init();\n" +
                "        }",applicationClass,localApplicationClass,localApplicationClass,localApplicationClass);

        return executeMethodSpecBuilder.build();
    }

    private MethodSpec generateConfigureMethod() {
        logger.info(">>> generateConfigureMethod is  start <<<");

        MethodSpec.Builder configureMethodSpecBuilder = MethodSpec.methodBuilder("configure")
                .returns(TypeName.VOID)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC);
        return configureMethodSpecBuilder.build();

    }

    private MethodSpec generateDependencyMethod() {
        logger.info(">>> generateDependencyMethod is  start <<<");
        MethodSpec.Builder dependencyMethodSpecBuilder = MethodSpec.methodBuilder("dependency")
                .returns(TypeName.VOID)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC);
        if (!isEmpty(dependsOn)) {
            logger.info(">>> dependsOn is  NotNull <<<");
            String dependOns[] = dependsOn.split(",");
            if (dependOns.length > 0) {
                for (int i = 0; i < dependOns.length; i++) {
                    String dependsOnName = dependOns[i];
                    dependencyMethodSpecBuilder.addStatement("dependsOn($S)",dependsOnName);
                }
            }
        }
        logger.info(">>> generateDependencyMethod is  end <<<");

        return dependencyMethodSpecBuilder.build();
    }

    public String getApplicationName(String applicationSampleName) {
        return applicationName+"IPlugin."+ applicationSampleName + "IPlugin";
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Override.class.getCanonicalName());
        return types;
    }



    public boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return true;
        }
        return false;
    }
}
