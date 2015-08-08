package com.lefthand.base.bdcode.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代码生成器实体注解
 * @author hp
 *
 */
@Target(ElementType.TYPE)  
@Retention(RetentionPolicy.RUNTIME)
@Inherited 
public @interface EntityClass {
    /**
     * 生成类说明
     * @return
     */
	public String description() default "注解说明";
	/** 
	 *生成包的名称
	*/ 
	public String packageName() default "";
	/** 
	 * Title内容<br/>
	 * @return Title内容 
	*/ 
	public String title() default "";

	/**
	 * Title内容<br/>
	 * @return Title内容
	 */
	public String author() default "codeBuilder";
	/**
	 * jsppath 文件生成路径
	 * @return
	 */
	public String jsppath() default "";

	
	/**
	 * 主键
	 * @return
	 */
	public String key() default "id";

	/**
	 * 表名称
	 * @return
	 */
	public String table() default "" ;

}
