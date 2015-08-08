package com.lefthand.activiti.webservice.rest;

import com.lefthand.activiti.domain.MyProcessDefinition;
import com.lefthand.activiti.service.ActivitiBusinessService;
import com.lefthand.activiti.service.ActivitiManageService;
import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.comm.exception.ApplicationException;
import com.lefthand.comm.web.Servlets;
import org.activiti.engine.FormService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.util.json.JSONObject;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工作流RESTful控制器
 * Created by 潘锦发 on 2015/6/10.
 */
@RestController
@RequestMapping(value = "api/activitiManage")
public class ActivitiManageRestController {
    private static Logger logger = LoggerFactory.getLogger(ActivitiManageRestController.class);
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Autowired(required = false)
    private HttpServletRequest request;
    @Autowired
    private ActivitiManageService activitiManageService;
    @Autowired
    private ActivitiBusinessService activitiBusinessService;
    @Autowired
    private FormService formService;

//----------------------------------流程-部署管理-start-------------------------------------------------------------------

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/deployUpload.do
     * 上传部署文件
     *
     * @param file
     * @param fileName
     */
    @RequestMapping(value = "/deployUpload.do")
    public String deployUpload(@RequestParam(value = "file", required = true) MultipartFile file,
                               @RequestParam(value = "fileName", required = true) String fileName) {
        JSONObject json = new JSONObject();
        ;
        try {
            InputStream in = null;
            try {
                in = file.getInputStream();
                if (fileName.length() == 0 || fileName == null) {
                    fileName = file.getName();
                }
            } catch (IOException e) {
                json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
                json.put(Constant.STATUS_MESSAGE, "文件上传失败，错误信息：" + e.getMessage());
            }
            if (file.getOriginalFilename().contains(".zip")) {
                String deployId = activitiManageService.deployUpload(in, fileName);
                if (deployId != null && deployId.length() != 0) {
                    json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                    json.put(Constant.STATUS_MESSAGE, "流程发布成功！");
                }
            } else {
                json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
                json.put(Constant.STATUS_MESSAGE, "上传格式不是zip包。请重新上传吧");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "流程发布失败，错误信息：" + e.getMessage());
        }
        return json.toString();
    }

