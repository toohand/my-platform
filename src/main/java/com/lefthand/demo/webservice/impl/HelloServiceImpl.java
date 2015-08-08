package com.lefthand.demo.webservice.impl;

import com.lefthand.demo.webservice.HelloService;

import javax.jws.WebService;

/**
 * Created by hp on 2015/6/29.
 */
@WebService(endpointInterface= "com.lefthand.demo.webservice.HelloService")
public class HelloServiceImpl implements HelloService {

    public String sayHello(String username) {
        return username+"! Welcome to CXF in Method[HelloService sayHello]";
    }
}
