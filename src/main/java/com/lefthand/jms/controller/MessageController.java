package com.lefthand.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 消息管理页面控制器
 * Created by wangmz on 2015/7/14.
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {

    private static Logger logger = LoggerFactory.getLogger(MessageController.class);

    private static final String LIST_VIEW = "message/list";
    private static final String CLIENT_VIEW = "message/client";

    /**
     * 消息列表页面
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        return LIST_VIEW;
    }

    /**
     * MQTT客户端页面
     * @return
     */
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String client(){
        return CLIENT_VIEW;
    }
}
