package com.example.routerannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p><b>Package:</b> com.luojilab.router.facade.annotation </p>
 * <p><b>Project:</b> DDComponentForAndroid </p>
 * <p><b>Classname:</b> RouteDef </p>
 * <p><b>Description:</b> used to decline a route node</p>
 * Created by leobert on 2017/9/18.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface RouteNode {
    String path();
    @Deprecated
    int priority() default -1;
    String desc() default "";
}
