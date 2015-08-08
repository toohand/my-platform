package com.lefthand.activiti.dao.mapper;

import com.lefthand.activiti.domain.HisTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public interface HisTaskMapper {
    /**
     * @param terms
     * @return
     */
    long queryHisTaskTotal(@Param("terms") Map<String, Object> terms);

    /**
     * @param page
     * @param terms
     * @return
     */
    List<HisTask> findAllHisTask(@Param("page")PageRequest page, @Param("terms")Map<String, Object> terms);

    /**
     *
     * @param page
     * @param terms
     * @param userId
     * @return
     */
    List<HisTask> findAllHisTaskByUserId(@Param("page")PageRequest page,
                                         @Param("terms")Map<String, Object> terms,
                                         @Param("userId")String userId);

    /**
     *
     * @param terms
     * @param userId
     * @return
     */
    long queryHisTaskTotalByUserId(@Param("terms") Map<String, Object> terms,@Param("userId")String userId);
}
