package com.lefthand.activiti.dao.mapper;

import com.lefthand.activiti.domain.MyProcessDefinition;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 流程部署持久层，业务查询
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public interface ProcessDefinitionMapper {
    /**
     * @param terms
     * @return
     */
    long queryProcessDefinitionTotal(@Param("terms") Map<String, Object> terms);

    /**
     * @param page
     * @param terms
     * @return
     */
    List<MyProcessDefinition> findAllProcessDefinition(@Param("page")PageRequest page, @Param("terms")Map<String, Object> terms);
}
