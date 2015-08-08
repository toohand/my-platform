package com.lefthand.system.service;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.system.dao.mapper.SysJobDao;
import com.lefthand.system.domain.SysJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by hp on 2015/5/8.
 */
@Service
public class SysJobService  extends BaseServiceImpl<SysJob> implements SysJobServiceable{
    @Autowired
    private SysJobDao sysJobDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(sysJobDao);
    }

}
