package com.lefthand.activititest.domain;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假申请表 实体类
 * Created by PanjinF on 2015/5/20.
 */
@EntityClass(title="矛盾上报Demo",
        description="矛盾上报Demo",
        author="hp",
        packageName = "com.huge.activititest",
        jsppath="activititest/",table = "HG_CONTRADICTION_DEMO",key="id")
public class ContradictionDemo implements Serializable{

    @EntityField(columName = "id", fieldLabel="主键",hidden=true)
    private Long id;
    @EntityField(columName = "cdp", fieldLabel="上报人",inGrid = true,search = true)
    private String cdp;
    @EntityField(columName = "post", fieldLabel="岗位")
    private String post;
    @EntityField(columName = "summary", fieldLabel="摘要" ,inGrid = true)
    private String summary;
    @EntityField(columName = "remark", fieldLabel="详细描述")
    private String remark;
    @EntityField(columName = "cdt", fieldLabel="上报时间")
    private Date cdt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdp() {
        return cdp;
    }

    public void setCdp(String cdp) {
        this.cdp = cdp;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCdt() {
        return cdt;
    }

    public void setCdt(Date cdt) {
        this.cdt = cdt;
    }
}
