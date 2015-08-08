package com.lefthand.base.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;


/**
 * Controller 控制层基类
 * Created by hp on 2015/6/18.
 */
public class BaseController {

    protected String getDateForMate(){
        return "yyyy-MM-dd";
    }
    //处理日期转换
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat(getDateForMate());
        dt.setLenient(false);
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dt, true));
    }
}
