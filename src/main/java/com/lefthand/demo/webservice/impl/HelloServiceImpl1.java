package com.lefthand.demo.webservice.impl;

import com.lefthand.demo.webservice.HelloService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Administrator on 2015/6/29.
 */

public class HelloServiceImpl1 implements HelloService {
    @GET
    @Path("/sayHello/{username}")
    public String sayHello(@PathParam("username")String username) {
        return username+"! Welcome to CXF in Method[HelloService sayHello]";
    }
}
