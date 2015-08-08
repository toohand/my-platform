package com.lefthand.base.comm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JSONUtil {
	/**
	 * 将map 转成 jsonString
	 * 
	 * @param map
	 * @param datePattern 日期格式
	 * @return
	 */
	public static String map2JsonStr(Map map,String datePattern) {
		String ret = "";
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor(datePattern));
		JSONObject jObj = new JSONObject();
		jObj.putAll(map, jsonConfig);
		ret = jObj.toString();
		return ret;
	}

	/**
	 * 将Javabean转换为Map
	 * 
	 * @param javaBean
	 *            javaBean
	 * @return Map对象
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Map bean2Map(Object javaBean) throws Exception {
		Map result = new HashMap();
		Method[] methods = javaBean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {
				String field = method.getName();
				field = field.substring(field.indexOf("get") + 3);
				field = field.toLowerCase().charAt(0) + field.substring(1);
				Object value = method.invoke(javaBean, (Object[]) null);
				result.put(field, null == value ? "" : value.toString());
			}

		}
		return result;
	}

	/**
	 * 将Json对象转换成Map
	 * 
	 * @param jsonString
	 *            json对象
	 * @throws JSONException
	 */
	public static Map jsonStrToMap(String jsonString) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.fromObject(jsonString);
		Map result = new HashMap();
		Iterator iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);

		}
		return result;

	}

	/**
	 * 将JavaBean转换成JSONObject（通过Map中转）
	 * 
	 * @param bean
	 *            javaBean
	 * @return json对象
	 */
	public static JSONObject bean2JSON(Object bean) {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(bean, cfg);

	}

	/**
	 * 将Map转换成Javabean
	 * 
	 * @param bean
	 *            javaBean
	 * @param data
	 *            Map数据
	 */
	public static Object map2Bean(Object bean, Map data) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("set")) {
					String field = method.getName();
					field = field.substring(field.indexOf("set") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(bean, new Object[] { data.get(field)
					});
				}
			} catch (Exception e) {
			}

		}

		return bean;

	}

	/**
	 * JSONObject到JavaBean
	 * 
	 * @param bean
	 *            javaBean
	 * @return json对象
	 * @throws Exception
	 *             json解析异常
	 * @throws JSONException
	 */
	public static void jsonStrtoBean(Object bean, String jsonString)
			throws Exception {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(jsonString, cfg);
		Map map = jsonStrToMap(jsonObject.toString());
		map2Bean(bean, map);
	}

	public static JSONArray list2JSONArray(List list,String datePattern){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor(datePattern));
		return JSONArray.fromObject(list,jsonConfig);
	}
}
