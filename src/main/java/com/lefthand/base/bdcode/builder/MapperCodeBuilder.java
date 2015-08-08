package com.lefthand.base.bdcode.builder;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Time;
import java.util.*;


/**
 * 代码生成器通用类
 * @author hp
 *
 */
public class MapperCodeBuilder extends DTOCodeBuilder {

	/**
	 *  模板路径
	 */
	@Override
	public String getTemplateName() {
		return "DaoMapperTemplate.tld";
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls) {
		return this.createMap(cls, null);
	}

   //根目录路径
	public String getRootUrl() {
		return "src\\main\\java\\";
	}


	protected Map<String, Object> createJson(EntityField field,Field f){
		Map<String, Object> fMap = new HashMap<String, Object>();
		if ( field.columName() == null || field.columName().equals("")){
			fMap.put("colum", f.getName());
		} else {
			fMap.put("colum", field.columName());
		}
		fMap.put("jdbcType", FType2JdbcType(f.getType()));
		fMap.put("name", f.getName());
		fMap.put("search", field.search());
		fMap.put("hidden", field.hidden());
		fMap.put("fieldLabel", field.fieldLabel());
		fMap.put("inGrid", field.inGrid());
		fMap.put("colWith", field.colWith());
		fMap.put("size", field.size());
		fMap.put("type", field.type());
		fMap.put("mapname", field.mapname());
		return fMap;
	}

	/* (non-Javadoc)
     * @see com.kinth.sysmgr.common.codeSlave.builder.DTOCodeBuilder#createMap(java.lang.Class)
     */
	@SuppressWarnings("unchecked")
	public Map<String, Object> createMap(Class cls,Map<String, Object> map) {
		map = map==null? super.createMap(cls,null):map;
		EntityClass entityClass = (EntityClass) cls.getAnnotation(EntityClass.class);
		if (entityClass != null) {
			String name = cls.getSimpleName();
			String jspPath = entityClass.jsppath();
			map.put("jspPath", jspPath);
			map.put("description", entityClass.description());
			map.put("title", entityClass.title());
			map.put("key", entityClass.key());
			map.put("packagename", entityClass.packageName());
			map.put("jsppath", jspPath);
			map.put("table", entityClass.table());
			map.put("key", entityClass.key());
			map.put("name", name);
			String lowerName=name.substring(0,1).toLowerCase()+name.substring(1);
			String classPath = (String) map.get("daoPath");
			String url =this.getUrl(classPath, name + "Dao.xml");
			map.put("url", url);
		}
		List<Map<String, Object>> fsList = new ArrayList<Map<String, Object>>();
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs) {
			EntityField field = f.getAnnotation(EntityField.class);
			if (field != null) {
				fsList.add(createJson(field,f));
			}
		}
		map.put("jsons", fsList);
		return map;
	}

	private String  FType2JdbcType(Class claZZ ){
		if (String.class.toString().equals(claZZ.toString())){
			return "VARCHAR";
		} else
		if (long.class.toString().equals(claZZ.toString())
				|| Long.class.toString().equals(claZZ.toString())){
			return "BIGINT";
		} else
		if (int.class.toString().equals(claZZ.toString())
				|| Integer.class.toString().equals(claZZ.toString())){
			return "INTEGER";
		} else
		if (float.class.toString().equals(claZZ.toString())){
			return "REAL";
		} else
		if (double.class.toString().equals(claZZ.toString())){
			return "DOUBLE";
		} else if (Date.class.toString().equals(claZZ.toString())){
			return "TIME";
		} else if (Time.class.toString().equals(claZZ.toString())){
			return "TIME";
		} else if (Blob.class.toString().equals(claZZ.toString())){
			return "BLOB";
		}else if (Clob.class.toString().equals(claZZ.toString())){
			return "CLOB";
		}
		else
			return  "";
	}
}
