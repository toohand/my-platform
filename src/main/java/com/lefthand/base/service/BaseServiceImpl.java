package com.lefthand.base.service;

import com.lefthand.base.comm.BaseErrorEnum;
import com.lefthand.base.dao.BaseDaoable;
import com.lefthand.comm.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 服务层基础类，具体业务服务类继承它
 * Created by hp on 2015/6/10.
 */
public class BaseServiceImpl<T> implements BaseServiceable<T> {

    private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected BaseDaoable<T> baseDao;

    public BaseDaoable<T> getbaseDao() {
        return baseDao;
    }


    public void setBaseDao(BaseDaoable<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    @Transactional
    public long insert(T entity) {
        try {
            return baseDao.insert(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_INSERT, e);
        }
    }

    @Override
    @Transactional
    public long insert(List<T> list) {
        try {
            return baseDao.insertBatch(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_INSERT, e);
        }
    }

    @Override
    @Transactional
    public long update(T entity) {
        try {
            return baseDao.update(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_UPDATE, e);
        }
    }

    @Override
    @Transactional
    public long update(T entity, Map wmap) {
        try {
            return baseDao.updateMap(entity, wmap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_UPDATE, e);
        }
    }

    @Override
    @Transactional
    public long update(Map vwmap, Map wmap) {
        try {
            return baseDao.updateMap(vwmap, wmap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_UPDATE, e);
        }
    }


    @Override
    @Transactional
    public long delete(Object key) {
        try {
            return baseDao.deleteByKey(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_DELETEBYKEY, e);
        }

    }

    @Override
    @Transactional
    public long delete(Map map) {
        try {
            return baseDao.delete(map);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_DELETE, e);
        }
    }

    @Override
    @Transactional
    public long deleteBatch(Object[] object) {
        try {
            return baseDao.deleteBatch(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_DELETEBATCH, e);
        }
    }

    @Override
    public long count(Map map) {
        try {
            return baseDao.count(map);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_COUNT, e);
        }
    }

    @Override
    public T fetch(Object key) {
        try {
            return baseDao.fetch(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_FETCH, e);
        }
    }

    @Override
    public List<T> list(Map param, Sort sort) {
        try {
            return baseDao.list(param,sort);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_LIST, e);
        }
    }

    @Override
    public List<T> page(Map map,PageRequest page) {
        try {
            return baseDao.page(page, map);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(BaseErrorEnum.ERR_DAO_RODO_PAGE, e);
        }
    }


}
