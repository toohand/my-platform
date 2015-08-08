package com.lefthand.system.domain;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.util.Date;

@EntityClass(title = "数据字典管理",
        description = "portal新增、删除、修改",
        packageName = "com.huge.system", jsppath = "system/jsp/", key = "id"
        , table = "HG_SYS_Dictionary")
public class SysDictionary {
    @EntityField(fieldLabel="主键",hidden=true,search=false)
    private Long id;
    @EntityField(columName="dty_name",fieldLabel="名称",hidden=false,search=true,size=50,inGrid=true)
    private String dtyName;
    @EntityField(columName = "type_id",fieldLabel="分类ID",hidden=false,size=200,inGrid=true)
    private String typeId;
    @EntityField(columName = "type_name",fieldLabel="分类名称",hidden=false,search=true,size=1000,inGrid=true)
    private String typeName;
    @EntityField(columName ="sort_code" ,fieldLabel="排序码",hidden=false,search=false,size=100,inGrid=true)
    private int sortCode;
    //0:停用，1启用
    @EntityField(fieldLabel="状态",hidden=false,search=true,size=100,inGrid=true)
    private int state;
    @EntityField(fieldLabel="描述",hidden=false,size=100,inGrid=true)
    private String remark;
    @EntityField(fieldLabel="创建时间",inGrid=true)
    private Date cdt;
    @EntityField(fieldLabel="创建人",inGrid=true)
    private String cdp;


    public Long getId(){
        return id;
    }
    public void  setId(Long id){
        this.id = id;
    }

    public String getDtyName() {
        return dtyName;
    }

    public void setDtyName(String dtyName) {
        this.dtyName = dtyName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getCdp() {
        return cdp;
    }

    public void setCdp(String cdp) {
        this.cdp = cdp;
    }
}