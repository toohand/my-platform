package com.lefthand.activiti.dao.mapper;

import com.lefthand.activiti.domain.MyTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public interface ProcessTaskMapper {
    /**
     * 管理层 all 待办集合
     * @param terms
     * @return
     */
    long queryProcessTaskTotal(@Param("terms") Map<String, Object> terms);

    /**
     * 管理层 all 待办集合
     * @param page
     * @param terms
     * @return
     */
    List<MyTask> findAllProcessTask(@Param("page")PageRequest page,@Param("terms")Map<String, Object> terms);


    /**
     * 根据用户 查询所属的待办集合
     * @param page
     * @param terms
     * @return
     */
    List<MyTask> findTaskListByName(@Param("page")PageRequest page, @Param("terms")Map<String, Object> terms);

    /**
     * 根据用户 查询所属的待办任务总数
     * @param terms
     * @return
     */
    long queryTaskTotalByName(@Param("terms") Map<String, Object> terms);
}
