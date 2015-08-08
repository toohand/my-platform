package com.lefthand.base.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Map;

/**
 * 服务层基础接口，具体业务服务层接口继承它
 * Created by hp on 2015/6/10.
 */

public interface BaseServiceable<T>{
    /**
     * 新增实体
     * @param entity
     * @return 影响记录条数
     */
    public abstract long insert(T entity);

    /**
     * 批量新增
     * @param list
     * @return
     */
    public abstract long insert(List<T> list);
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public abstract long update(T entity);
    /**
     * 修改记录
     * @param entity 实体对象
     * @param wmap 按条件修改
     * @return 修改的对象个数，正常情况=1
     */
    public abstract long update(T entity,Map wmap);

    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param vwmap 修改值
     * @param wmap 按条件修改
     * @return 修改的对象个数，正常情况=1
     */
    public abstract long update(Map vwmap,Map wmap);
    /**
     * 按主键删除记录
     * @param key 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public abstract long delete(Object key);

    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param map 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    public abstract long delete(Map map);

    /**
     * 批量删除
     * @param object
     */
    public abstract long deleteBatch( Object[] object);



    /**
     * 查询符合条件的记录数
     * @param map 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count()
     * @return
     */
    public abstract long count(Map map);

    /**
     * 按主键取记录
     * @param key 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public abstract T fetch(Object  key);


    /**
     * 按条件查询记录
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @param sort  排序条件
     * @return 符合条件记录的实体对象的List
     */
    public abstract List<T> list(Map param,Sort sort);

    /**
     * 按条件查询记录，并处理成分页结果
     * @param map 查询条件参数
     * @param page 查询条件参数，分页条件、排序条件
     * @return PaginationResult对象，包括（符合条件的）总记录数、页实体对象List等
     */
    public abstract List<T> page(Map map, PageRequest page);


}

