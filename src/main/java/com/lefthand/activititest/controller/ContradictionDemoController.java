package com.lefthand.activititest.controller;

import com.lefthand.activiticlient.ResctClient;
import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.comm.context.SecurityContextHolder;
import com.lefthand.comm.web.Servlets;
import com.lefthand.security.organization.domain.Post;
import com.lefthand.activititest.domain.ContradictionDemo;
import com.lefthand.activititest.service.ContradictionDemoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lefthand.base.controller.BaseController;

/**
 * Title: 矛盾上报Demo  SpringMVC控制类
 * Description: 矛盾上报Demo
 * Company: hugeinfo
 * author: hp
 * time:2015-08-05 09:02:39
 * version 1.0
 */
@Controller
@RequestMapping(value = "/contradictionDemo")
public class ContradictionDemoController extends BaseController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(ContradictionDemoController.class);
    @Autowired
    private ContradictionDemoService fService;
    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired(required = false)
    private ResctClient resctClient;

    private String bmpName = "contradiction";

    protected String getDateForMate() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //加载浏览页面
    @RequestMapping(value = "/load.do")
    public String load(ModelMap model) {
        return "activititest/contradictionDemo";
    }

    //加载新增或编辑页面
    @RequestMapping(value = "/show.do")
    public String show(Long id, ModelMap model) {
        try {
            ContradictionDemo vo = null;
            if (id != null && id != 0) {
                vo = fService.fetch(id);
            } else
                vo = new ContradictionDemo();
            model.put("vo", vo);
            return "activititest/contradictionDemoEdit";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            model.put("ex", e);
            return "error/500.jsp";
        }
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public String query(int page, int rows) {
        ContradictionDemo vo = new ContradictionDemo();
        try {
            Map m = Servlets.getParametersStartingWith(request, "w.");
            PageRequest p = new PageRequest(page - 1, rows, null);
            long total = fService.count(m);
            List<ContradictionDemo> list = fService.page(m, p);
            Map data = new HashMap();
            data.put("total", total);
            data.put("rows", list);
            return JSONUtil.map2JsonStr(data, null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "";
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public String save(ContradictionDemo vo) {
        JSONObject json = new JSONObject();
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "保存成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "保存失败");
        }
        return json.toString();
    }

    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public String delete(Long id) {
        JSONObject json = new JSONObject();
        try {
            if (id != 0) {
                fService.delete(id);
                json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                json.put(Constant.STATUS_MESSAGE, "删除成功");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "删除成功");
        }
        return json.toString();
    }

    @RequestMapping(value = "/deleteBatch.do")
    @ResponseBody
    public String delete(String ids) {
        JSONObject json = new JSONObject();
        try {
            if (!"".equals(ids)) {
                String[] params = ids.split(",");
                fService.deleteBatch(params);
                json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                json.put(Constant.STATUS_MESSAGE, "删除成功");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "删除成功");
        }
        return json.toString();
    }

    //上报方法
    @RequestMapping(value = "/report.do")
    public String report(String taskId, ModelMap model) {
        ContradictionDemo vo = null;
        try {
            if (taskId != null && !"".equals("")) {
                String bkey = resctClient.getBussKey(taskId);
                if (!bkey.equals(""))
                    vo = fService.fetch(bkey);
            } else {
                Post post = (Post) SecurityContextHolder.getHandler();
                com.lefthand.security.organization.domain.UserImpl user = (com.lefthand.security.organization.domain.UserImpl) post.getUser();
                vo = new ContradictionDemo();
                if (user != null) {
                    vo.setCdp(user.getName());
                    vo.setPost(post.getName());
                }
            }
            model.put("fromWrite", true);
            model.put("opt", "transact");
            model.put("vo", vo);
            return "activitiTest/contradictionDemoReport";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            model.put("ex", e);
            return "error/500";
        }
    }

    //处理任务
    @RequestMapping(value = "/submit.do")
    @ResponseBody
    public String submit(ContradictionDemo vo) {
        JSONObject json = new JSONObject();
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
                vo.setCdt(Calendar.getInstance().getTime());
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            Map map = new HashMap();
            Map<String, Object> actVars = Servlets.getParametersStartingWith(request, "act.");
            if (actVars.get("taskId") == null || actVars.get("taskId").equals("")) { //启动流程
                //设置流程实例变量
                map.put("summary", vo.getSummary());
                map.put("cdt", fmt.format(Calendar.getInstance().getTime())); //创建时间
                map.put("cdp", vo.getCdp()); //创建人
                map.put("cdpName", vo.getCdp());
                map.put("post", getPostValue(vo.getPost()));
                if (getPostValue(vo.getPost()).equals("wgy")) {
                    map.put("group", "技术经理");
                } else
                    map.put("group", SecurityContextHolder.getHandler().getName());
                JSONObject result = resctClient.startProcess(this.bmpName, vo.getId().toString(), map);
                if (result == null || result.get(Constant.STATUS_CODE).equals(Constant.STATUS_FAIL)) {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
                    json.put(Constant.STATUS_MESSAGE, result.get(Constant.STATUS_MESSAGE));
                } else {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                    json.put(Constant.STATUS_MESSAGE, "办理完成!");
                }
            } else {

                Post post = (Post) SecurityContextHolder.getHandler();
                com.lefthand.security.organization.domain.UserImpl user = (com.lefthand.security.organization.domain.UserImpl) post.getUser();
                if ("wgy".equals(actVars.get("activityId"))) {
                    actVars.put("group", "java工程师");
                } else
                    actVars.put("group", getParent(SecurityContextHolder.getHandler().getName()));
                JSONObject result = resctClient.completeTask((String) actVars.get("taskId"),
                        (String) actVars.get("comment"), user.getName(),
                        (String) actVars.get("activityId"), actVars);

                if (result == null || result.get(Constant.STATUS_CODE).equals(Constant.STATUS_FAIL)) {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
                    json.put(Constant.STATUS_MESSAGE, result.get(Constant.STATUS_MESSAGE));
                } else {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                    json.put(Constant.STATUS_MESSAGE, "办理完成!");
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "任务办理失败!错误信息：" + e.getMessage());
        }
        return json.toString();
    }

    // 显示表单
    @RequestMapping(value = "/showform.do")
    public String showform(String taskId, String opt, ModelMap model) {
        ContradictionDemo vo = null;
        try {
            String bkey = resctClient.getBussKey(taskId);
            if (!bkey.equals(""))
                vo = fService.fetch(bkey);
            if (vo == null) {
                model.put("message", "查询表单信息失败!");
                return "error/500";
            }
            //获取审批信息
            JSONArray links = resctClient.findOutComeList(taskId);
            model.put("links", links);
            model.put("opt", opt);
            model.put("taskId", taskId);
            model.put("vo", vo);
            return "activitiTest/contradictionDemoReport";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            model.put("ex", e);
            return "error/500";
        }
    }

    private String getPostValue(String postType) {
        switch (postType) {
            case "java工程师":
                return "wgy";
            case "技术经理":
                return "jwh";
            case "副总经理":
                return "jd";
            case "总经理":
                return "q";
        }
        return "wgy";
    }

    private String getParent(String postType) {
        switch (postType) {
            case "java工程师":
                return "技术经理";
            case "技术经理":
                return "副总经理";
            case "副总经理":
                return "总经理";
            case "总经理":
                return "java工程师";
        }
        return "java工程师";
    }
}
