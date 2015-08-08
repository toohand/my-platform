package com.lefthand.comm.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class WebContext {

    private WebContext() {
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getRemoteAddr() {
        return getHttpServletRequest().getRemoteAddr();
    }

    public static String getRequestURI() {
        return getHttpServletRequest().getRequestURI();
    }
}
