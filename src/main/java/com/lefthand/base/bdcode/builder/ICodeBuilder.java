package com.lefthand.base.bdcode.builder;

import java.util.Map;



/**
 * 图南代码生成器接口
 * @author hp
 *
 */
public interface ICodeBuilder {
	/** 
	 * description:	通过注解获得解析的信息集合
	 * @param cls	需要解析的类
	 * @return  	信息集合(对应模板文件需要的信息)
	*/ 
	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls) ;
	
	/** 
	 * description:	通过注解获得解析的信息集合
	 * @param cls	需要解析的类
	 * @param map	初始信息集合
	 * @return  	信息集合(对应模板文件需要的信息)
	*/ 
	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls, Map<String, Object> map) ;

	/** 
	 * description:		输入对象解析后的参数信息生成代码 并将文件放到默认的目录中
	 * @param data 		解析后的参数信息
	*/ 
	public void buildCode(Map<String, Object> data);
	
	/** 
	 * description:		输入对象解析后的参数信息生成代码
	 * @param data 		解析后的参数信息
	 * @param libUrl  	需要生成的代码项目路径
	*/ 
	public void buildCode(Map<String, Object> data, String libUrl);
	
	
	/** 
	 * description:		输入对象解析后的参数信息生成代码
	 * @param data 		解析后的参数信息
	 * @param libUrl  	需要生成的代码项目路径
	 * @param url  		需要生成的代码包路径
	*/ 
	public void buildCode(Map<String, Object> data, String libUrl, String url);
	
}
