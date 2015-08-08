package com.lefthand.activiti.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lefthand.activiti.dao.ActivitiManageDao;
import com.lefthand.activiti.domain.MyProcessDefinition;
import com.lefthand.activiti.domain.MyTask;
import com.lefthand.activiti.service.ActivitiManageService;
import com.lefthand.comm.exception.ApplicationException;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.history.*;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.activiti.spring.SpringProcessEngineConfiguration;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * 流程管理服务接口实现
 * Created by 潘锦发 on 2015/6/10.
 */
@Service
@Transactional
public class ActivitiManageServiceImpl implements ActivitiManageService {

    private static Logger logger = LoggerFactory.getLogger(ActivitiManageServiceImpl.class);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired(required = false)
    private FormService formService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ActivitiManageDao activitiManageDao;
    @Autowired
    IdentityService identityService;

    @Autowired
    private SpringProcessEngineConfiguration processEngine;
    //-----------------------------------------------------流程定义暂停 和 激活 start--------------------------------------

    /**
     * 暂停流程定义
     * 根据ProcessDefinitionKey 流程定义的KEY
     * 当一个流程定义被暂停，一个新的流程实例不会被创建（一个异常将会被抛出）
     */
    @Override
    public void suspendProcessDefinitionBykey(String ProcessDefinitionKey) {
        try {
            repositoryService.suspendProcessDefinitionByKey(ProcessDefinitionKey);
            logger.debug("监控ProcessDefinitionKey" + ProcessDefinitionKey + ";已经成功挂起");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 激活流程定义
     * 根据流程定义的KEY
     *
     * @param ProcessDefinitionKey
     */
    @Override
    public void activateProcessDefinition(String ProcessDefinitionKey) {
        try {
            repositoryService.activateProcessDefinitionByKey(ProcessDefinitionKey);
            logger.debug("监控ProcessDefinitionKey" + ProcessDefinitionKey + ";已经成功激活");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------流程定义暂停 和 激活 end----------------------------------------

    //-----------------------------------------------------流程实例暂停 和 激活 start--------------------------------------

    /**
     * 暂停流程实例
     * 根据流程实例的ID
     * <p/>
     * 当暂停的时候，这个流程不会继续下去并且没有计划会被执行
     *
     * @param processInstanceId
     */
    @Override
    public void suspendProcessInstance(String processInstanceId) {
        try {
            runtimeService.suspendProcessInstanceById(processInstanceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 激活流程实例
     * 根据流程实例ID
     *
     * @param processInstanceId
     */
    @Override
    public void activateProcessInstance(String processInstanceId) {
        try {
            runtimeService.activateProcessInstanceById(processInstanceId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    //-----------------------------------------------------流程实例暂停 和 激活 end----------------------------------------


    //-----------------------------------------------------查询流程实例集合和 总数 单一操作 start----------------------------


    /**
     * 根据流程实例ID  查询单一的 流程实例
     *
     * @return
     */
    @Override
    public ProcessInstance findProcessInstanceBypiId(String ProcessInstanceId) {
        try {
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(ProcessInstanceId)
                    .singleResult();//单一查询
            return processInstance;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    //-----------------------------------------------------查询流程实例集合和总数 单一操作 end-------------------------------


    //-----------------------------------------------------部署流程操作 deploy start--------------------------------------

    /**
     * 上传部署文件，zip流
     *
     * @param deployName
     * @param in
     * @return
     */
    @Override
    public String deployUpload(InputStream in, String deployName) {
        try {
            String deployId = "";
            //将File文件流转成ZIPInputStream流
            try {
                ZipInputStream zi = new ZipInputStream(in);
                deployId = repositoryService.createDeployment()//创建部署对象
                        .name(deployName)//添加部署名称
                        .addZipInputStream(zi)//添加zip流
                        .deploy().getId();//完成部署
            } catch (Exception e) {
                e.printStackTrace();
            }
            return deployId;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 删除部署
     *
     * @param deployId
     * @return
     */
    @Override
    public void deleteProcessDefinitionByDeploymentId(String deployId) {
        try {
            repositoryService.deleteDeployment(deployId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查看流程图
     *
     * @param deployId
     * @return
     */
    @Override
    public InputStream findImageInputStream(String deployId, String imgName) {
        try {
            InputStream in = repositoryService.getResourceAsStream(deployId, imgName);
            return in;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查看流程图
     *
     * @param instanceId
     * @return
     */
    @Override
    public InputStream findTaskImage(String instanceId) {
        try {
            ProcessInstance pi = findProcessInstanceBypiId(instanceId);
            if (pi != null) {
                ProcessDefinitionEntity pe = (ProcessDefinitionEntity) repositoryService
                        .getProcessDefinition(pi.getProcessDefinitionId());
                BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
                DefaultProcessDiagramGenerator dpg = new DefaultProcessDiagramGenerator();
                List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery().processInstanceId(instanceId).orderByHistoricActivityInstanceStartTime().asc().list();
                List<String> activitiIds = new ArrayList<String>();
                List<String> flowIds = getHighLightedFlows(pe, activityInstances);//获取流程走过的线        
                for (HistoricActivityInstance hai : activityInstances) {
                    activitiIds.add(hai.getActivityId());//获 取流程走过的节点 
                }
                InputStream imageStream = dpg.generateDiagram(bpmnModel, "png", activitiIds, flowIds,
                        processEngine.getProcessEngineConfiguration().getActivityFontName(),
                        processEngine.getProcessEngineConfiguration().getLabelFontName(), null, 1.0D);
                return imageStream;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }

    }

    private List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity, List<HistoricActivityInstance> historicActivityInstances) {
        List<String> highFlows = new ArrayList<String>();
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {
            // 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity.findActivity(historicActivityInstances.get(i).getActivityId());// 得到节点定义的详细 信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity.findActivity(historicActivityInstances.get(i + 1).getActivityId());// 将后面第一个节点放 在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(activityImpl2.getStartTime())) {// 如果第 一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity.findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出 去的线
            for (PvmTransition pvmTransition : pvmTransitions) {// 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();// 如果取出的线的目标节点 存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }

    /*
     * 查询部署对象的总数
     * 对应查询act_re_deployment
     *
     * @return
     */
    @Override
    public Long queryDeploymentCount() {
        try {
            Long DeploymentCount = repositoryService.createDeploymentQuery().count();
            return DeploymentCount;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据部署ID 查询单一的部署对象
     *
     * @param deployId
     * @return
     */
    @Override
    public Deployment queryDeployment(String deployId) {
        try {
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deployId).singleResult();
            return deployment;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    //-----------------------------------------------------部署流程操作 deploy end----------------------------------------

    //-----------------------------------------------------查询流程定义 集合和总数 单一操作 start----------------------------

    /**
     * 查询流程定义的信息 单一查询
     * 查询 act_re_procdef
     *
     * @return
     */
    @Override
    public ProcessDefinition queryProcessDefinition(String deploymentId) {
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .deploymentId(deploymentId)
                    .singleResult();
            return processDefinition;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 流程定义的总数
     *
     * @return
     */
    @Override
    public Long queryProcessDefinitionCount() {
        try {
            Long ProcessDefinitionCount = repositoryService.createProcessDefinitionQuery().count();
            return ProcessDefinitionCount;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 管理员操作
     * 中止流程任务，根据任务ID
     *
     * @param taskId
     */
    @Override
    public void endProcessTask(String taskId) {
        try {
            ActivityImpl endActivity = findActivitiImpl(taskId, "END");
            commitProcess(taskId, null, endActivity.getId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据任务ID和节点ID获取活动节点 <br>
     *
     * @param taskId     任务ID
     * @param activityId 活动节点ID <br>
     *                   如果为null或""，则默认查询当前活动节点 <br>
     *                   如果为"end"，则查询结束节点 <br>
     * @return
     * @throws Exception
     */

    public ActivityImpl findActivitiImpl(String taskId, String activityId)
            throws Exception {
        ProcessDefinitionEntity processDefinition = findProcessDefinitionEntityByTaskId(taskId);// 取得流程定义


        if (activityId != null) {
            activityId = findTaskById(taskId).getTaskDefinitionKey();// 获取当前活动节点ID
        }


        if (activityId.toUpperCase().equals("END")) {
            for (ActivityImpl activityImpl : processDefinition.getActivities()) {
                List<PvmTransition> pvmTransitionList = activityImpl
                        .getOutgoingTransitions();// 根据流程定义，获取该流程实例的结束节点
                if (pvmTransitionList.isEmpty()) {
                    return activityImpl;
                }
            }
        }
        ActivityImpl activityImpl = processDefinition
                .findActivity(activityId);// 根据节点ID，获取对应的活动节点

        return activityImpl;
    }

    /**
     * 根据任务ID获取流程定义
     *
     * @param taskId 任务ID
     * @return
     * @throws Exception
     */
    public ProcessDefinitionEntity findProcessDefinitionEntityByTaskId(
            String taskId) throws Exception {
        // 取得流程定义
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(findTaskById(taskId)
                        .getProcessDefinitionId());

        if (processDefinition == null) {
            throw new Exception("流程定义未找到!");
        }

        return processDefinition;
    }

    /**
     * 根据任务ID获得任务实例
     *
     * @param taskId 任务ID
     * @return
     * @throws Exception
     */
    public TaskEntity findTaskById(String taskId) throws Exception {
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(
                taskId).singleResult();
        if (task == null) {
            throw new Exception("任务实例未找到!");
        }
        return task;
    }

    /**
     * @param taskId     当前任务ID
     * @param variables  流程变量
     * @param activityId 流程转向执行任务节点ID<br>
     *                   此参数为空，默认为提交操作
     * @throws Exception
     */
    private void commitProcess(String taskId, Map<String, Object> variables,
                               String activityId) throws Exception {
        if (variables == null) {
            variables = new HashMap<String, Object>();
        }
        if (activityId != null) {
            taskService.complete(taskId, variables);// 跳转节点为空，默认提交操作
        } else {
            turnTransition(taskId, activityId, variables);// 流程转向操作
        }
    }

    /**
     * 流程转向操作
     *
     * @param taskId     当前任务ID
     * @param activityId 目标节点任务ID
     * @param variables  流程变量
     * @throws Exception
     */
    public void turnTransition(String taskId,
                               String activityId,
                               Map<String, Object> variables) throws Exception {
        ActivityImpl currActivity = findActivitiImpl(taskId, null);// 当前节点
        List<PvmTransition> oriPvmTransitionList = clearTransition(currActivity);// 清空当前流向
        TransitionImpl newTransition = currActivity.createOutgoingTransition();// 创建新流向
        ActivityImpl pointActivity = findActivitiImpl(taskId, activityId);// 目标节点
        newTransition.setDestination(pointActivity);// 设置新流向的目标节点
        taskService.complete(taskId, variables);// 执行转向任务
        pointActivity.getIncomingTransitions().remove(newTransition);// 删除目标节点新流入
        restoreTransition(currActivity, oriPvmTransitionList);// 还原以前流向
    }

    /**
     * 清空指定活动节点流向
     *
     * @param activityImpl 活动节点
     * @return 节点流向集合
     */
    private List<PvmTransition> clearTransition(ActivityImpl activityImpl) {
        List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();// 存储当前节点所有流向临时变量
        List<PvmTransition> pvmTransitionList = activityImpl// 获取当前节点所有流向，存储到临时变量，然后清空
                .getOutgoingTransitions();
        for (PvmTransition pvmTransition : pvmTransitionList) {
            oriPvmTransitionList.add(pvmTransition);
        }
        pvmTransitionList.clear();
        return oriPvmTransitionList;
    }

    /**
     * 还原指定活动节点流向
     *
     * @param activityImpl         活动节点
     * @param oriPvmTransitionList 原有节点流向集合
     */
    private void restoreTransition(ActivityImpl activityImpl,
                                   List<PvmTransition> oriPvmTransitionList) {
        // 清空现有流向
        List<PvmTransition> pvmTransitionList = activityImpl
                .getOutgoingTransitions();
        pvmTransitionList.clear();
        // 还原以前流向
        for (PvmTransition pvmTransition : oriPvmTransitionList) {
            pvmTransitionList.add(pvmTransition);
        }
    }
    //-----------------------------------------------------------------中止流程任务的集成方法-end---------------------------

    /**
     * 根据条件查询list集合 流程部署
     *
     * @param terms
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    @Override
    public Page<MyProcessDefinition> findAllProcessDefinition(Map<String, Object> terms, int pageNumber,
                                                              int pagzSize) {
        try {
            PageRequest page = new PageRequest(pageNumber - 1, pagzSize, null);
            return activitiManageDao.findAllProcessDefinition(page, terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据条件查询list集合  流程实例
     *
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    @Override
    public List<ProcessInstance> findAllProcessInstance(Map<String, Object> wMap, int pageNumber, int pagzSize) {
        int firstResult = pagzSize * (pageNumber - 1);
        int maxResult = pagzSize + firstResult;
        ProcessInstanceQuery instanceQuery = runtimeService.createProcessInstanceQuery().includeProcessVariables();
        String condition = (String) wMap.get("condition");
        if (wMap.get("condition") != null && !wMap.get("condition").equals("")) {
            //instanceQuery.or().processInstanceNameLike("%" + condition + "%");
            instanceQuery.or().variableValueLike("summary", "%" + condition + "%");
            instanceQuery.variableValueLike("cdp", "%" + condition + "%");
            instanceQuery.endOr();
        }
        if (wMap.get("fdate") != null && !wMap.get("fdate").toString().equals("")) {
            instanceQuery.variableValueGreaterThanOrEqual("cdt", wMap.get("fdate").toString());
        }
        if (wMap.get("edate") != null && !wMap.get("edate").toString().equals("")) {
            instanceQuery.variableValueLessThanOrEqual("cdt", wMap.get("edate").toString());
        }
        List<ProcessInstance> list = instanceQuery.orderByProcessInstanceId().desc().listPage(firstResult, maxResult);
        return list;
    }

    /**
     * 根据条件查询流程实例总数
     *
     * @param wMap
     * @return
     */
    @Override
    public long countAllProcessInstance(Map<String, Object> wMap) {
        ProcessInstanceQuery instanceQuery = runtimeService.createProcessInstanceQuery();
        String condition = (String) wMap.get("condition");
        if (wMap.get("condition") != null) {
            //instanceQuery.or().processInstanceNameLike("%" + condition + "%");
            instanceQuery.or().variableValueLike("summary", "%" + condition + "%");
            instanceQuery.variableValueLike("cdp", "%" + condition + "%");
            instanceQuery.endOr();
        }
        return instanceQuery.count();
    }

    /**
     * 根据条件查询list集合  任务对象 任务管理界面
     *
     * @param terms
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    @Override
    public Page<MyTask> findAllProcessTask(Map<String, Object> terms, int pageNumber, int pagzSize) {
        try {
            PageRequest pageRequest = new PageRequest(pageNumber - 1, pagzSize, null);
            return activitiManageDao.findAllProcessTask(pageRequest, terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }


    /**
     * 查询流程历史信息
     *
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    @Override
    public List<HistoricProcessInstance> findAllHisProcinst(Map<String, Object> wMap, int pageNumber, int pagzSize) {
        int firstResult = pagzSize * (pageNumber - 1);
        int maxResult = pagzSize + firstResult;
        HistoricProcessInstanceQuery instanceQuery = historyService.createHistoricProcessInstanceQuery().includeProcessVariables();
        String condition = (String) wMap.get("condition");
        if (wMap.get("condition") != null && !wMap.get("condition").equals("")) {
            //instanceQuery.or().processInstanceNameLike("%" + condition + "%");
            instanceQuery.or().variableValueLike("summary", "%" + condition + "%");
            instanceQuery.variableValueLike("cdp", "%" + condition + "%");
            instanceQuery.endOr();
        }
        if (wMap.get("fdate") != null && !wMap.get("fdate").toString().equals("")) {
            instanceQuery.variableValueGreaterThanOrEqual("cdt", wMap.get("fdate").toString());
        }
        if (wMap.get("edate") != null && !wMap.get("edate").toString().equals("")) {
            instanceQuery.variableValueLessThanOrEqual("cdt", wMap.get("edate").toString());
        }
        List<HistoricProcessInstance> list = instanceQuery.orderByProcessInstanceId().desc().listPage(firstResult, maxResult);
        return list;
    }

    /**
     * 查询流程实例总数
     *
     * @param wMap
     * @return
     */
    public long countHisProcinst(Map<String, Object> wMap) {
        HistoricProcessInstanceQuery instanceQuery = historyService.createHistoricProcessInstanceQuery().includeProcessVariables();
        String condition = (String) wMap.get("condition");
        if (wMap.get("condition") != null && !wMap.get("condition").equals("")) {
            instanceQuery.or().variableValueLike("summary", "%" + condition + "%");
            instanceQuery.variableValueLike("cdp", "%" + condition + "%");
            instanceQuery.endOr();
        }
        if (wMap.get("fdate") != null && !wMap.get("fdate").toString().equals("")) {
            instanceQuery.variableValueGreaterThanOrEqual("cdt", wMap.get("fdate").toString());
        }
        if (wMap.get("edate") != null && !wMap.get("edate").toString().equals("")) {
            instanceQuery.variableValueLessThanOrEqual("cdt", wMap.get("edate").toString());
        }
        ;
        return instanceQuery.count();
    }

    /**
     * 根据条件查询list集合  历史任务
     *
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    @Override
    public List<HistoricTaskInstance> findAllHisTask(Map<String, Object> wMap, List categorys, int pageNumber, int pagzSize) {
        int firstResult = pagzSize * (pageNumber - 1);
        int maxResult = pagzSize + firstResult;
        HistoricTaskInstanceQuery taskQuery = historyService.createHistoricTaskInstanceQuery().includeProcessVariables();
        taskQuery.processCategoryIn(categorys);
        if(wMap.get("userId") != null && !"".equals(wMap.get("userId")) ){
            taskQuery.taskAssignee(wMap.get("userId").toString());
        }
        if(wMap.get("state") != null && !"1".equals(wMap.get("state")) ){
            taskQuery.finished();
        }
        String condition = (String) wMap.get("condition");
        if (wMap.get("condition") != null && !wMap.get("condition").equals("")) {
            taskQuery.or().processVariableValueLike("summary", "%" + condition + "%");
            taskQuery.processVariableValueLike("cdp", "%" + condition + "%");
            taskQuery.endOr();
        }
        if (wMap.get("fdate") != null && !wMap.get("fdate").toString().equals("")) {
            taskQuery.processVariableValueGreaterThanOrEqual("cdt", wMap.get("fdate").toString());
        }
        if (wMap.get("edate") != null && !wMap.get("edate").toString().equals("")) {
            taskQuery.processVariableValueLessThanOrEqual("cdt", wMap.get("edate").toString());
        }
        List<HistoricTaskInstance> list = taskQuery.orderByProcessInstanceId().desc().listPage(firstResult, maxResult);
        return list;
    }

    /**
     * 查询历史任务数量
     *
     * @param wMap
     * @return
     */
    public long countHisTask(Map<String, Object> wMap, List categorys) {
        HistoricTaskInstanceQuery taskQuery = historyService.createHistoricTaskInstanceQuery().includeProcessVariables();
        String condition = (String) wMap.get("condition");
        if(wMap.get("userId") != null && !"".equals(wMap.get("userId")) ){
            taskQuery.taskAssignee(wMap.get("userId").toString());
        }
        if(wMap.get("state") != null && !"1".equals(wMap.get("state")) ){
            taskQuery.finished();
        }
        if (wMap.get("condition") != null && !wMap.get("condition").equals("")) {
            taskQuery.or().processVariableValueLike("summary", "%" + condition + "%");
            taskQuery.processVariableValueLike("cdp", "%" + condition + "%");
            taskQuery.endOr();
        }
        if (wMap.get("fdate") != null && !wMap.get("fdate").toString().equals("")) {
            taskQuery.processVariableValueGreaterThanOrEqual("cdt", wMap.get("fdate").toString());
        }
        if (wMap.get("edate") != null && !wMap.get("edate").toString().equals("")) {
            taskQuery.processVariableValueLessThanOrEqual("cdt", wMap.get("edate").toString());
        }
        return taskQuery.count();
    }

    /**
     * 根据实例ID 查询所属的任务 list
     *
     * @param proinstanceId
     * @return
     */
    @Override
    public List<HistoricTaskInstance> findProinstanceTaskList(String proinstanceId) {
        try {
            List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                    .processInstanceId(proinstanceId).orderByTaskCreateTime().desc()
                    .list();

            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找待待办任务
     *
     * @return
     */
    @Override
    public List<Task> findUndoTask(String userId, int pageNumber, int pagzSize, Map wmap, List categorys) {
        try {
            int firstResult = pagzSize * (pageNumber - 1);
            int maxResult = pagzSize + firstResult;
            TaskQuery taskQuery = null;
            if (userId == null || userId.equals(""))
                taskQuery = taskService.createTaskQuery().includeProcessVariables();
            else
                taskQuery = taskService.createTaskQuery().active().taskAssignee(userId).includeProcessVariables();
            taskQuery.processCategoryIn(categorys);
            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike("%" + wmap.get("name").toString() + "%");
            }
            if (wmap.get("userName") != null && !wmap.get("userName").toString().equals("")) {
                taskQuery.taskAssigneeLike("%" + wmap.get("userName").toString() + "%");
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", "%" + wmap.get("summary").toString() + "%");
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            List<Task> list = taskQuery.orderByTaskCreateTime().desc().listPage(firstResult, maxResult);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找待办理任务总数
     *
     * @return
     */
    @Override
    public long countUndoTask(String userId, Map wmap, List categorys) {
        try {
            TaskQuery taskQuery = null;
            if (userId == null || userId.equals(""))
                taskQuery = taskService.createTaskQuery().includeProcessVariables();
            else
                taskQuery = taskService.createTaskQuery().active().taskAssignee(userId).includeProcessVariables();
            taskQuery.processCategoryIn(categorys);
            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike(wmap.get("name").toString());
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", wmap.get("summary").toString());
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            return taskQuery.count();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找待认领任务
     *
     * @return
     */
    @Override
    public List<Task> findUnclaimedTask(List groups, int pageNumber, int pagzSize, Map wmap, List categorys) {
        try {
            int firstResult = pagzSize * (pageNumber - 1);
            int maxResult = pagzSize + firstResult;
            TaskQuery taskQuery = taskService.createTaskQuery().active().includeProcessVariables();
            taskQuery.processCategoryIn(categorys);
            if (groups != null && groups.size()> 0){
                taskQuery.or().taskCandidateGroupIn(groups).endOr();
            }
            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike("%" + wmap.get("name").toString() + "%");
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", "%" + wmap.get("summary").toString() + "%");
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            List<Task> list = taskQuery.orderByTaskCreateTime().desc().listPage(firstResult, maxResult);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找待认领任务总数
     *
     * @return
     */
    @Override
    public long countUnclaimedTask(List groups, Map wmap, List categorys) {
        try {
            //.taskCandidateUser(userId)
            TaskQuery taskQuery = taskService.createTaskQuery().active();
            taskQuery.processCategoryIn(categorys);
            if (groups != null && groups.size()> 0){
                taskQuery.or().taskCandidateGroupIn(groups).endOr();
            }
            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike(wmap.get("name").toString());
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", wmap.get("summary").toString());
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            return taskQuery.count();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
    /**
     * 查找待认领任务
     *
     * @return
     */
    @Override
    public List<Task> findUnclaimedTask(String userId, int pageNumber, int pagzSize, Map wmap, List categorys) {
        try {
            int firstResult = pagzSize * (pageNumber - 1);
            int maxResult = pagzSize + firstResult;
            TaskQuery taskQuery = taskService.createTaskQuery().active().taskCandidateUser(userId).includeProcessVariables();
            taskQuery.processCategoryIn(categorys);

            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike("%" + wmap.get("name").toString() + "%");
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", "%" + wmap.get("summary").toString() + "%");
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            List<Task> list = taskQuery.orderByTaskCreateTime().desc().listPage(firstResult, maxResult);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找待认领任务总数
     *
     * @return
     */
    @Override
    public long countUnclaimedTask(String userId, Map wmap, List categorys) {
        try {
            //.taskCandidateUser(userId)
            TaskQuery taskQuery = taskService.createTaskQuery().active().taskCandidateUser(userId);
            taskQuery.processCategoryIn(categorys);
            if (wmap.get("name") != null && !wmap.get("name").toString().equals("")) {
                taskQuery.taskNameLike(wmap.get("name").toString());
            }
            if (wmap.get("summary") != null && !wmap.get("summary").toString().equals("")) {
                taskQuery.processVariableValueLike("summary", wmap.get("summary").toString());
            }
            if (wmap.get("fdate") != null && !wmap.get("fdate").toString().equals("")) {
                taskQuery.taskCreatedAfter(sdf.parse(wmap.get("fdate").toString()));
            }
            if (wmap.get("edate") != null && !wmap.get("edate").toString().equals("")) {
                taskQuery.taskCreatedBefore(sdf.parse(wmap.get("edate").toString()));
            }
            return taskQuery.count();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查询正在办理组任务的成员
     *
     * @param taskId
     * @return
     */
    @Override
    public List<IdentityLink> getIdentityLinksForTask(String taskId) {
        try {
            List<IdentityLink> list = taskService.getIdentityLinksForTask(taskId);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查询人员列表
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<User> queryUsers(int pageNumber, int pageSize) {
        int firstResult = pageSize * (pageNumber - 1);
        int maxResult = pageSize + firstResult;
        return this.identityService.createUserQuery().orderByUserFirstName().asc().listPage(firstResult, maxResult);
    }

    /**
     * 查询流程定义列表
     *
     * @param pageNumber
     * @param pageSize
     * @param wmap
     * @return
     */
    public List<Model> queryModel(int pageNumber, int pageSize, Map wmap) {
        int firstResult = pageSize * (pageNumber - 1);
        int maxResult = pageSize + firstResult;
        ModelQuery modelQuery = this.repositoryService.createModelQuery().orderByCreateTime().desc();
        return modelQuery.listPage(firstResult, maxResult);
    }

    /**
     * 查询流程定义数量
     *
     * @param wmap
     * @return
     */
    public long countModel(Map wmap) {
        ModelQuery modelQuery = this.repositoryService.createModelQuery().orderByCreateTime().desc();
        return modelQuery.count();
    }

    public void deployed(String modelId, String deployName) {
        Model model = this.repositoryService.getModel(modelId);
        InputStream pngInput = null;
        try {
            if (model != null) {
                byte[] bs = this.repositoryService.getModelEditorSource(modelId);
                byte[] pngBs = this.repositoryService.getModelEditorSourceExtra(modelId);
                ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(bs);
                byte[] bpmnBytes = null;
                BpmnModel BpmModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
                bpmnBytes = new BpmnXMLConverter().convertToXML(BpmModel);
                String processName = model.getId() + ".bpmn20.xml";
                String processPng = model.getId() + ".png";
                pngInput = new ByteArrayInputStream(pngBs);
                if (deployName == null || "".equals(deployName))
                    deployName = model.getName();
                Deployment deployment = repositoryService.createDeployment()
                        .name(deployName)
                        .addString(processName, new String(bpmnBytes, "UTF-8"))
                        .addInputStream(processPng, pngInput)
                        .deploy();
            } else
                throw new ApplicationException("流程模板[" + modelId + "]查找失败！");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new ApplicationException(ex.getMessage(), ex);
        } finally {
            if (pngInput != null) {
                try {
                    pngInput.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }

    }

    /**
     * 新增流程model
     *
     * @param name
     * @param remark
     */
    public void createModel(String name, String remark,String category) {
        try {
            Model  model = repositoryService.newModel();
            model.setName(name);
            model.setVersion(1);
            model.setCategory(category);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            remark = StringUtils.defaultString(remark);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, remark);
            model.setMetaInfo(modelObjectNode.toString());
            this.repositoryService.saveModel(model);

            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", category);
            editorNode.put("stencilset", stencilSetNode);
            repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes("utf-8"));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new ApplicationException(ex.getMessage(), ex);
        }
    }
}
