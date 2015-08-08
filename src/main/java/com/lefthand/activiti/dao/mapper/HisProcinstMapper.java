package com.lefthand.activiti.dao.mapper;

import com.lefthand.activiti.domain.HisProcinst;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 历史实例持久层，业务查询
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public interface HisProcinstMapper {
    /**
     * @param terms
     * @return
     */
    long queryHisProcinstTotal(@Param("terms") Map<String, Object> terms);

    /**
     * @param page
     * @param terms
     * @return
     */
    List<HisProcinst> findAllHisProcinst(@Param("page")PageRequest page, @Param("terms")Map<String, Object> terms);
}
