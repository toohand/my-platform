package com.lefthand.attachment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 附件管理页面跳转控制器
 * Created by wangmz on 2015/6/25.
 */
@Controller
@RequestMapping(value = "/attachment")
public class AttachmentController {

    private static Logger logger = LoggerFactory.getLogger(AttachmentController.class);

    private static final String LIST_VIEW = "attachment/list";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        return LIST_VIEW;
    }
}
