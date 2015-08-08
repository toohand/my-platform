package com.lefthand.example.dao.mapper;

import com.lefthand.example.domain.Example;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 范例数据库映射接口
 * Created by wangmz on 2014/9/30.
 */
@Repository
public interface ExampleMapper {

    /**
     * 插入范例
     * @param example 范例实体
     */
    void insert(@Param("demo") Example example);

    /**
     * 更新范例
     * @param example 范例实体
     */
    void update(@Param("demo") Example example);

    /**
     * 删除范例
     * @param id 范例编号
     */
    void delete(@Param("id") String id);

    /**
     * 获取范例
     * @param id 范例编号
     * @return
     */
    Example find(@Param("id") String id);

    /**
     * 按条件查询范例总数
     *
     * @param terms 查询条件集合
     */
    long queryTotal(@Param("terms") Map<String, Object> terms);

    /**
     * 按条件查询范例分页结果集
     * @param page 分页对象
     * @param terms 查询条件集合
     * @return
     */
    List<Example> queryByPage(@Param("page") PageRequest page, @Param("terms") Map<String, Object> terms);

    /**
     * 按条件查询范例所有结果集
     * @param terms 查询条件集合
     * @return
     */
    List<Example> findByAll(@Param("terms") Map<String, Object> terms);
}
