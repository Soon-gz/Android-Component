package com.example.routercompiler.utils;

/**
 * <p><b>Package:</b> com.luojilab.router.compiler.utils </p>
 * <p><b>Project:</b> DDComponentForAndroid </p>
 * <p><b>Classname:</b> Constants </p>
 * <p><b>Description:</b> Constants used by apt </p>
 */

public interface Constants {

    String ANNO_FACADE_PKG = "com.example.routerannotation";


    ///////////////////////////////////////////////////////////////////////////
    // Options of processor
    ///////////////////////////////////////////////////////////////////////////
    String KEY_HOST_NAME = "host";
    String KEY_APPLICATION_NAME = "applicationName";
    String KEY_DEPEND_ON = "dependsOn";

    String ANNOTATION_TYPE_ROUTE_NODE = ANNO_FACADE_PKG + ".annotation.RouteNode";
    String ANNOTATION_TYPE_ROUTER = ANNO_FACADE_PKG + ".annotation.Router";
    String ANNOTATION_TYPE_AUTOWIRED = ANNO_FACADE_PKG + ".annotation.Autowired";

    String PREFIX_OF_LOGGER = "[Router-Anno-Compiler]-- ";


    // System interface
    String ACTIVITY = "android.app.Activity";
    String FRAGMENT = "android.app.Fragment";
    String FRAGMENT_V4 = "android.support.v4.app.Fragment";
    String SERVICE = "android.app.Service";
    String PARCELABLE = "android.os.Parcelable";
    String SERIALIZABLE = "java.io.Serializable";
    String BUNDLE = "android.os.Bundle";
    String APPLICATION = "android.app.Application";

    // Java type
    String LANG = "java.lang";
    String BYTE = LANG + ".Byte";
    String SHORT = LANG + ".Short";
    String INTEGER = LANG + ".Integer";
    String LONG = LANG + ".Long";
    String FLOAT = LANG + ".Float";
    String DOUBEL = LANG + ".Double";
    String BOOLEAN = LANG + ".Boolean";
    String STRING = LANG + ".String";

    String ISYRINGE = "com.example.commonbasiclibrary.router.ISyringe";

    String JSON_SERVICE = "com.example.commonbasiclibrary.service.JsonService";

    String BASECOMPROUTER = "com.example.commonbasiclibrary.router.ui.BaseCompRouter";

    String BASEPLUGIN = "com.example.componentlibs.base.BaseIPlugin";

    String BASE_IUROUTER = "com.example.commonbasiclibrary.router.ui.IUIRouterPathManager";


}
