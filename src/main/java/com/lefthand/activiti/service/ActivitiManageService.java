package com.lefthand.activiti.service;

import com.lefthand.activiti.domain.MyProcessDefinition;
import com.lefthand.activiti.domain.MyTask;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.*;
import org.springframework.data.domain.Page;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 流程管理服务接口
 * Created by 潘锦发 on 2015/6/10.
 */
public interface ActivitiManageService {
    /**
     * 暂停流程定义
     * 根据ProcessDefinitionKey 流程定义的KEY
     * 当一个流程定义被暂停，一个新的流程实例不会被创建（一个异常将会被抛出）
     *
     * @param ProcessDefinitionKey
     */
    void suspendProcessDefinitionBykey(String ProcessDefinitionKey);

    /**
     * 激活流程定义
     * 根据流程定义的KEY
     *
     * @param ProcessDefinitionKey
     */
    void activateProcessDefinition(String ProcessDefinitionKey);

    /**
     * 暂停流程实例
     * 根据流程实例的ID
     * 当暂停的时候，这个流程不会继续下去并且没有计划会被执行
     *
     * @param processInstanceId
     */
    void suspendProcessInstance(String processInstanceId);

    /**
     * 激活流程实例
     * 根据流程实例ID
     *
     * @param processInstanceId
     */
    void activateProcessInstance(String processInstanceId);

    /**
     * 根据流程实例ID  查询单一的 流程实例
     *
     * @param ProcessInstanceId
     * @return
     */
    ProcessInstance findProcessInstanceBypiId(String ProcessInstanceId);

    /**
     * 上传部署文件，zip流
     *
     * @param deployName
     * @param in
     * @return
     */
    String deployUpload(InputStream in, String deployName);

    /**
     * 查询部署对象的总数
     * 对应查询act_re_deployment
     *
     * @return
     */
    Long queryDeploymentCount();



    /**
     * 删除部署
     *
     * @param id
     * @return
     */
    void deleteProcessDefinitionByDeploymentId(String id);

    /**
     * 查看流程图
     *
     * @param id
     * @param imgName
     * @return
     */
    InputStream findImageInputStream(String id, String imgName);

    /**
     * 查询流程定义的信息
     * 查询流程定义的信息 单一查询
     * 查询 act_re_procdef
     *
     * @param deploymentId
     * @return
     */
    ProcessDefinition queryProcessDefinition(String deploymentId);

    /**
     * 查询流程定义的总数
     * 对应查询act_re_deployment
     *
     * @return
     */
    Long queryProcessDefinitionCount();

    /**
     * 根据部署ID 查询单一的部署对象
     *
     * @param deployId
     * @return
     */
    Deployment queryDeployment(String deployId);

    /**
     * 管理员操作
     * 中止流程任务，根据任务ID
     *
     * @param taskId
     */
    void endProcessTask(String taskId);

    /**
     * 根据任务ID  获取单一的任务实例对象
     *
     * @param taskId
     * @return
     */
    Task findTaskById(String taskId) throws Exception;

    /**
     * 根据条件查询list集合
     *
     * @param terms
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    Page<MyProcessDefinition> findAllProcessDefinition(Map<String, Object> terms, int pageNumber,int pagzSize);

    /**
     * 根据条件查询list集合  流程实例
     *
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    List<ProcessInstance> findAllProcessInstance(Map<String, Object> wMap, int pageNumber,int pagzSize);
    /**
     * 根据条件查询流程实例总数
     *
     * @param wMap
     * @return
     */
    long countAllProcessInstance(Map<String, Object> wMap);

    /**
     * 根据条件查询list集合  任务对象
     *
     * @param terms
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    Page<MyTask> findAllProcessTask(Map<String, Object> terms, int pageNumber,int pagzSize);
    /**
     * 根据条件查询list集合  历史实例
     *
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    public List<HistoricProcessInstance> findAllHisProcinst(Map<String, Object> wMap, int pageNumber, int pagzSize);

    /**
     * 获取流程历史实例数量
     * @param wMap
     * @return
     */
    public long countHisProcinst(Map<String, Object> wMap);

    /**
     * 查询历史任务
     * @param wMap
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    public List<HistoricTaskInstance> findAllHisTask(Map<String, Object> wMap,List categorys, int pageNumber, int pagzSize);

    /**
     * 获取流程历史任务数量
     * @param wMap
     * @return
     */
    public long countHisTask(Map<String, Object> wMap,List categorys);

    /**
     * 根据实例ID 查询所属的任务 list
     *
     * @param proinstanceId
     * @return
     */
    List<HistoricTaskInstance> findProinstanceTaskList(String proinstanceId);

    /**
     * 查找待办任务
     * @param userId  办理人
     * @param pageNumber 页码
     * @param pagzSize   每页记录数
     * @param wmap   查询条件
     * @return
     */
    public List<Task> findUndoTask(String userId, int pageNumber, int pagzSize, Map wmap,List categorys);

    /**
     * 查询待办任务总数
     * @param userId 办理人
     * @param wmap   查询条件
     * @return
     */
    long countUndoTask(String userId,Map wmap,List categorys);
    /**
     * 查询待办认领任务
     *
     * @param groups 用户组
     * @return
     */
    List<Task> findUnclaimedTask(List groups, int pageNumber, int pagzSize,Map wmap,List categorys);

    /**
     * 查询待认领任务总数
     *
     * @param groups
     * @return
     */
    long countUnclaimedTask(List groups,Map wmap,List categorys);

    /**
     * 查询待办认领任务
     *
     * @param userId 用户
     * @return
     */
    List<Task> findUnclaimedTask(String userId, int pageNumber, int pagzSize,Map wmap,List categorys);

    /**
     * 查询待认领任务总数
     *
     * @param userId
     * @return
     */
    long countUnclaimedTask(String userId,Map wmap,List categorys);

    /**
     * 查询正在办理组任务的成员
     * @param taskId
     * @return
     */
    List<IdentityLink> getIdentityLinksForTask(String taskId);

    /**
     * 查询任务流程图
     * @param instanceId
     * @return
     */
     InputStream findTaskImage( String instanceId);

    /**
     * 查询人员列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
     List<User> queryUsers(int pageNumber,int pageSize);

    /**
     * 查询流程定义列表
     * @param pageNumber
     * @param pageSize
     * @param wmap
     * @return
     */
    public List<Model> queryModel(int pageNumber,int pageSize, Map wmap);
    /**
     * 查询流程定义数量
     * @param wmap
     * @return
     */

    public long countModel( Map wmap);

    /**
     * 根据流程Id发布流程
     */
    public void deployed(String modelId,String deployName);

    /**
     * 新增流程模板
     */
    public void createModel(String name,String remark,String category);
}
