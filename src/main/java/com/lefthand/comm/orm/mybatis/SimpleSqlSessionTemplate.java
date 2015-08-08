package com.lefthand.comm.orm.mybatis;

import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class SimpleSqlSessionTemplate extends SqlSessionTemplate
{
    public SimpleSqlSessionTemplate(SqlSessionFactory sqlSessionfactory, ExecutorType executorType)
    {
        super(sqlSessionfactory, executorType);
    }

    public <PK> void deleteById(String sqlId, PK id)
    {
        try
        {
            delete(sqlId, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <PK> void deleteByIds(String sqlId, List<PK> ids)
    {
        try
        {
            delete(sqlId, ids);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <PK> void deleteByIds(String sqlId, PK[] ids)
    {
        List listIds = Arrays.asList(ids);
        deleteByIds(sqlId, listIds);
    }

    public <T, PK> T getById(String sqlId, PK id)
    {
        try
        {
            return selectOne(sqlId, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getByParam(String sqlId, Object param)
    {
        try
        {
            return selectOne(sqlId, param);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long getCount(String sqlId, Object param)
    {
        try
        {
            return ((Long)selectOne(sqlId, param)).longValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> query(String sqlId)
    {
        try
        {
            return selectList(sqlId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> query(String sqlId, Object param)
    {
        return query(sqlId, param, 0, 0);
    }

    public <T> List<T> query(String sqlId, Object param, int skip, int limit)
    {
        try
        {
            if (limit == 0) {
                return selectList(sqlId, param);
            }
            return selectList(sqlId, param, new RowBounds(skip, limit));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> com.lefthand.comm.orm.Page<T> queryPage(String sqlListId, String sqlCountId, Object param, com.lefthand.comm.orm.Page<T> page)
    {
        try
        {
            if (page == null) {
                return page;
            }
            int skip = (page.getPageNo() - 1) * page.getPageSize();
            int limit = page.getPageSize();
            List results = query(sqlListId, param, skip, limit);
            long count = getCount(sqlCountId, param);
            page.setResult(results);
            page.setTotalCount(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return page;
    }

    public <T> com.lefthand.comm.orm.Page<T> queryPage(String sqlListId, String sqlCountId, Object param, int pageNo, int pageSize)
    {
        com.lefthand.comm.orm.Page page = new com.lefthand.comm.orm.Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return queryPage(sqlListId, sqlCountId, param, page);
    }
}