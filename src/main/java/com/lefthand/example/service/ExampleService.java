package com.lefthand.example.service;

import com.lefthand.example.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 范例服务接口
 * Created by wangmz on 2014/9/30.
 */
public interface ExampleService {

    /**
     * 保存范例
     *
     * @param example 范例对象
     */
    void save(Example example);

    /**
     * 删除范例
     *
     * @param id 范例编号
     */
    void delete(String id);

    /**
     * 获取范例
     *
     * @param id 范例编号
     */
    Example find(String id);

    /**
     * 按条件查询范例
     * @param terms 查询条件集合
     * @return
     */
    List<Example> findByAll(Map<String, Object> terms);

    /**
     * 按条件分页查询范例
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    Page<Example> query(PageRequest page, Map<String, Object> terms);

    /**
     * 按条件获取记录总数
     * @param terms 查询条件集合
     * @return
     */
    public long count(Map<String, Object> terms);
}
