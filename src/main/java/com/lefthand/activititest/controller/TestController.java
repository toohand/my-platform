package com.lefthand.activititest.controller;

import com.lefthand.activititest.dao.TestLoginDao;
import com.lefthand.activiti.domain.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by PanjinF on 2015/6/12.
 */
@Controller
@RequestMapping(value = "/login")
public class TestController {
    @Autowired
    TestLoginDao dao;

    @RequestMapping(value = "/check.do")
    public ModelAndView checkLogin(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String loginName = request.getParameter("loginName");
        String passWord = request.getParameter("passWord");
        if (loginName != null) {
            TestUser tu = dao.findByLoginName(loginName);
            if (tu == null) {
                mv.setViewName("/login");
            } else {
                if (passWord.equals(tu.getPassWord())) {
                    request.getSession().setAttribute("loginName", loginName);
                    request.getSession().setAttribute("userId", tu.getId());
                    String ln = String.valueOf(request.getSession().getAttribute("loginName"));
                    System.out.println(ln);
                    mv.setViewName("/index");
                } else {
                    mv.setViewName("/login");
                }
            }
        } else {
            mv.setViewName("/login");
        }
        return mv;
    }

    @RequestMapping(value = "/getleaveBill.do")
    public ModelAndView getLeaveBill(HttpSession session) {
        String loginName = String.valueOf(session.getAttribute("loginName"));
        String postName = String.valueOf(session.getAttribute("postName"));
        String id = String.valueOf(session.getAttribute("id"));
        ModelAndView mv = new ModelAndView();
        if (loginName != null && postName != null && id != null) {
            mv.setViewName("activitiTest/leaveBill");
            mv.addObject("id", id);
            mv.addObject("loginName", loginName);
            mv.addObject("postName", postName);
        } else {
            mv.setViewName("redirect:/login");
        }
        return mv;
    }

    @RequestMapping(value = "/leaveManage.do")
    public ModelAndView leaveManage(HttpSession session) {
        String loginName = String.valueOf(session.getAttribute("loginName"));
        String postName = String.valueOf(session.getAttribute("postName"));
        String id = String.valueOf(session.getAttribute("id"));
        ModelAndView mv = new ModelAndView();
        if (loginName != null && postName != null && id != null) {
            mv.setViewName("activitiTest/leaveManage");
            mv.addObject("id", id);
            mv.addObject("loginName", loginName);
            mv.addObject("postName", postName);
        } else {
            mv.setViewName("redirect:/login");
        }
        return mv;
    }
}
