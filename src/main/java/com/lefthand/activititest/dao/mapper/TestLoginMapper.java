package com.lefthand.activititest.dao.mapper;

import com.lefthand.activiti.domain.TestUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by PanjinF on 2015/6/11.
 */
@Repository
public interface TestLoginMapper {
    /**
     * @param loginName
     * @return
     */
    TestUser findByLoginName(@Param("loginName") String loginName);


}
