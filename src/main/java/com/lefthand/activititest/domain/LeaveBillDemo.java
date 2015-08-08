package com.lefthand.activititest.domain;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假申请表 实体类
 * Created by PanjinF on 2015/5/20.
 */
@EntityClass(title="请假流程Demo",
        description="请假流程Demo",
        author="hp",
        packageName = "com.huge.activiti",
        jsppath="activititest/",table = "HG_LEAVE_BILL_DEMO",key="id")
public class LeaveBillDemo implements Serializable{

    @EntityField(columName = "id", fieldLabel="主键",hidden=true)
    private Long id;
    @EntityField(columName = "log_name", fieldLabel="申请人",inGrid = true,search = true)
    private String loginName;
    @EntityField(columName = "post_name", fieldLabel="职务")
    private String postName;
    @EntityField(columName = "day", fieldLabel="请假天数" ,inGrid = true)
    private double day;
    /**
     * 假期类型,1病假，2事假，3年假，4陪产假，5婚嫁，6停薪留职
     */
    @EntityField(columName = "leave_type", fieldLabel="假期类型",type="combox",mapname = "leaveTypeMap",inGrid = true)
    private Integer leaveType;
    /**
     * 申请状态,0申请，1审批中，2通过，3，不通过。
     */
    @EntityField(columName = "state", fieldLabel="状态",type="radio",mapname = "leaveStateMap",inGrid = true,search = true)
    private Integer state;

    @EntityField(columName = "content", fieldLabel="请假理由")
    private String content;
    @EntityField(columName = "create_time", fieldLabel="申请时间")
    private Date createTime;
    @EntityField(columName = "update_time", fieldLabel="批准时间")
    private Date updateTime;
    @EntityField(columName = "start_time", fieldLabel="开始时间",inGrid = true)
    private Date startTime;
    @EntityField(columName = "end_time", fieldLabel="结束时间",inGrid = true)
    private Date endTime;
    @EntityField(columName = "user_id", fieldLabel="申请人ID")
    private String userId;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
