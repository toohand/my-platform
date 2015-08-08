package com.lefthand.base.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * MyBatis 基础类接口，继承它的子类必须要和MyBatis Mapper文件同名，直接映射其实现方法
 * 实现主要接口如下： insert，insertBatch，update,updateMap,deleteByKey,delete,deleteBatch,fetch,count,list,page
 * Created by hp on 2015/6/11.
 */
public interface BaseDaoable<T> {

    public  long insert(@Param("e")T entity);
    /**
     * 批量新增
     * @param list
     * @return
     */
    public  long insertBatch(@Param("list")List<T> list);
    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    public  long update(@Param("e")T entity);

    /**
     * 根据map条件修改
     * @param vObject
     * @param wObject
     * @return
     */
    public long updateMap(@Param("e")Object vObject,@Param("w")Object wObject);

    /**
     * 按主键删除记录
     * @param key 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    public  long deleteByKey(@Param("key")Object key);
    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param object 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    public  long delete(@Param("w")Object object);
    /**
     * 批量删除
     * @param object
     */
    public  long deleteBatch( @Param("w")Object object);
    /**
     * 按主键取记录
     * @param key 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    public  T fetch(@Param("key")Object  key);
    /**
     * 查询整表总记录数
     *  @param object
     * @return 整表总记录数
     */
    public  long count(@Param("w")Object object);

    /**
     * 按条件查询记录
     * @param object 查询条件参数
     * @return 全部记录实体对象的List
     */
    public  List<T> list(@Param("w")Object object,@Param("sort")Sort sort);


    /**
     * 按条件查询记录，并处理成分页结果
     * @param object 查询条件参数
     * @param page 查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 实体对象的List
     */
    public  List<T>  page(@Param("page")PageRequest page,@Param("w")Object object);
}
