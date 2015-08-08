package com.lefthand.security.authenticate;

import com.lefthand.comm.context.Constants;
import edu.yale.its.tp.cas.client.filter.CASFilter;
import gzrd.wsclient.user.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * 身份认证拦截器
 */
public class AuthenticateInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(AuthenticateInterceptor.class);

    @Autowired
    private gzrd.wsclient.user.UserWebService userService;

    @Autowired
    private AuthenticateService authenticateService;

    /**
     * 拦截器排除的请求集合
     */
    private String[] excludes;

    public AuthenticateInterceptor(String[] excludes) {
        this.excludes = excludes;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            if("user-agent".equals(headerName.toLowerCase())) {
                if("android".equals(request.getHeader(headerName).toLowerCase())) {
                    return true;
                }
            }
        }

        // 开发环境拦截策略
        if (Constants.ENV_DEVELOPMENT.equals(com.lefthand.comm.context.SystemContextHolder.getEnvironment())) {
            result = this.preHandleDevelopment(request, response, handler);
        }
        // 测试环境拦截策略
        if (Constants.ENV_TEST.equals(com.lefthand.comm.context.SystemContextHolder.getEnvironment())) {
            result = this.preHandleTest(request, response, handler);
        }
        // 生产环境拦截策略
        if (Constants.ENV_PRODUCTION.equals(com.lefthand.comm.context.SystemContextHolder.getEnvironment())) {
            result = this.preHandleProduction(request, response, handler);
        }

        return result;
    }

    private boolean preHandleDevelopment(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;

        String ctx = request.getContextPath();
        String uri = request.getRequestURI();

        // 判断拦截器排除的请求集合中是否包含当前请求
        if (excludes != null) {
            for (String exclude : excludes) {
                // 如果包含当前请求, 则不拦截
                if (uri.startsWith(ctx + exclude)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                logger.debug("身份认证拦截器排除的请求: {}", uri);
                return result;
            }
        }

        // 判断是否通过身份认证, 且存在会话信息
        com.lefthand.comm.domain.Handleable session = com.lefthand.comm.context.SecurityContextHolder.getHandler();
        // 没有会话信息, 则重定向到系统登录页
        if (session == null) {
            logger.debug("身份认证拦截器拦截的请求: {}", uri);
            response.sendRedirect(ctx + com.lefthand.comm.context.SystemContextHolder.getLogin());
            return false;
        }

        return true;
    }

    private boolean preHandleTest(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ctx = request.getContextPath();
        String uri = request.getRequestURI();

        // 判断拦截器排除的请求集合中是否包含当前请求
        if (excludes != null) {
            boolean result = false;
            for (String exclude : excludes) {
                // 如果包含当前请求, 则不拦截
                if (uri.startsWith(ctx + exclude)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                logger.debug("身份认证拦截器排除的请求: {}", uri);
                return result;
            }
        }

        HttpSession session = request.getSession();
        if(com.lefthand.comm.context.SecurityContextHolder.getHandler()==null) {
            String loginName = (String) session.getAttribute(CASFilter.CAS_FILTER_USER);
            //        gzrd.wsclient.user.UserWebService  userWebService= ApplicationContextHolder.getBean("UserWebService");
            User user = userService.getUserByName(loginName);
            Long curPosId = user.getPosId();

            logger.debug("CASFilter.CAS_FILTER_USER=" + loginName + "curPosId=" + curPosId);

            try {
                // 身份认证成功后, 获取的岗位信息
                com.lefthand.security.organization.domain.Post post = authenticateService.authenticateAfter(loginName, curPosId);
                // 判断获取岗位信息是否成功
                if (post == null) {
                    // 获取失败则重定向到错误页
                    logger.error("登录名:{}, 岗位:{}, 身份信息获取失败.", loginName, curPosId);
                    //                return "redirect:/error/403";
                }
                /*Area area = areaService.getByUasId(post.getUnit().getUasId());
                post.getUnit().setArea(area);
                if (ObjectUtils.equals(post.getParent().getName(), gzrd.ssim.utils.Constants.DEPARTMENT_NAME_GRID)) {
                    post.getUnit().setLevel(new GridLevel());
                } else {
                    post.getUnit().setLevel(levelService.getByArea(area));
                }
                Log log = new Log(post, LogModules.LOGIN, OperationType.DEFAULT, (long)0, ObjectType.DEFAULT, post.getUser().getName()+"登陆综治系统");
                logService.insert(log);*/
                // 将岗位信息设置到会话
                com.lefthand.comm.context.SecurityContextHolder.setHandler(post);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
            }
        }

        boolean result = super.preHandle(request, response, handler);
        return result;
    }

    private boolean preHandleProduction(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ctx = request.getContextPath();
        String uri = request.getRequestURI();

        // 判断拦截器排除的请求集合中是否包含当前请求
        if (excludes != null) {
            boolean result = false;
            for (String exclude : excludes) {
                // 如果包含当前请求, 则不拦截
                if (uri.startsWith(ctx + exclude)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                logger.debug("身份认证拦截器排除的请求: {}", uri);
                return result;
            }
        }

        HttpSession session = request.getSession();
//            String loginName = (String) session.getAttribute(CASFilter.CAS_FILTER_USER);
//            User user = userService.getUserByName(loginName);
//            Long curPosId = user.getPosId();
            boolean result = true;
            String curPosId = request.getParameter("curPosId"); //传递的岗位编号
            String loginName = request.getParameter("curuserId"); //传递的用户名

            logger.debug("CASFilter.CAS_FILTER_USER=" + loginName + "curPosId=" + curPosId);

            if (uri.equals(ctx + "/homePage") && StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(curPosId)) {
                try {
                    // 身份认证成功后, 获取的岗位信息
                    com.lefthand.security.organization.domain.Post post = authenticateService.authenticateAfter(loginName, Long.parseLong(curPosId));
                    // 判断获取岗位信息是否成功
                    if (post == null) {
                        result = false;
                        // 获取失败则重定向到错误页
                        logger.error("登录名:{}, 岗位:{}, 身份信息获取失败.", loginName, curPosId);
                        //                return "redirect:/error/403";
                    }
                    // 将岗位信息设置到会话
                    com.lefthand.comm.context.SecurityContextHolder.setHandler(post);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
                }
            } else {
                if(com.lefthand.comm.context.SecurityContextHolder.getHandler() == null) {
                    result = false;
                }
            }
        if(!result) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN,"Session failure.");
        }
        response.addHeader("P3P","CP=CAO PSA OUR");
        return result;
    }
}
