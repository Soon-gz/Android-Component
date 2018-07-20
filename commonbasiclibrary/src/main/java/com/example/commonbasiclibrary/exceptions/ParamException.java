package com.example.commonbasiclibrary.exceptions;

public final class ParamException extends UiRouterException {
    public ParamException(String paramName) {
        super(paramName + " is required param, but didn't contains in the bundle;");
    }
}
