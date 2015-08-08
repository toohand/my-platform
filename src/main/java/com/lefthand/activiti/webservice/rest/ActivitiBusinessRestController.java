package com.lefthand.activiti.webservice.rest;

import com.lefthand.activiti.service.ActivitiBusinessService;
import com.lefthand.base.comm.Constant;
import com.lefthand.comm.context.SecurityContextHolder;
import com.lefthand.security.organization.domain.Post;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by PanjinF on 2015/6/18.
 */
@RestController
@RequestMapping("/api/activitiBusiness")
public class ActivitiBusinessRestController {
    private static Logger logger = LoggerFactory.getLogger(ActivitiBusinessRestController.class);
    @Autowired
    ActivitiBusinessService activitiBusinessService;

    /**
     * 根据任务Id获取业务Key
     * @param taskId
     * @return  获取失败为空
     */
    @RequestMapping(value = "/getBussKey/{taskId}")
    public String getBussKey(@PathVariable("taskId")String taskId){
        try {
            String str = activitiBusinessService.findEntityIdByTask(taskId);
            String bkey = str.substring(str.indexOf(".")+1);
            return bkey;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * 根据任务Id获取连线
     * @param taskId
     * @return  获取失败为空
     */
    @RequestMapping(value = "/findOutComeList/{taskId}")
    public String findOutComeList(@PathVariable("taskId")String taskId){
        try {
            List list= activitiBusinessService.findOutComeListByTaskId(taskId);
            return  JSONArray.fromObject(list).toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * 根据任务Id获取form表单值
     * @param taskId
     * @return  获取失败为空
     */
    @RequestMapping(value = "/findFormProperties/{taskId}/{sfix}")
    public String findFormProperties(@PathVariable("taskId")String taskId ,@PathVariable("sfix")String sfix){
        try {
            List list= activitiBusinessService.findFormProperties(taskId, sfix);
            return  JSONArray.fromObject(list).toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * 启动流程
     * @param bmpName  流程标示
     * @param bussKey  业务key
     * @return  获取失败为空
     */
    @RequestMapping(value = "/startProcess/{bmpName}/{bussKey}")
    public String startProcess(@PathVariable(value ="bmpName")String bmpName ,
                               @PathVariable(value ="bussKey")String bussKey,
                               @RequestBody Map vars){
        JSONObject result = new JSONObject();
        try {
            activitiBusinessService.startProcess(bmpName, bussKey, vars);
            result.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            result.put(Constant.STATUS_MESSAGE, "流程启动成功!");
            return  result.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            result.put(Constant.STATUS_MESSAGE, e.getMessage());
            return result.toString();
        }
    }

    /**
     * 认领任务
     * @param taskId 任务id
     * @param userId 认领人员
     * @return
     */
    @RequestMapping(value = "/claimedTask.do")
    @ResponseStatus(HttpStatus.OK)
    public String claimedTask(@RequestParam("taskId") String taskId,
                              @RequestParam(value = "userId", required = false) String userId) {
        org.activiti.engine.impl.util.json.JSONObject json = new org.activiti.engine.impl.util.json.JSONObject();
        if (userId == null || userId.equals("")) {
            Post post= (Post) SecurityContextHolder.getHandler();
            com.lefthand.security.organization.domain.UserImpl user = (com.lefthand.security.organization.domain.UserImpl) post.getUser();
            userId = user.getName();
        }
        try {
            activitiBusinessService.claimTask(taskId, userId);
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "任务认领成功!");
        } catch (Exception e) {
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "任务认领失败,错误信息："+e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return json.toString();
    }
    /**
     * 完成任务
     * @param taskId     任务Id
     * @return  获取失败为空
     */
    @RequestMapping(value = "/completeTask/{taskId}")
    @ResponseBody
    public String completeTask(@PathVariable(value ="taskId")String taskId,
                               @RequestBody Map vars){
        JSONObject result = new JSONObject();
        try {
            String comment = (String) vars.get("comment");
            String outcome  = (String) vars.get("outcome");
            String userId = (String) vars.get("userId");
            vars.remove("comment");
            vars.remove("outcome");
            activitiBusinessService.completeTask(taskId, comment, outcome, vars, userId);
            result.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            result.put(Constant.STATUS_MESSAGE, "任务处理完成!");
            return  result.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            result.put(Constant.STATUS_MESSAGE, "任务处理失败，错误信息："+e.getMessage());
            return result.toString();
        }
    }

    @RequestMapping(value = "/delegationTask.do")
    @ResponseBody
    public String delegationTask(@RequestParam(value ="taskId",required = true)String taskId ,
                                 @RequestParam(value ="userId",required = true)String userId,
                                 @RequestParam(value ="olduserId",required = false)String olduserId
                                 )
    {
        JSONObject result = new JSONObject();
        try {
            activitiBusinessService.delegation(taskId, olduserId, userId);
            result.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            result.put(Constant.STATUS_MESSAGE, "委托办理完成!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            result.put(Constant.STATUS_MESSAGE, "委托办理失败，错误信息："+e.getMessage());
        }
        return result.toString();
    }

    /**
     * 管理员代办 完成任务
     *
     * @param taskId
     * @param outcome
     * @param comment
     * @return
     */
    @RequestMapping(value = "/completeReplaceTask.do")
    public String completeReplaceTask(@RequestParam("taskId") String taskId,
                                      @RequestParam("outcome") String outcome,
                                      @RequestParam("comment") String comment,
                                      @RequestParam("assignee") String assignee) {
        org.activiti.engine.impl.util.json.JSONObject json = new org.activiti.engine.impl.util.json.JSONObject();
        comment = "管理员代办处理:" + comment;
        try {
            activitiBusinessService.completeTask(taskId, comment, outcome, null, assignee);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "代办任务成功!");
        } catch (Exception e) {
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "代办任务失败，错误信息："+e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return json.toString();
    }

}
