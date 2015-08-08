package com.lefthand.activiti.service.impl;

import com.lefthand.activiti.dao.ActivitiBusinessDao;
import com.lefthand.activiti.dao.ActivitiManageDao;
import com.lefthand.activiti.domain.HisTask;
import com.lefthand.activiti.service.ActivitiBusinessService;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工作流业务接口
 * Created by 潘锦发 on 2015/6/9.
 */
@Service
@Transactional
public class ActivitiBusinessServiceImpl implements ActivitiBusinessService {

    private static Logger logger = LoggerFactory.getLogger(ActivitiBusinessServiceImpl.class);

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
    private ActivitiBusinessDao activitiBusinessDao;
    @Autowired
    private ActivitiManageDao activitiManageDao;

    /**
     * 启动流程...
     * 绑定业务
     * variables 变量 在控制层中根据业务设置当前办理人，和绑定流程的业务KEY
     * businessName 业务类名称
     *
     * @param entityId
     * @param businessName
     * @param variables
     */
    @Override
    public void startProcess(String businessName, String entityId, Map<String, Object> variables) {
        try {
            String BUSINESS_KEY = businessName + "." + entityId;
            variables.put("BUSINESS_KEY", BUSINESS_KEY);
            ProcessInstance pi = runtimeService.startProcessInstanceByKey(businessName, BUSINESS_KEY, variables);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }


    /**
     * 使用任务对象获取流程定义ID，查询流程定义对象
     * 对应 act_re_procdef
     *
     * @param taskId
     * @return
     */
    @Override
    public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
        try {
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult(); //使用任务ID 查询任务对象
            String processDefinitionId = task.getProcessDefinitionId();//获取流程定义的ID
            ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()//创建流程定义查询对象
                    .processDefinitionId(processDefinitionId)//使用流程定义ID查询
                    .singleResult();
            return pd;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查看当前活动，获取当期活动对应的坐标x,y,width,height
     *
     * @param taskId
     * @return
     */
    @Override
    public Map<String, Object> findCoordingByTask(String taskId) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();//存放坐标
            Task task = taskService.createTaskQuery().taskId(taskId)//使用任务ID,查询对象
                    .singleResult();
            String processDefinitionId = task.getProcessDefinitionId();//获取流程定义ID
            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                    .getProcessDefinition(processDefinitionId);//获取流程定义的实体对象（对应.bpmn文件中的数据）
            String processInstanceId = task.getProcessInstanceId();//流程实例ID

            //使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
            ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
                    .processInstanceId(processInstanceId)//使用流程实例ID查询
                    .singleResult();
            String activityId = pi.getActivityId();//获取当前活动的ID

            ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId); //获取当前活动对象

            map.put("x", activityImpl.getX());//获取坐标
            map.put("y", activityImpl.getY());//获取坐标
            map.put("width", activityImpl.getWidth());//获取坐标
            map.put("height", activityImpl.getHeight());//获取坐标
            map.put("taskpersonal", task.getAssignee());//获取坐标
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据流程ID 查找流程业务的business_key  业务类+申请单ID
     *
     * @return
     */
    @Override
    public String findBusinessKeyByPiHistoric(String ProcessInstanceId) {
        try {
            HistoricProcessInstance hi = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(ProcessInstanceId)
                    .singleResult();

            String BUSINESS_KEY = hi.getBusinessKey();//使用流程实例对象获取BUSINESS_KEY
            return BUSINESS_KEY;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 进行会签操作
     * 所有进入会签的用户完成任务后 才能流到下一个任务
     *
     * @param taskId    当前任务的ID
     * @param userCodes 会签人帐号集合
     */
    @Override
    public void countersignProcess(String taskId, List<String> userCodes) {
        try {
            for (String userCode : userCodes) {
                TaskEntity task = (TaskEntity) taskService.newTask();
                task.setAssignee(userCode);
                Task task1 = findTaskById(taskId);
                task.setName(task1.getName() + "-会签");
                ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                        .getProcessDefinition(task1.getProcessDefinitionId());
                task.setProcessDefinitionId(processDefinitionEntity.getId());
                task.setProcessInstanceId(task1.getProcessInstanceId());
                task.setParentTaskId(taskId);
                task.setDescription("jointProcess");
                taskService.saveTask(task);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据任务ID 查找流程业务的business_key  业务类+申请单ID
     *
     * @param taskId
     * @return
     */
    @Override
    public String findEntityIdByTask(String taskId) {
        try {
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();//根据任务ID查询任务对象
            String pi = task.getProcessInstanceId();//获取流程实例ID
            ProcessInstance pit = runtimeService.createProcessInstanceQuery().processInstanceId(pi).singleResult();
            String BUSINESS_KEY = pit.getBusinessKey(); //使用流程实例对象获取BUSINESS_KEY
            String entityId = "";
            if (StringUtils.isNotBlank(BUSINESS_KEY)) {//截取字符串
                entityId = BUSINESS_KEY.split("\\.")[1];
            }
            return entityId;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中
     *
     * @param taskId
     * @return
     */
    @Override
    public List findOutComeListByTaskId(String taskId) {
        try {
            List list = new ArrayList(); //返回存放连线的名称集合
            Task task = taskService.createTaskQuery()//1:使用任务ID，查询任务对象
                    .taskId(taskId)//使用任务ID查询
                    .singleResult();
            if (task == null) {
                logger.error("任务[" + taskId + "]读取失败，任务已经处理");
                return null;
            }
            String processDefinitionId = task.getProcessDefinitionId();//2：获取流程定义ID
            //3：查询ProcessDefinitionEntiy对象
            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                    .getProcessDefinition(processDefinitionId);
            //使用任务对象Task获取流程实例ID
            String processInstanceId = task.getProcessInstanceId();
            //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
            ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                    .processInstanceId(processInstanceId)//使用流程实例ID查询
                    .singleResult();

            String activityId = pi.getActivityId();//获取当前活动的id

            ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//4：获取当前的活动

            List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();//5：获取当前活动完成之后连线的名称
            if (pvmList != null && pvmList.size() > 0) {
                for (PvmTransition pvm : pvmList) {
                    Map step = new HashMap();
                    step.put("OptName", pvm.getProperty("name"));
                    PvmActivity pvmActivity = pvm.getDestination();
                    step.put("activityId", pvmActivity.getId());
                    step.put("activityName", pvmActivity.getProperty("name"));
                    list.add(step);
                }
            }
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
     * <p/>
     * 流程实例ID
     *
     * @param id
     * @return
     */
    @Override
    public List<Comment> findCommentByTaskId(String id) {
        try {
            //使用当前的任务ID，查询当前流程对应的历史任务ID
            //使用当前任务ID，获取当前任务对象
            Task task = taskService.createTaskQuery()//
                    .taskId(id)//使用任务ID查询
                    .singleResult();
            String processInstanceId = task.getProcessInstanceId();//获取流程实例ID
            //使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
            List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 完成任务，传入变量数据，定向流程的走向..
     *
     * @param taskId    任务ID
     * @param comment   回复
     * @param outcome   连线名
     * @param variables 变量
     * @param userId    审批人ID
     */
    @Override
    public ProcessInstance completeTask(String taskId, String comment, String outcome, Map<String, Object> variables, String userId) {
        try {
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            if (task == null)
                return null;
            if (outcome != null && !"".equals(outcome)) {
                taskService.setVariable(taskId, "outcome", outcome);
            }
            String processInstanceId = task.getProcessInstanceId();
            Authentication.setAuthenticatedUserId(userId);
            if (comment != null && !"".equals(comment))//设置批注的信息
                taskService.addComment(taskId, processInstanceId, comment);
            taskService.complete(taskId, variables);
            ProcessInstance pi = runtimeService.createProcessInstanceQuery()//使用流程实例ID查询
                    .processInstanceId(processInstanceId).singleResult();
            return pi;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据业务实体ID，查询历史回复
     *
     * @param entityId
     * @return
     */
    @Override
    public List<Comment> findCommentByEntityId(String entityId, String business) {
        try {
            String BUSINESS_KEY = business + "." + entityId;
            HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery()//对应历史的流程变量表
                    .variableValueEquals("BUSINESS_KEY", BUSINESS_KEY)//使用流程变量的名称和流程变量的值查询
                    .singleResult();

            String processInstanceId = null;//流程实例ID
            if (hvi != null) {
                processInstanceId = hvi.getProcessInstanceId();
            }
            List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 获取当前人的已经办理的任务信息list集合
     *
     * @param userId
     * @param pageNumber
     * @param pagzSize
     * @param terms
     * @return
     */
    @Override
    public Page<HisTask> completeTaskByUserId(String userId, int pageNumber, int pagzSize, Map<String, Object> terms) {
        try {
            PageRequest pageRequest = new PageRequest(pageNumber - 1, pagzSize);
            return activitiBusinessDao.findAllHisTaskByUserId(pageRequest, terms, userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 查找部署的图片对象
     *
     * @param depId   部署流程ID
     * @param imgName
     * @return
     */
    @Override
    public InputStream findImageInputStream(String depId, String imgName) {
        try {
            InputStream in = repositoryService.getResourceAsStream(depId, imgName);
            return in;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据当前任务的ID 查找流程实例对象....可判断当前的流程是否走完,如果流程实例为空，则表示流程已经完毕
     *
     * @param taskId
     * @return
     */
    @Override
    public ProcessInstance getProcessInstance(String taskId) {
        try {
            Task task = taskService.createTaskQuery()//
                    .taskId(taskId)//使用任务ID查询
                    .singleResult();
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                    .processInstanceId(processInstanceId)//使用流程实例ID查询
                    .singleResult();
            return pi;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据流程定义ID和ActivityId获取ActivityImpl
     *
     * @param processDefinitionId 流程定义id
     * @param activityId          activityId
     * @return
     */
    public ActivityImpl findActivityImpl(String processDefinitionId, String activityId) {
        try {
            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                    .getProcessDefinition(processDefinitionId);
            ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
            return activityImpl;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * 根据任务ID  获取单一的任务实例对象
     *
     * @param taskId
     * @return
     */
    @Override
    public Task findTaskById(String taskId) {
        try {
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            return task;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据当前人获取未办理的任务总数
     *
     * @param userId
     * @return
     */
    @Override
    public long getTaskTotalByUserId(String userId) {
        try {
            long total = taskService.createTaskQuery().taskAssignee(userId).count();
            return total;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 委托另外一个人去办理任务，保存原办理人的信息在任务中，委托后的任务在新的委托人待办中
     *
     * @param taskId
     * @param oldUserId
     * @param newUserId
     */
    @Override
    public void delegation(String taskId, String oldUserId, String newUserId) {
        try {
            if (oldUserId != null && !oldUserId.equals("")) {
                taskService.setOwner(taskId, oldUserId);
            }
            taskService.setAssignee(taskId, newUserId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }


    /**
     * 认领任务
     *
     * @param taskId
     * @param userId
     */
    @Override
    public void claimTask(String taskId, String userId) {
        try {
            taskService.claim(taskId, userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 从认领的任务 回退到组任务 让其他人认领
     *
     * @param taskId
     */
    @Override
    public void rollbackGroupTask(String taskId) {
        try {
            taskService.setAssignee(taskId, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
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
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }



    @Override
    public List<FormProperty> findFormProperties(String taskId, String sfix) {
        List<FormProperty> result = new ArrayList<>();
        try {
            List<FormProperty> list = formService.getTaskFormData(taskId).getFormProperties();
            for (FormProperty f : list) {
                if (sfix != null && !sfix.equals("")) {
                    if (f.getId().startsWith(sfix)) {
                        result.add(f);
                    }
                } else
                    result.add(f);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
        return result;
    }
}
