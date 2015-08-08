package com.lefthand.system.domain;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.util.Date;

@EntityClass(title = "portal管理",
        description = "portal新增、删除、修改",
        packageName = "com.huge.system", jsppath = "system/jsp/", key = "id"
        , table = "HG_SYS_PORTAL")
public class SysPortal {
    @EntityField(fieldLabel="主键",hidden=true,search=false)
    private Long id;
    @EntityField(fieldLabel="标题",hidden=false,search=true,size=50,inGrid=true)
    private String title;
    @EntityField(fieldLabel="描述",hidden=false,search=true,size=100,inGrid=true)
    private String remark;
    @EntityField(fieldLabel="链接",hidden=false,search=true,size=200,inGrid=true)
    private String url;
    @EntityField(fieldLabel="配置",hidden=false,search=true,size=1000,inGrid=true)
    private String cfg;
    @EntityField(fieldLabel="系统标示",hidden=false,search=false,size=100)
    private String flag;
    @EntityField(fieldLabel="状态  0:停用，1启用",hidden=false,search=false,size=100)
    private int state;
    @EntityField(fieldLabel="创建时间",hidden=false,search=false)
    private Date cdt;
    @EntityField(fieldLabel="创建人",hidden=false,search=false)
    private Date cdp;

    public Long getId(){
        return id;
    }
    public void  setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getCfg() {
        return cfg;
    }
    public void setCfg(String cfg) {
        this.cfg = cfg;
    }

    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }

    public Date getCdt() {
        return cdt;
    }

    public void setCdt(Date cdt) {
        this.cdt = cdt;
    }

    public Date getCdp() {
        return cdp;
    }

    public void setCdp(Date cdp) {
        this.cdp = cdp;
    }
}