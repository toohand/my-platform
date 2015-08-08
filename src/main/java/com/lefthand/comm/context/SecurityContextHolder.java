package com.lefthand.comm.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityContextHolder
{
    public static String USER_CONTEXT = "USER_CONTEXT";

    public static String HANDLER_CONTEXT = "HANDLER_CONTEXT";

    public static com.lefthand.comm.domain.Handleable getHandler()
    {
        HttpServletRequest request = ServletContextHolder.getRequest();
        return (com.lefthand.comm.domain.Handleable)request.getSession().getAttribute(HANDLER_CONTEXT);
    }

    public static void setHandler(com.lefthand.comm.domain.Handleable handler)
    {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(HANDLER_CONTEXT, handler);
    }

    public static void destroy()
    {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(HANDLER_CONTEXT);
        session.invalidate();
    }
}