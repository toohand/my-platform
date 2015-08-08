package com.lefthand.base.bdcode.builder;

import com.lefthand.base.bdcode.ann.EntityClass;
import com.lefthand.base.bdcode.ann.EntityField;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JspListBuilder extends DTOCodeBuilder{
		/**
		 *  模板路径
		 */
		@Override
		public String getTemplateName() {
			return "JspListTemplate.tld";
		}


		@SuppressWarnings("unchecked")
		public Map<String, Object> createMap(Class cls) {
			return this.createMap(cls, null);
		}
		

		public String getRootUrl() {
			return "src\\main\\webapp\\WEB-INF\\views\\";
		}


		protected Map<String, Object> createJson(EntityField field,Field f){
			Map<String, Object> fMap = new HashMap<String, Object>();
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
				map.put("name", name);
				map.put("author", entityClass.author());
				String lowerName=name.substring(0,1).toLowerCase()+name.substring(1);
				String url =jspPath+lowerName + ".jsp";
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
}
