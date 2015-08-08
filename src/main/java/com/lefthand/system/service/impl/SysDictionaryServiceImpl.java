package com.lefthand.system.service.impl;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.system.service.SysDictionaryService;
import com.lefthand.system.dao.mapper.SysDictionaryDao;
import com.lefthand.system.domain.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Title: 数据字典管理 业务类
* Description: portal新增、删除、修改
* Company: hugeinfo
* author: codeBuilder
* time:2015-07-06 11:39:01
* version 1.0
*/
@Service
public class SysDictionaryServiceImpl  extends BaseServiceImpl<SysDictionary> implements SysDictionaryService {
    @Autowired
    private SysDictionaryDao fDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(fDao);
    }

    @Override
    public List<SysDictionary> getDtyDetail(String typeId) {
        Map wmap = new HashMap();
        wmap.put("typeId",typeId);
        Sort sort = new Sort(Sort.Direction.ASC,"sort_code");
        List<SysDictionary> list = this.baseDao.list(wmap,sort);
        return list;
    }
}
