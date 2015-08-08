package com.lefthand.system.controller;

import com.lefthand.base.controller.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: portal管理  SpringMVC控制类
 * Description: portal新增、删除、修改
 * Company: hugeinfo
 * author: codeBuilder
 * time:2015-06-24 15:13:45
 * version 1.0
 */
@Controller
@RequestMapping(value = "/myPortal")
class MyPortalController extends BaseController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(MyPortalController.class);

    //待办任务
    @RequestMapping(value = "/loadMyTask.do")
    public String loadMyTask(ModelMap model) {
        return "system/jsp/myTask" ;
    }
    //charts 实例1
    @RequestMapping(value = "/loadEchart1.do")
    public String loadEchart1(ModelMap model) {
        return "system/jsp/echarts1" ;
    }

    //charts 实例1
    @RequestMapping(value = "/loadEchart2.do")
    public String loadEchart2(ModelMap model) {
        return "system/jsp/echarts2" ;
    }

    //charts 实例3
    @RequestMapping(value = "/loadEchart3.do")
    public String loadEchart3(ModelMap model) {
        return "system/jsp/echarts3" ;
    }
}
