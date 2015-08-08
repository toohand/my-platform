package com.lefthand.activiti.service;

import com.lefthand.activiti.domain.HisTask;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.data.domain.Page;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 工作流业务接口
 * Created by 潘锦发 on 2015/6/9.
 */
public interface ActivitiBusinessService {
    /**
     * 启动流程...
     * @param entityId 业务ID
     * @param bmpName  流程名
     * @param variables 变量
     */
    void startProcess(String bmpName, String entityId, Map<String, Object> variables);



    /**
     * 使用任务对象获取流程定义ID，查询流程定义对象
     *
     * @param taskId
     * @return
     */
    ProcessDefinition findProcessDefinitionByTaskId(String taskId);

    /**
     * 查看当前活动，获取当期活动对应的坐标x,y,width,height
     *
     * @param taskId
     * @return
     */
    Map<String, Object> findCoordingByTask(String taskId);

    /**
     * 根据任务ID 查找流程业务的business_key  业务类+业务实体ID
     *
     * @param taskId
     * @return
     */
    String findEntityIdByTask(String taskId);

    /**
     * 已知任务ID
     *
     * @param taskId
     * @return
     */
    List<String> findOutComeListByTaskId(String taskId);

    /**
     * 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
     *
     * @param taskId
     * @return
     */
    List<Comment> findCommentByTaskId(String taskId);

    /**
     * 完成任务，传入变量数据，定向流程的走向..
     *
     * @param taskId   任务ID
     * @param comment  回复的批注
     * @param outcome  连线名
     * @param variables 变量名
     * @param userId   当前办理人的ID
     */
    ProcessInstance completeTask(String taskId,
                             String comment,
                             String outcome,
                             Map<String, Object> variables,
                             String userId//
    );

    /**
     * 根据业务实体ID，查询历史回复
     *
     * @param entityId
     * @return
     */
    List<Comment> findCommentByEntityId(String entityId, String business);

    /**
     * terms包含(时间段 startDate - endDate)
     * 获取当前人的已经办理的任务信息
     *
     * @param userId
     * @param pageNumber
     * @param pagzSize
     * @param terms
     * @return
     */
    Page<HisTask> completeTaskByUserId(String userId, int pageNumber, int pagzSize, Map<String, Object> terms);

    /**
     * 查看部署图片
     * @param depId
     * @param imgName
     * @return
     */
    InputStream findImageInputStream(String depId, String imgName);

    /**
     * 根据当前任务的ID 查找流程实例对象....可判断当前的流程是否走完
     * 如果返回的流程实例为null 表明该流程已经全部结束，可更改业务状态
     *
     * @param taskId
     * @return
     */
    ProcessInstance getProcessInstance(String taskId);

    /**
     * 根据流程ID 查找流程业务的business_key  业务类+实体ID,历史流程实例
     *
     * @return
     */
    String findBusinessKeyByPiHistoric(String ProcessInstanceId);

    /**
     * 进行会签操作
     * 所有进入会签的用户完成任务后 才能流到下一个任务
     *
     * @param taskId    当前任务的ID
     * @param userCodes 会签人帐号集合
     */
    void countersignProcess(String taskId, List<String> userCodes);

    /**
     * 根据任务ID  获取单一的任务实例对象
     * @param taskId
     * @return
     */
    Task findTaskById(String taskId);

    /**
     * 根据当前人获取未办理的任务总数
     *
     * @param userId
     * @return
     */
    long getTaskTotalByUserId(String userId);

    /**
     * 委托另外一个人去办理任务，保存原办理人的信息在任务中，委托后的任务在新的委托人待办中
     *
     * @param taskId
     * @param oldUserId
     * @param newUserId
     */
    void delegation(String taskId, String oldUserId, String newUserId);



    /**
     * 认领任务,认领后其他人都不能认领
     *
     * @param taskId
     * @param userId
     */
    void claimTask(String taskId, String userId);

    /**
     * 从认领的任务 回退到组任务 让其他人认领
     *
     * @param taskId
     */
    void rollbackGroupTask(String taskId);

    /**
     * 查询正在办理组任务的成员
     * @param taskId
     * @return
     */
    List<IdentityLink> getIdentityLinksForTask(String taskId);



    /**
     * 获取流程form值
     * @param taskId    任务Id
     * @param sfix      变量设置的开始值
     */
     List<FormProperty> findFormProperties(String taskId,String sfix);

    /**
     * 根据流程定义ID和ActivityId获取ActivityImpl
     * @param processDefinitionId  流程定义id
     * @param activityId  activityId
     * @return
     */
    public ActivityImpl findActivityImpl( String processDefinitionId,String activityId);

}
