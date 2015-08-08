package com.lefthand.example.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lefthand.security.authenticate.AuthenticateService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 模拟登录控制器
 */
@Controller
@RequestMapping(value = "mock")
public class MockLoginController {

    private static Logger logger = LoggerFactory.getLogger(MockLoginController.class);

    @Autowired
    private AuthenticateService authenticateService;

    /**
     * 模拟登录入口
     * 根据 mock.xml 配置, 列出模拟的单位/岗位
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        try {
            // 加载配置文件, 文件名称"mock.xml"
            SAXReader reader = new SAXReader();
            Document document = reader.read(this.getClass().getResourceAsStream("/mock.xml"));

            // 获取配置文件的根节点
            Element mock = document.getRootElement();
            Map<String, List<Map>> map = Maps.newHashMapWithExpectedSize(20);
            logger.debug(mock.getName());

            // 循环加载配置的单位
            for (Object u : mock.elements()) {
                Element unit = (Element) u;
                List<Map> list = Lists.newArrayListWithExpectedSize(15);
                map.put(unit.attributeValue("name"), list);
                logger.debug(unit.getName() + ":" + unit.attributeValue("name"));

                // 按每个单位, 循环加载配置的岗位
                for (Object p : unit.elements()) {
                    Element post = (Element) p;

                    Map<String, Object> item = Maps.newHashMapWithExpectedSize(5);
                    item.put("id",         post.attributeValue("id"));
                    item.put("name",       post.attributeValue("name"));
                    item.put("account",    post.attributeValue("account"));
                    item.put("username",   post.attributeValue("username"));
                    item.put("department", post.attributeValue("department"));

                    list.add(item);
                }
            }

            model.addAttribute("map", map);

        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }

        return "mock/login";
    }

    /**
     * 模拟统一平台页面
     * @return
     */
    @RequestMapping(value = "frame")
    public String mockframe() {
        return "/mock/mockframe";
    }

    /**
     * 模拟登出
     */
    @RequestMapping(value = "logout")
    public String logout() {
        try {
            // 销毁会话信息
            com.lefthand.comm.context.SecurityContextHolder.destroy();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }

        return "redirect:./mock/login";
    }

    /**
     * 模拟某岗位的用户登录
     *
     * @param loginName 登录名
     * @param postId    岗位流水号
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String loginName, @RequestParam Long postId) {
        try {
            // 模拟身份认证成功后, 获取的岗位信息
            com.lefthand.security.organization.domain.Post post = authenticateService.authenticateAfter(loginName, postId);

            // 判断获取岗位信息是否成功
            if (post == null) {

                // 获取失败则重定向到错误页
                logger.error("登录名:{}, 岗位:{}, 身份信息获取失败.", loginName, postId);
                return "redirect:/error/403";
            }
            /*Area area = areaService.getByUasId(post.getUnit().getUasId());
            post.getUnit().setArea(area);
            if (ObjectUtils.equals(post.getParent().getName(), Constants.DEPARTMENT_NAME_GRID)) {
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

        // 重定向到系统主页
        return "redirect:" + com.lefthand.comm.context.SystemContextHolder.getHome();
    }
}
