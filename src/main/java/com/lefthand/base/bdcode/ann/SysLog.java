package com.lefthand.base.bdcode.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统日志注解
 * @author hp
 *
 */
@Target(ElementType.METHOD)    
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SysLog {
    /**
     * 方法描述
     * @return
     */
	public String description() default "";
	
	 /**
     * 具体描述精确值变量
     * @return
     */
	public String definite() default "";
	
	/**
	 * 分类
	 * @return
	 */
	public String classified() default "";
	
	

}
