package com.lefthand.example.controller;

import com.lefthand.example.domain.Example;
import com.lefthand.example.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 范例控制器
 * Created by wangmz on 2014/9/30.
 */
@Controller
@RequestMapping(value = "/example")
public class ExampleController {
    //日志记录
    private static Logger logger = LoggerFactory.getLogger(ExampleController.class);
    //JSON数据转换
   // private static JsonMapper jsonMapper = new JsonMapper();

    @Autowired
    private ExampleService exampleService;

    /**
     * 分页获取范例数据
     * @param pageNo 页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "/getByPage" ,method = RequestMethod.GET)
    @ResponseBody
    public String getByPage(@RequestParam(required = false) int pageNo,
                            @RequestParam(required = false) int pageSize,
                            @RequestParam(required = false) String name){
        //获取session用户信息
        com.lefthand.security.organization.domain.Post handler = (com.lefthand.security.organization.domain.Post) com.lefthand.comm.context.SecurityContextHolder.getHandler();

        PageRequest page = new PageRequest(pageNo,pageSize);

        Map<String,Object> terms = new HashMap<String, Object>();
        terms.put("name", name);
        Page<Example> result = exampleService.query(page,terms);

       // String ret = jsonMapper.toJson(result);
        return "";
    }

    /**
     * 获取范例数据
     * @return
     */
    @RequestMapping(value = "/getData" ,method = RequestMethod.GET)
    @ResponseBody
    public String getByPage(){

        List<Example> result = exampleService.findByAll(null);

        //String ret = jsonMapper.toJson(result);
        return "";
    }
}
