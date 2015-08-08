package com.lefthand.base.bdcode.builder;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 * 代码生成器通用类
 * @author hp
 *
 */
public class DTOCodeBuilder extends BaseCodeBuilder {
	
	/** 
	 * description:	通过注解获得解析的信息集合
	 * @param cls	需要解析的类
	 * @return  	信息集合(对应模板文件需要的信息)
	*/ 
	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls) {
		return createMap(cls, null);
	}

    /**
     * 返回模板的基础路径
     */
	public String getTemplateDir() {
		return "template";
	}

	/**
	 * 返回模板的名称
	 */
	@Override
	public String getTemplateName() {
		return "DTOTemplate.html";
	}
	
	/**
	 * 源代码根路径
	 */
	@Override
	public String getRootUrl() {
		return "src\\main\\java\\";
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls, Map<String, Object> initMap) {
		Map<String, Object> map = initMap==null ? new HashMap<String, Object>():initMap;
		if (!cls.isAnnotationPresent(EntityClass.class)) {
			return null;
		}
		
		map.put("importClass", new HashSet<String>());
		EntityClass entityClass = (EntityClass) cls.getAnnotation(EntityClass.class);
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		map.put("ctime",time);
		map.put("description", entityClass.description());
		map.put("title", entityClass.title());
		map.put("key", entityClass.key());
		map.put("packagename", entityClass.packageName());
		map.put("jsppath", entityClass.jsppath());
		map.put("author", entityClass.author());
		setPath(map, entityClass.packageName() + ".controller", cls, "actionPath");
		setPath(map, entityClass.packageName()+".service.impl", cls, "servicePath");
		setPath(map, entityClass.packageName()+".service", cls, "iServicePath");
		setPath(map, entityClass.packageName()+".dao.mapper", cls, "daoPath");
		setPath(map, entityClass.packageName()+".dao.mapper", cls, "iDaoPath");
		String name = cls.getSimpleName();
		map.put("name", name);

		String classPath = (String) map.get("packagename");
		String url =this.getUrl(classPath, name + ".java");
		map.put("importClass", new HashSet<String>());
		map.put("importTypes", new HashSet<String>());
		map.put("url", url);
		List<Map<String, Object>> fsList = new ArrayList<Map<String, Object>>();
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs) {
			EntityField field = f.getAnnotation(EntityField.class);
			if (field != null) {
				setEntityField(field, f, map,null,fsList);
			}
		}	
		map.put("fields", fsList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	protected void setEntityField(EntityField field,Field f,Map<String,Object> map,Map<String, Object> fMap,List<Map<String, Object>> fsList){
		fMap = fMap==null ? new HashMap<String, Object>():fMap;
		fMap.put("fieldLabel", field.fieldLabel());
		fMap.put("class", f.getType().getSimpleName());
		fMap.put("fullClassName", f.getType().getName());
		fMap.put("pojoClass", f.getType().getName());
		HashSet<String> importTypes = (HashSet<String>) map.get("importTypes");
		if(importTypes==null){
			importTypes = new HashSet<String>();
		}
		importTypes.add(f.getType().getName());
		if(f.getType().equals(Date.class)){
			fMap.put("class", String.class.getSimpleName());
			fMap.put("fullClassName", String.class.getName());
		}
		fMap.put("name", f.getName());
		fMap.put("search", field.search());
		fMap.put("hidden", field.hidden());
		fMap.put("inGrid", field.inGrid());
		fMap.put("colwidth", field.colWith());
		fsList.add(fMap);
	}
}
