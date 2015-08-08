package com.lefthand.base.bdcode.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface EntityField {

	public String columName() default "";
	/**
	 * 是否查询
	 * @return
	 */
	public boolean search() default false;
	
	/**
	 * 是否在列表显示
	 * @return
	 */
	public boolean hidden() default false;
	
	/**
	 * 是否在列表显示
	 * @return
	 */
	public boolean inGrid() default false;
	
	/**
	 * 中文名称
	 * @return
	 */
	public String fieldLabel() default "";
	
	/**
	 * 占列宽度
	 * @return
	 */
	public int colWith() default 100;
	
	/**
	 * 字符长度
	 * @return
	 */
	public int size() default 200;
	
	/**
	 * type 编辑类型:text,checkbox,combox,date,radio
	 * @return
	 */
	public String type() default "text";
	/**
	 * 当type checkbox,combox,radio 时候下拉列表Map定义
	 * @return
	 */
    public String mapname() default "map";
    
    /**
	 * 注释描述
	 * @return
	 */
    public String remark() default "";

}
