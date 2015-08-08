package com.lefthand.comm.redis;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * @author hegc 2013年9月11日 下午6:13:54
 * Redis操作公共Dao
 */
public class RedisDao<T> {

	private RedisTemplate<String, T> template;
	
	/**
	 * setter
	 * @param template
	 */
	public void setTemplate(RedisTemplate<String, T> template) {
		this.template = template;
	}
	
	/**
	 * 保存集合数据
	 * @param key
	 * @param list
	 */
	public void saveList(String key, List<T> list) {
		for(T t : list) {
			template.opsForList().rightPush(key, t);
		}
	}
	
	/**
	 * 获取集合数据
	 * @param key
	 * @return 不存在key则返回长度为0的List
	 */
	public List<T> getList(String key) {
		
		return template.opsForList().range(key, 0, template.opsForList().size(key));
	}
	
	/**
	 * 销毁key的数据
	 * @param key
	 */
	public void destory(String key) {
		template.delete(key);
	}

	/**
	 * 保存单个对象<更灵活的string>
	 * @param key
	 * @param entity
	 */
	public void saveObject(String key, T entity) {
		template.opsForValue().set(key, entity);
	}
	
	/**
	 * 获取值为key的对象
	 * @param key
	 * @return
	 */
	public T getObject(String key) {
		return template.opsForValue().get(key);
	}
}