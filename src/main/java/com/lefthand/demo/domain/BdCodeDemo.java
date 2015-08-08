package com.lefthand.demo.domain;


import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.util.Date;

@EntityClass(title="代码生成器Demo",
			  description="代码生成器Demo",
			  author="hp",
              packageName = "com.huge.demo",
              jsppath="demo/",table = "HG_SYS_DEMO",key="id")
public class BdCodeDemo {
	@EntityField(columName = "id", fieldLabel="主键",hidden=true)
	private Long id;
	@EntityField(columName = "name",fieldLabel="名称",search=true,inGrid=true )
	private String name;
	@EntityField(columName = "remark",fieldLabel="描述",search=true,inGrid=true)
	private String remark;
	@EntityField(columName = "sex",fieldLabel="性别",inGrid=true,type="radio",mapname="sexs")
	private int sex;
	@EntityField(columName = "hobby",fieldLabel="爱好",inGrid=true,type="checkbox",mapname="hobbys")
	private String hobby;
	@EntityField(columName = "classes",fieldLabel="班级",inGrid=true,type="combox",mapname="classess")
	private int classes;
	@EntityField(columName = "cdt",fieldLabel="创建日期",search=false,inGrid=true,type="date")
	private Date cdt;
	@EntityField(columName = "cdp",fieldLabel="创建人",search=true,inGrid=true)
	private String cdp ;
	//班级名称
	private String classesName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
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

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
}
