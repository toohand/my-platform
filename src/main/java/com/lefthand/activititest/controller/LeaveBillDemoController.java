package com.lefthand.activititest.controller;

import com.lefthand.activititest.domain.LeaveBillDemo;
import com.lefthand.activititest.service.LeaveBillDemoService;
import com.lefthand.activiticlient.ResctClient;
import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.base.controller.BaseController;
import com.lefthand.comm.context.SecurityContextHolder;
import com.lefthand.comm.web.Servlets;
import com.lefthand.security.organization.domain.Post;
import com.lefthand.security.organization.domain.UserImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: 请假流程Demo  SpringMVC控制类
 * Description: 请假流程Demo
 * Company: hugeinfo
 * author: hp
 * time:2015-07-02 16:29:44
 * version 1.0
 */
@Controller
@RequestMapping(value = "/leaveBillDemo")
public class LeaveBillDemoController extends BaseController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(LeaveBillDemoController.class);
    @Autowired
    private LeaveBillDemoService fService;
    @Autowired(required = false)
    private HttpServletRequest request;


    @Autowired(required = false)
    private ResctClient resctClient;

    @Resource(name = "leaveType")
    private Map leaveType;

    @Resource(name = "leaveState")
    private Map leaveState;

    private String bmpName = "leaveDemo";

    protected String getDateForMate() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //加载浏览页面
    @RequestMapping(value = "/load.do")
    public String load(ModelMap model) {
        model.put("leaveTypeMap", leaveType);
        model.put("leaveStateMap", leaveState);
        model.put("leaveTypeJson", JSONUtil.map2JsonStr(leaveType, null));
        model.put("leaveStateJson", JSONUtil.map2JsonStr(leaveState, null));
        return "activitiTest/leaveBillDemo";
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public String query(int page, int rows) {
        LeaveBillDemo vo = new LeaveBillDemo();
        try {
            Map m = Servlets.getParametersStartingWith(request, "w.");
            PageRequest p = new PageRequest(page - 1, rows, null);
            long total = fService.count(m);
            List<LeaveBillDemo> list = fService.page(m, p);
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
    public String save(LeaveBillDemo vo) {
        JSONObject json = new JSONObject();
        Map m = Servlets.getParametersStartingWith(request, "w.");
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
                vo.setCreateTime(Calendar.getInstance().getTime());
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "保存成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
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
    //申请方法
    @RequestMapping(value = "/apply.do")
    public String apply(String taskId, ModelMap model) {
        LeaveBillDemo vo = null;
        try {
            if (taskId != null && !"".equals("")) {
                String bkey = resctClient.getBussKey(taskId);
                if (!bkey.equals(""))
                    vo = fService.fetch(bkey);
            } else {
                Post post = (Post) SecurityContextHolder.getHandler();
                UserImpl user = (UserImpl) post.getUser();
                vo = new LeaveBillDemo();
                vo.setLeaveType(6);
                if (user != null) {
                    vo.setUserId(user.getId());
                    vo.setLoginName(user.getName());
                }

                vo.setState(1);
            }
            model.put("fromWrite", true);
            model.put("opt", "transact");
            model.put("vo", vo);
            model.put("leaveTypeMap", leaveType);
            model.put("leaveStateMap", leaveState);
            return "activitiTest/leaveBillDemoApply";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            model.put("ex", e);
            return "error/500";
        }
    }
    //处理任务
    @RequestMapping(value = "/submit.do")
    @ResponseBody
    public String submit(LeaveBillDemo vo) {
        JSONObject json = new JSONObject();
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
                vo.setCreateTime(Calendar.getInstance().getTime());
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            Map map = new HashMap();
            Map<String, Object> actVars = Servlets.getParametersStartingWith(request, "act.");
            if (actVars.get("taskId") == null || actVars.get("taskId").equals("")) { //启动流程
                //设置流程实例变量
                map.put("applyUser", vo.getLoginName());
                map.put("summary", "[" + vo.getLoginName() + "]请假申请，请假" + vo.getDay() + "天");
                map.put("cdt", fmt.format(Calendar.getInstance().getTime())); //创建时间
                map.put("cdp", vo.getUserId()); //创建人
                map.put("cdpName", vo.getLoginName());
                JSONObject result = resctClient.startProcess(this.bmpName, vo.getId().toString(), map);
                if (result == null || result.get(Constant.STATUS_CODE).equals(Constant.STATUS_FAIL)) {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
                    json.put(Constant.STATUS_MESSAGE, "查询任务失败，任务可能已经处理");
                } else {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                    json.put(Constant.STATUS_MESSAGE, "办理完成!");
                }
            } else {
                //设置业务值
                JSONArray forms = resctClient.findFormProperties((String) actVars.get("taskId"), "s.");
                if (forms != null && forms.size() > 0) {   //根据设置更新变量
                    Map vmap = new HashMap();
                    for (int i = 0; i < forms.size(); i++) {
                        Map p = (Map) forms.get(i);
                        vmap.put(p.get("id").toString().substring(2), p.get("value"));
                    }
                    if (vmap.size() > 0) {
                        Map wmap = new HashMap();
                        wmap.put("id", vo.getId());
                        fService.update(vmap, wmap);
                    }
                }
                //多人会签的时候设置会签人员
                if (actVars.get("activityId") != null && actVars.get("activityId").equals("projects")) {
                    List<String> userList = new ArrayList<String>();
                    userList.add("马润升");
                    userList.add("苏志雄");
                    actVars.put("userList", userList);
                }
                //设置流程流转变量值
                actVars.put("day", vo.getDay());
                Post post = (Post) SecurityContextHolder.getHandler();
                UserImpl user = (UserImpl) post.getUser();
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
        LeaveBillDemo vo = null;
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
            //获取表单信息
            JSONArray properties = resctClient.findFormProperties(taskId, "f.");
            boolean fromWrite = false;
            for (int i = 0; i < properties.size(); i++) {
                Map o = (Map) properties.get(i);
                if (o.get("id").equals("f.form"))
                    fromWrite = (boolean) o.get("writable");
            }
            model.put("fromWrite", fromWrite);
            model.put("links", links);
            model.put("opt", opt);
            model.put("taskId", taskId);
            model.put("vo", vo);
            model.put("leaveTypeMap", leaveType);
            model.put("leaveStateMap", leaveState);
            return "activitiTest/leaveBillDemoApply";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            model.put("ex", e);
            return "error/500";
        }
    }
}
