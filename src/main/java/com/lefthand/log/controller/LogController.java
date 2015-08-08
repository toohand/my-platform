package com.lefthand.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 日志管理页面跳转控制器
 * Created by wangmz on 2015/7/2.
 */
@Controller
@RequestMapping(value = "/log")
public class LogController {

    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    private static final String LIST_VIEW = "log/list";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        return LIST_VIEW;
    }
}
