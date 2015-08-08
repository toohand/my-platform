package com.lefthand.example.webservice.rest;

import com.lefthand.example.domain.Example;
import com.lefthand.example.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 范例RESTful控制器
 * Created by wangmz on 2014/10/9.
 */
@RestController
@RequestMapping(value = "/api/example")
public class ExampleRestController {

    private static Logger logger = LoggerFactory.getLogger(ExampleRestController.class);
    @Autowired
    private ExampleService exampleService;

    /**
     * 范例接收方法<br/>
     *            url : 'http://localhost:8080/uportal/api/example/data'<br/>
     * Request Method : 'get'<br/>
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<Example> data(){
        List<Example> result = exampleService.findByAll(null);
        
        return result;
    }

}
