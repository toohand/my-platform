package com.lefthand.security.authenticate;

import com.lefthand.comm.context.SecurityContextHolder;
import com.lefthand.comm.exception.ApplicationException;
import com.lefthand.security.organization.domain.Post;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录控制器
 * Created by wangmz on 2015/7/13.
 */
@RestController
@RequestMapping(value = "android")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticateService authenticateService;

    /**
     * 移动端登录<br/>
     *            url : '${ctx}/android/login?loginName=&password='
     * Request Method : 'POST'
     * @param loginName 登录名称
     * @param password  登录密码
     * @return 岗位集合
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public List<Post> mobile(@RequestParam String loginName, @RequestParam String password){
        try {
            if(StringUtils.isBlank(loginName) || StringUtils.isBlank(password)){
                logger.error("移动登录名称或者密码为空.");
                return null;
            }
            // 身份认证成功后, 获取的岗位信息
            List<Post> posts = authenticateService.authenticateAfter(loginName, password);

            // 判断获取岗位信息是否成功
            if (posts == null || posts.size()==0) {

                // 获取失败则重定向到错误页
                logger.error("登录名:{}, 身份信息获取失败.", loginName);
                return null;
            }

            // 将岗位信息设置到会话
            SecurityContextHolder.setHandler(posts.get(0));
            logger.error("登录名:{}, 岗位:{}, 登录成功.", loginName, posts.get(0).getName());
            return posts;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 岗位切换<br/>
     *            url : '${ctx}/android/switch?loginName=xxx&postId=xxx'
     * Request Method : 'POST'
     * @param loginName 登录名称
     * @param postId    岗位编号
     * @return 当前岗位
     */
    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    public Post change(@RequestParam String loginName, @RequestParam Long postId){
        try {
            Post post = authenticateService.authenticateAfter(loginName, postId);
            if(post==null){
                logger.error("登录名:{}, 岗位切换失败.", loginName);
                return null;
            }
            SecurityContextHolder.setHandler(post);
            logger.error("登录名:{}, 岗位:{}, 岗位切换成功.", loginName, post.getName());
            return post;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 退出登录
     *            url : '${ctx}/android/logout'
     * Request Method : 'GET'
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(){
        try {
            // 销毁会话信息
            SecurityContextHolder.destroy();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
}