    @RequestMapping(value = "/deployed.do")
    public String deployed(@RequestParam(value = "modelId", required = true) String modelId,
                          @RequestParam(value = "deployName", required = false) String deployName) {
        JSONObject json = new JSONObject();
        try {
            activitiManageService.deployed(modelId,deployName);
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "流程发布完成！");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "流程发布失败，错误信息：" + e.getMessage());
        }
        return json.toString();
    }

    /**
     * 新增流程模板
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping(value = "/addModel.do")
    public String addModel(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "category", required = true) String category,
                           @RequestParam(value = "remark", required = false) String remark) {
        JSONObject json = new JSONObject();
        try {
            activitiManageService.createModel(name, remark,category);
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "流程模板新增完成！");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "流程模板新增失败，错误信息：" + e.getMessage());
        }
        return json.toString();
    }

    /**
     * 查询部署信息集合，返回json字符串
     *
     * @param pageSize
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryProcessModel.do", method = RequestMethod.GET)
    public String queryProcessModel(@RequestParam(value = "rows", required = false) int pageSize,
                                    @RequestParam(value = "page", required = false) int pageNumber,
                                    HttpServletRequest request) {
        Map wMap = null;
        wMap = Servlets.getParametersStartingWith(request, "w.");
        try {
            List<Model> list = activitiManageService.queryModel(pageNumber, pageSize, wMap);
            long total = activitiManageService.countModel(wMap);
            Map map = new HashMap();
            map.put("total", total);
            map.put("rows", list);
            return JSONUtil.map2JsonStr(map, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryProcessManage.do
     * 查询部署信息集合，返回jqui特定的格式，返回json字符串
     *
     * @param pageSize
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryProcessManage.do", method = RequestMethod.GET)
    public String queryProcessManage(@RequestParam(value = "rows", required = false) int pageSize,
                                     @RequestParam(value = "page", required = false) int pageNumber,
                                     HttpServletRequest request) {
        Map<String, Object> terms = new HashMap<String, Object>();
        terms.put("key", request.getParameter("key"));

        String startDate = request.getParameter("startTime");
        String startTime = "";
        String endDate = request.getParameter("endTime");
        String endTime = "";
        if (!StringUtils.isBlank(startDate)) {
            startTime = startDate + " 00:00:00";
            startTime = startTime.replaceAll("-", "");
        }
        if (!StringUtils.isBlank(endDate)) {
            endTime = endDate + " 23:59:59";
            endTime = endTime.replaceAll("-", "");
        }
        terms.put("startDate", startTime);
        terms.put("endDate", endTime);
        logger.debug("terms:" + terms);
        try {
            Page<MyProcessDefinition> pageProcessDefinition = activitiManageService.findAllProcessDefinition(terms, pageNumber, pageSize);
            Long ProcessDefinitionCount = pageProcessDefinition.getTotalElements();
            List<MyProcessDefinition> list = pageProcessDefinition.getContent();
            List<Object> myProcessDefinitionList = new ArrayList<Object>();
            for (MyProcessDefinition md : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", md.getId());//所属ID
                mapGet.put("category", md.getCategory());
                mapGet.put("deploymentId", md.getDeploymentId());//部署ID
                mapGet.put("deploymentName", md.getDeployment().getName());//部署名称
                mapGet.put("name", md.getName());//定义名称
                mapGet.put("key", md.getKey());//流程定义的KEY
                mapGet.put("version", md.getVersion());//流程定义的版本
                mapGet.put("resourceName", md.getResourceName());//文件名称
                mapGet.put("diagramResourceName", md.getDiagramResourceName());//图片名称
                String ct = null;
                if (md.getDeployment().getDeploymentTime() != null) {
                    ct = df.format(md.getDeployment().getDeploymentTime());
                }
                mapGet.put("createTime", ct);
                String stateResult = "";
                if (md.isSuspension() == 2) {
                    logger.debug("md.isSuspended()" + md.isSuspension());
                    stateResult = "挂起";
                } else {
                    logger.debug("md.isSuspended()" + md.isSuspension());
                    stateResult = "正常";
                }
                mapGet.put("state", stateResult);
                myProcessDefinitionList.add(mapGet);
            }
            JSONObject jo = new JSONObject();
            jo.put("total", ProcessDefinitionCount);
            jo.put("rows", myProcessDefinitionList);
            return jo.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti//deleteDeployment.do/{id}
     * 删除部署
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteDeployment.do/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteDeployment(@PathVariable(value = "id") String id) {
        try {
            activitiManageService.deleteProcessDefinitionByDeploymentId(id);
            return "亲,删除成功..";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败..该部署有正在运行的实例";

        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/suspendProcessDefinitionBykey.do/{key}/{depId}
     * 挂起 流程定义 根据流程定义的Key
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/suspendProcessDefinitionBykey.do/{key}/{depId}")
    @ResponseStatus(HttpStatus.OK)
    public String suspendProcessDefinitionBykey(@PathVariable(value = "key") String key,
                                                @PathVariable(value = "depId") String depId) {
        try {
            ProcessDefinition processDefinition = activitiManageService.queryProcessDefinition(depId);
            if (processDefinition.isSuspended()) {
                return "亲,该流程定义已经挂起，无需操作.";
            } else {
                activitiManageService.suspendProcessDefinitionBykey(key);
                return "亲，挂起成功..";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/activateProcessDefinition.do/{key}/{depId}
     * 激活 流程定义 根据流程定义的Key
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/activateProcessDefinition.do/{key}/{depId}")
    @ResponseStatus(HttpStatus.OK)
    public String activateProcessDefinition(@PathVariable(value = "key") String key,
                                            @PathVariable(value = "depId") String depId) {
        try {
            ProcessDefinition processDefinition = activitiManageService.queryProcessDefinition(depId);
            if (processDefinition.isSuspended()) {
                activitiManageService.activateProcessDefinition(key);
                return "亲，成功激活..";
            } else {
                return "亲,该流程定义已经激活，无需操作.";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }


    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/imageDeployment.do/{imgName}/{id}
     * 查看流程图
     *
     * @param id
     * @param imgName
     * @param response
     */
    @RequestMapping(value = "/imageDeployment.do/{imgName}/{id}")
    public void imageDeployment(@PathVariable(value = "id") String id,
                                @PathVariable(value = "imgName") String imgName,
                                HttpServletResponse response) {
        try {
            InputStream in = activitiManageService.findImageInputStream(id, imgName);
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "inline;imgName=\"" + imgName + "\"");
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            try {
                if (in != null) {
                    while ((length = in.read(b)) > 0) {
                        out.write(b, 0, length);
                    }
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//----------------------------------流程-部署管理-end---------------------------------------------------------------------


//----------------------------------流程-实例管理-start-------------------------------------------------------------------

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryInstanceManage.do
     * 查询流程实例 返回jui的格式
     *
     * @param pagzSize
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryInstanceManage.do")
    public String queryInstanceManage(@RequestParam(value = "rows", required = false) int pagzSize,
                                      @RequestParam(value = "page", required = false) int pageNumber,
                                      HttpServletRequest request) {
        Map wMap = null;
        wMap = Servlets.getParametersStartingWith(request, "w.");
        try {
            List<ProcessInstance> list = activitiManageService.findAllProcessInstance(wMap, pageNumber, pagzSize);
            Long ProcessInstanceCount = activitiManageService.countAllProcessInstance(wMap);
            List<Object> myProcessInstanceList = new ArrayList<Object>();
            for (ProcessInstance pi : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", pi.getId());
                mapGet.put("BusinessKey", pi.getBusinessKey());
                mapGet.put("DefinitionName", pi.getProcessDefinitionName());
                mapGet.put("DefinitionVersion", pi.getProcessDefinitionVersion());
                mapGet.put("ProcessInstanceId", pi.getProcessInstanceId());
                mapGet.put("ActivityId", pi.getActivityId());
/*                ActivityImpl activity = activitiBusinessService.findActivityImpl(pi.getProcessDefinitionId(), pi.getActivityId());
                if (activity != null)
                    mapGet.put("ActivityName", activity.getProperty("name"));
                else
                    mapGet.put("ActivityName", "");*/
                mapGet.put("summary", pi.getProcessVariables().get("summary"));
                mapGet.put("cdt", pi.getProcessVariables().get("cdt"));
                mapGet.put("cdp", pi.getProcessVariables().get("cdpName"));
                String stateResult = "";
                if (pi.isSuspended()) {
                    stateResult = "挂起";
                } else {
                    stateResult = "正常";
                }
                mapGet.put("state", stateResult);
                myProcessInstanceList.add(mapGet);
            }
            JSONObject jo = new JSONObject();
            jo.put("total", ProcessInstanceCount);
            jo.put("rows", myProcessInstanceList);
            return jo.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/suspendProcessInstance.do/{ProcessInstanceId}
     * 挂起 流程实例 根据流程定义的ID
     *
     * @param ProcessInstanceId
     * @return
     */
    @RequestMapping(value = "/suspendProcessInstance.do/{ProcessInstanceId}")
    @ResponseStatus(HttpStatus.OK)
    public String suspendProcessInstance(@PathVariable(value = "ProcessInstanceId") String ProcessInstanceId) {
        try {
            ProcessInstance processInstance = activitiManageService.findProcessInstanceBypiId(ProcessInstanceId);
            if (processInstance.isSuspended()) {
                return "亲,该流程实例已经挂起，无需操作.";
            } else {
                activitiManageService.suspendProcessInstance(ProcessInstanceId);
                return "亲，挂起成功..";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/activateProcessInstance.do/{ProcessInstanceId}
     * 激活 流程实例 根据流程实例的ID
     *
     * @param ProcessInstanceId
     * @return
     */
    @RequestMapping(value = "/activateProcessInstance.do/{ProcessInstanceId}")
    @ResponseStatus(HttpStatus.OK)
    public String activateProcessInstance(@PathVariable(value = "ProcessInstanceId") String ProcessInstanceId) {
        try {
            ProcessInstance processInstance = activitiManageService.findProcessInstanceBypiId(ProcessInstanceId);
            if (processInstance.isSuspended()) {
                activitiManageService.activateProcessInstance(ProcessInstanceId);
                return "亲，成功激活..";
            } else {
                return "亲,该流程实例已经激活，无需操作.";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/imageTask.do/{instanceId}")
    public void imageTask(@PathVariable(value = "instanceId") String instanceId,
                          HttpServletResponse response) {
        try {
            InputStream in = activitiManageService.findTaskImage(instanceId);
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "inline;imgName=taskImage.png");
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            try {
                if (in != null) {
                    while ((length = in.read(b)) > 0) {
                        out.write(b, 0, length);
                    }
                    in.close();
                }
            } catch (Exception e) {
                in.close();
                logger.error(e.getMessage(), e);
            }
            out.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//----------------------------------流程-实例管理-end---------------------------------------------------------------------


//----------------------------------流程-任务管理-start-------------------------------------------------------------------

    /**
     * 查询任务总数list 返回jui的格式
     *
     * @param pageSize
     * @param pageNumber
     * @param categorys
     * @param userId
     * @return
     */
    @RequestMapping(value = "/queryUndoTask.do")
    public String queryUndoTask(@RequestParam(value = "rows", required = false) int pageSize,
                                @RequestParam(value = "page", required = false) int pageNumber,
                                @RequestParam(value = "categorys", required = false) String categorys,
                                @RequestParam(value = "userId", required = false) String userId) {
        try {
            String[] strs = categorys.split(",");
            List wlist = new ArrayList();
            Collections.addAll(wlist, strs);
            Map wmap = Servlets.getParametersStartingWith(request, "w.");
            if ("admin".equals(userId)) { //系统管理员查询所有用户任务
                userId = "";
            }
            List<Task> list = activitiManageService.findUndoTask(userId, pageNumber, pageSize, wmap, wlist);
            Long groupTaskCount = activitiManageService.countUndoTask(userId, wmap, wlist);
            List<Object> groupTaskList = new ArrayList<Object>();
            for (Task task : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", task.getId());
                mapGet.put("summary", task.getProcessVariables().get("summary"));
                mapGet.put("name", task.getName());
                mapGet.put("assignee", task.getAssignee());
                mapGet.put("owner", task.getOwner());
                mapGet.put("formKey", task.getFormKey());
                mapGet.put("processInstanceId", task.getProcessInstanceId());
                mapGet.put("createTime", df.format(task.getCreateTime()));
                String stateResult = "";
                if (task.isSuspended()) {
                    stateResult = "挂起";
                } else {
                    stateResult = "正常";
                }
                mapGet.put("state", stateResult);
                groupTaskList.add(mapGet);
            }
            JSONObject jo = new JSONObject();
            jo.put("total", groupTaskCount);
            jo.put("rows", groupTaskList);
            return jo.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/endProcessTask.do/{taskId}
     * 根据任务ID  中止 任务 中止流程
     *
     * @return
     */
    @RequestMapping(value = "/endProcessTask.do/{taskId}", method = RequestMethod.GET)
    public String endProcessTask(@PathVariable("taskId") String taskId) {
        try {
            List<String> list = activitiBusinessService.findOutComeListByTaskId(taskId);
            if (list.contains("默认提交")) {
                Task task = null;
                try {
                    task = activitiManageService.findTaskById(taskId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (task.isSuspended()) {
                    return "任务被挂起，不能进行操作。(原因：实例被挂起)";
                } else {
                    try {
                        activitiManageService.endProcessTask(taskId);
                        return "中止成功.该任务已被结束..";
                    } catch (Exception e) {
                        return "中止失败..";
                    }
                }
            } else {
                return "该任务走向有多方向，不能立刻终止";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }


    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/getRdTask.do/{taskId}/{assignee}
     * 获取代办的 ReplaceDisposeTask页面，并赋予页面数据
     *
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/getRdTask.do/{taskId}/{assignee}")
    public ModelAndView getRdTask(@PathVariable("taskId") String taskId,
                                  @PathVariable("assignee") String assignee) {
        try {
            ModelAndView mv = new ModelAndView();
            //已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
            List<String> outcome = activitiBusinessService.findOutComeListByTaskId(taskId);
            mv.addObject("outcome", outcome);
            mv.addObject("taskId", taskId);
            mv.addObject("assignee", assignee);
            mv.setViewName("/activiti/ReplaceDisposeTask");
            return mv;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }


//----------------------------------流程-任务管理-end---------------------------------------------------------------------

//----------------------------------流程-历史实例管理-start----------------------------------------------------------------

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryHistoryProcinstManage.do
     *
     * @param pageSize
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryHistoryProcinstManage.do")
    public String queryHistoryProcinstManage(@RequestParam(value = "rows", required = false) int pageSize,
                                             @RequestParam(value = "page", required = false) int pageNumber,
                                             HttpServletRequest request) {
        Map wMap = null;
        wMap = Servlets.getParametersStartingWith(request, "w.");
        try {
            List<HistoricProcessInstance> list = activitiManageService.findAllHisProcinst(wMap, pageNumber, pageSize);
            long total = activitiManageService.countHisProcinst(wMap);
            List<Object> myHisProcinstList = new ArrayList<Object>();
            for (HistoricProcessInstance pi : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", pi.getId());
                mapGet.put("DefinitionId", pi.getProcessDefinitionId());
                mapGet.put("startTime", pi.getStartTime());
                mapGet.put("summary", pi.getProcessVariables().get("summary"));
                mapGet.put("cdp", pi.getProcessVariables().get("cdpName"));
                mapGet.put("endTime", pi.getEndTime());
                String stateResult = "";
                if (pi.getEndTime() == null) {
                    stateResult = "进行中";
                } else {
                    stateResult = "结束";
                }
                mapGet.put("state", stateResult);
                myHisProcinstList.add(mapGet);
            }
            Map map = new HashMap();
            map.put("total", total);
            map.put("rows", myHisProcinstList);
            return JSONUtil.map2JsonStr(map, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/findProinstanceTaskList/{instanceId}", method = RequestMethod.GET)
    public String findProinstanceTaskList(@PathVariable("instanceId") String instanceId) {
        try {
            List<HistoricTaskInstance> tasks = activitiManageService.findProinstanceTaskList(instanceId);
            return JSONUtil.list2JSONArray(tasks, "yyyy-MM-dd HH:mm:ss").toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//----------------------------------流程-历史实例管理-end---------------------------------------------------------------------

//----------------------------------流程-历史任务管理-start---------------------------------------------------------------------

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryHisTask.do
     * 查询历史流程实例 返回jui的格式
     *
     * @param pageSize
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryHisTask.do")
    public String queryHisTask(@RequestParam(value = "rows", required = false) int pageSize,
                               @RequestParam(value = "page", required = false) int pageNumber,
                               @RequestParam(value = "categorys", required = false) String categorys,
                               HttpServletRequest request) {
        try {
            String[] strs = categorys.split(",");
            List wlist = new ArrayList();
            Collections.addAll(wlist, strs);
            Map wmap = Servlets.getParametersStartingWith(request, "w.");
            List<HistoricTaskInstance> list = activitiManageService.findAllHisTask(wmap, wlist, pageNumber, pageSize);
            long total = activitiManageService.countHisTask(wmap, wlist);
            List<Object> tasks = new ArrayList<Object>();
            for (HistoricTaskInstance task : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", task.getId());
                mapGet.put("summary", task.getProcessVariables().get("summary"));
                mapGet.put("name", task.getName());
                mapGet.put("assignee", task.getAssignee());
                mapGet.put("owner", task.getOwner());
                mapGet.put("formKey", task.getFormKey());
                mapGet.put("processInstanceId", task.getProcessInstanceId());
                mapGet.put("createTime", task.getStartTime());
                mapGet.put("endTime", task.getEndTime());
                mapGet.put("duraction", task.getDurationInMillis());
                String stateResult = "";
                if (task.getEndTime() == null) {
                    stateResult = "未完成";
                } else {
                    stateResult = "结束";
                }
                mapGet.put("state", stateResult);
                tasks.add(mapGet);
            }
            Map map = new HashMap();
            map.put("total", total);
            map.put("rows", tasks);
            return JSONUtil.map2JsonStr(map, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//----------------------------------流程-历史任务管理-end------------------------------------------------------------------

//----------------------------------流程-组任务管理-start------------------------------------------------------------------

    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryUnclaimedTask.do
     * 查询待认领任务
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping(value = "/queryUnclaimedTaskByGroup.do")
    public String queryUnclaimedTaskByGroup(@RequestParam(value = "rows", required = false) int pageSize,
                                     @RequestParam(value = "page", required = false) int pageNumber,
                                     @RequestParam(value = "categorys", required = false) String categorys,
                                     @RequestParam(value = "groups", required = false) String groups) {
        try {
            String[] strs = categorys.split(",");
            List wlist = new ArrayList();
            Collections.addAll(wlist, strs);

            strs = groups.split(",");
            List glist = new ArrayList();
            Collections.addAll(glist, strs);

            Map wmap = Servlets.getParametersStartingWith(request, "w.");
            List<Task> list = activitiManageService.findUnclaimedTask(glist, pageNumber, pageSize, wmap, wlist);
            Long groupTaskCount = activitiManageService.countUnclaimedTask(glist, wmap, wlist);
            List<Object> groupTaskList = new ArrayList<Object>();
            for (Task task : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", task.getId());
                Map map = task.getProcessVariables();
                mapGet.put("summary", task.getProcessVariables().get("summary"));
                mapGet.put("name", task.getName());
                mapGet.put("assignee", task.getAssignee());
                mapGet.put("owner", task.getOwner());
                mapGet.put("formKey", task.getFormKey());
                mapGet.put("processInstanceId", task.getProcessInstanceId());
                mapGet.put("createTime", df.format(task.getCreateTime()));
                String stateResult = "";
                if (task.isSuspended()) {
                    stateResult = "挂起";
                } else {
                    stateResult = "正常";
                }
                mapGet.put("state", stateResult);
                groupTaskList.add(mapGet);
            }
            JSONObject jo = new JSONObject();
            jo.put("total", groupTaskCount);
            jo.put("rows", groupTaskList);
            return jo.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    /**
     * 范例调用：url http://localhost:8080/test/api/activiti/queryUnclaimedTask.do
     * 查询待认领任务
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping(value = "/queryUnclaimedTask.do")
    public String queryUnclaimedTask(@RequestParam(value = "rows", required = false) int pageSize,
                                     @RequestParam(value = "page", required = false) int pageNumber,
                                     @RequestParam(value = "categorys", required = false) String categorys,
                                     @RequestParam(value = "userId", required = false) String userId) {
        try {
            String[] strs = categorys.split(",");
            List wlist = new ArrayList();
            Collections.addAll(wlist, strs);
            Map wmap = Servlets.getParametersStartingWith(request, "w.");
            List<Task> list = activitiManageService.findUnclaimedTask(userId, pageNumber, pageSize, wmap, wlist);
            Long groupTaskCount = activitiManageService.countUnclaimedTask(userId, wmap, wlist);
            List<Object> groupTaskList = new ArrayList<Object>();
            for (Task task : list) {
                Map<String, Object> mapGet = new HashMap<String, Object>();
                mapGet.put("id", task.getId());
                Map map = task.getProcessVariables();
                mapGet.put("summary", task.getProcessVariables().get("summary"));
                mapGet.put("name", task.getName());
                mapGet.put("assignee", task.getAssignee());
                mapGet.put("owner", task.getOwner());
                mapGet.put("formKey", task.getFormKey());
                mapGet.put("processInstanceId", task.getProcessInstanceId());
                mapGet.put("createTime", df.format(task.getCreateTime()));
                String stateResult = "";
                if (task.isSuspended()) {
                    stateResult = "挂起";
                } else {
                    stateResult = "正常";
                }
                mapGet.put("state", stateResult);
                groupTaskList.add(mapGet);
            }
            JSONObject jo = new JSONObject();
            jo.put("total", groupTaskCount);
            jo.put("rows", groupTaskList);
            return jo.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    @RequestMapping(value = "/queryUsers.do")
    public String queryUsers(@RequestParam(value = "rows", required = false) int pagzSize,
                             @RequestParam(value = "page", required = false) int pageNumber) {
        try {
            List<User> list = activitiManageService.queryUsers(pagzSize, pageNumber);
            return JSONUtil.list2JSONArray(list, "").toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/findHisComment/{taskId}")
    public String findHisComment(@PathVariable("taskId") String taskId) {
        try {
            List<Comment> list = activitiBusinessService.findCommentByTaskId(taskId);
            return JSONUtil.list2JSONArray(list, "yyyy-MM-dd HH:mm:ss").toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }


//----------------------------------流程-组任务管理-end--------------------------------------------------------------------
}
