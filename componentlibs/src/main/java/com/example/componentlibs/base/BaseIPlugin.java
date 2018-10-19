package com.example.componentlibs.base;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by hzwuwenchao on 2017/11/7.
 */
@Deprecated
public abstract class BaseIPlugin implements IPluginInterface {
    protected List<BaseIPlugin> dependOnPlugins = new ArrayList<>();
    protected List<BaseIPlugin> sortedDependOnPlugins = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BaseIPlugin)) {
            return false;
        }
        BaseIPlugin other = (BaseIPlugin) obj;
        if (TextUtils.equals(other.getClass().getName(), this.getClass().getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

    private List<BaseIPlugin> getDependOnPlugins(BaseIPlugin curPlugin) {
        curPlugin.dependency();
        List<BaseIPlugin> result = new ArrayList<>(curPlugin.dependOnPlugins);
        for (BaseIPlugin plugin : curPlugin.dependOnPlugins) {
            result.addAll(getDependOnPlugins(plugin));
        }
        return result;
    }

    protected void dependsOn(String plugin) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null) {
            try {
                Class<? extends BaseIPlugin> clazz = (Class<? extends BaseIPlugin>) classLoader.loadClass(plugin);
                dependOnPlugins.add(clazz.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    protected void processPluginsDependencyGraph() { //TODO 原样返回现在
        List<BaseIPlugin> allDependOnPlugins = getDependOnPlugins(this);
        LinkedHashSet<BaseIPlugin> dependOnPluginsSet = new LinkedHashSet<>();
        for (int i = allDependOnPlugins.size() - 1; i >= 0; i --) {
            dependOnPluginsSet.add(allDependOnPlugins.get(i));
        }
        sortedDependOnPlugins.addAll(dependOnPluginsSet);
    }

    public void doInit(Application application) {
        processPluginsDependencyGraph();
        for (int i = 0; i < sortedDependOnPlugins.size(); i ++) {
            Log.i("tag00","加载的class："+sortedDependOnPlugins.get(i).getClass().getSimpleName());
            sortedDependOnPlugins.get(i).execute(application);
        }
        execute(application);
    }
}
