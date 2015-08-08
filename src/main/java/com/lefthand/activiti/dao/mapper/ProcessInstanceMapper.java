package com.lefthand.activiti.dao.mapper;

import com.lefthand.activiti.domain.MyProcessInstance;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public interface ProcessInstanceMapper {
    /**
     * @param terms
     * @return
     */
    long queryProcessInstanceTotal(@Param("terms") Map<String, Object> terms);

    /**
     * @param page
     * @param terms
     * @return
     */
    List<MyProcessInstance> findAllProcessInstance(@Param("page")PageRequest page, @Param("terms")Map<String, Object> terms);
}
