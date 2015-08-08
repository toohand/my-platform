package com.lefthand.base.bdcode.builder;

import com.lefthand.base.bdcode.ann.EntityClass;

import java.util.Map;


public class ControllerBuilder extends DTOCodeBuilder{
		/**
		 *  模板路径
		 */
		@Override
		public String getTemplateName() {
			return "ActionTemplate.tld";
		}


		@Override
		@SuppressWarnings("unchecked")
		public Map<String, Object> createMap(Class cls) {
			return this.createMap(cls, null);
		}
		
		/**
		 * 创建变量
		 */
		@SuppressWarnings("unchecked")
		public Map<String, Object> createMap(Class cls, Map<String, Object> map) {
			if(map==null){
				 map = super.createMap(cls,null);
			}
			EntityClass entityClass = (EntityClass) cls.getAnnotation(EntityClass.class);
			if (entityClass != null) {
				String name = cls.getSimpleName();
				String classPath = (String) map.get("actionPath");
				String url =this.getUrl(classPath, name + "Controller.java");
				map.put("url", url);
			}
			return map;
		}
}
