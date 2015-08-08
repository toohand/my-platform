package com.lefthand.activiti.domain;

import java.io.Serializable;

/**
 * Created by PanjinF on 2015/6/15.
 */
public class MyProcessInstance implements Serializable {
    private Long id;
    private String BusinessKey;
    private String ProcessInstanceId;
    private String ActivityId;
    private Integer Suspended;
    private String processDefinitionId;
    private MyProcessDefinition processDefinition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return BusinessKey;
    }

    public void setBusinessKey(String businessKey) {
        BusinessKey = businessKey;
    }

    public String getProcessInstanceId() {
        return ProcessInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        ProcessInstanceId = processInstanceId;
    }

    public String getActivityId() {
        return ActivityId;
    }

    public void setActivityId(String activityId) {
        ActivityId = activityId;
    }

    public Integer getSuspended() {
        return Suspended;
    }

    public void setSuspended(Integer suspended) {
        Suspended = suspended;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public MyProcessDefinition getProcessDefinition() {
        return processDefinition;
    }

    public void setProcessDefinition(MyProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

}
