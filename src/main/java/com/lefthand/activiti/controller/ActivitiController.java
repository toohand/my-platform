package com.lefthand.activiti.controller;

import com.lefthand.security.organization.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作流页面跳转 控制器
 * Created by 潘锦发 on 2015/6/10.
 */
@Controller
@RequestMapping(value = "/activitiPage")
public class ActivitiController {

    @Resource(name = "actCategorys")
    private List<String> actCategorys;
    @Value("#{properties['activiti.edit.url']}")
    private String editUrl;


    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    @Autowired(required = false)
    private HttpServletRequest request;

    /**
     * 跳转到流程管理页面-流程定义 与  部署管理
     * @return
     */
    @RequestMapping(value = "/processManage.do")
    public String processManage(){
        return "/activiti/ProcessManage";
    }

    /**
     * 跳转到实例管理页面
     * @return
     */
    @RequestMapping(value = "/instanceManage.do")
    public String instanceManage(){
        return "/activiti/InstanceManage";
    }

    /**
     * 跳转到历史实例管理页面
     * @return
     */
    @RequestMapping(value = "/historyProcinstManage.do")
    public String historyManage(){
        return "activiti/HistoryProcinstManage";
    }

    /**
     * 流程管理
     * @return
     */
    @RequestMapping(value = "/processModel.do")
    public String processModel(ModelMap model){
        model.put("editUrl",editUrl);
        return "activiti/processModel";
    }
    /**
     * 跳转到任务管理页面
     * @return
     */
    @RequestMapping(value = "/taskManage.do")
    public String taskManage(ModelMap model){
        String strs = "";
        for(String actCategory:actCategorys){
            strs += actCategory+",";
        }
        if (!strs.equals("")){
            strs = strs.substring(0,strs.length()-1);
        }
        model.put("actCategorys",strs);
        return "activiti/taskManage";
    }

    /**
     * 跳转到历史任务管理页面
     * @return
     */
    @RequestMapping(value = "/historyTaskManage.do")
    public String historyTaskManage(ModelMap model){
        String strs = "";
        for(String actCategory:actCategorys){
            strs += actCategory+",";
        }
        if (!strs.equals("")){
            strs = strs.substring(0,strs.length()-1);
        }
        model.put("actCategorys",strs);
        return "activiti/HistoryTaskManage";
    }

    /**
     * 跳转到历史任务管理页面
     * @return
     */
    @RequestMapping(value = "/myCompleteTask.do")
    public String myCompleteTask(ModelMap model){
        String strs = "";
        for(String actCategory:actCategorys){
            strs += actCategory+",";
        }
        if (!strs.equals("")){
            strs = strs.substring(0,strs.length()-1);
        }
        model.put("actCategorys",strs);

        Post post= (Post) com.lefthand.comm.context.SecurityContextHolder.getHandler();
        com.lefthand.security.organization.domain.UserImpl user = (com.lefthand.security.organization.domain.UserImpl) post.getUser();
        if (user != null) {
            model.put("userId", user.getName());
        }
        return "activiti/myCompleteTask";
    }

    @RequestMapping(value = "/myTaskManage.do")
    public String myTaskManage(ModelMap model){
        String strs = "";
        for(String actCategory:actCategorys){
            strs += actCategory+",";
        }
        if (!strs.equals("")){
            strs = strs.substring(0,strs.length()-1);
        }
        model.put("actCategorys", strs);
        Post post= (Post) com.lefthand.comm.context.SecurityContextHolder.getHandler();
        com.lefthand.security.organization.domain.UserImpl user = (com.lefthand.security.organization.domain.UserImpl) post.getUser();
        if (user != null) {
            model.put("userId", user.getName());
        }
        String str=post.getName()+","+post.getParent().getName();
        model.put("groups",str);
        return "activiti/myTaskManage";
    }

    @RequestMapping(value = "/findProinstanceTask.do")
      public String findProinstanceTask(String instanceId,ModelMap model){
        model.put("instanceId",instanceId);
        return "/activiti/TaskList";
    }

    @RequestMapping(value = "/delegationTask.do")
    public String delegationTask(String taskId,String oldUserId,ModelMap model){
        model.put("oldUserId",oldUserId);
        model.put("taskId",taskId);
        return "/activiti/delegationTask";
    }
    @RequestMapping(value = "/findHisComment.do")
    public String findHisComment(String taskId,ModelMap model){
        model.put("taskId",taskId);
        return "/activiti/hisComment";
    }

}
