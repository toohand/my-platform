package com.lefthand.comm.context;

import org.springframework.beans.factory.annotation.Value;

public class SystemContextHolder
{
    private static String environment;
    private static String login;
    private static String home;

    public static String getEnvironment()
    {
        return environment;
    }

    @Value("${system.environment}")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public static String getLogin() {
        return login;
    }

    @Value("${system.login}")
    public void setLogin(String login) {
        this.login = login;
    }

    public static String getHome() {
        return home;
    }

    @Value("${system.home}")
    public void setHome(String home) {
        this.home = home;
    }
}