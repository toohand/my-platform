package com.lefthand.comm.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder
        implements ApplicationContextAware
{
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException
    {
        context = applicationContext;
    }

    public static ApplicationContext getContext()
    {
        return context;
    }

    public static <T> T getBean(String name)
    {
        checkContext();
        return (T)context.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz)
    {
        checkContext();
        return (T)context.getBeansOfType(clazz);
    }

    public static void cleanContext()
    {
        context = null;
    }

    private static void checkContext() {
        if (context == null)
            throw new IllegalStateException("上下文未注入, 请在 spring 容器中定义 ApplicationContextHolder");
    }
}