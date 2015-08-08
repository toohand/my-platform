package com.lefthand.example.dao;


import com.lefthand.example.ExampleModule;
import com.lefthand.example.dao.mapper.ExampleMapper;
import com.lefthand.example.domain.Example;
import com.lefthand.example.utils.DataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 范例数据访问类
 * Created by wangmz on 2014/9/30.
 */
@Repository
public class ExampleDao {

    private static Logger logger = LoggerFactory.getLogger(ExampleDao.class);

    @Autowired
    private ExampleMapper mapper;

    /**
     * 保存范例
     * @param example 范例实体
     */
    public void save(Example example){
        try {
            if (null == this.find(example.getId())) {
                // 设置范例编号
//                demo.setId(Identities.uuid2());
                mapper.insert(example);
            } else {
                mapper.update(example);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_SAVE, e);
        }
    }

    /**
     * 删除范例
     *
     * @param id 范例编号
     */
    public void delete(String id) {
        try {
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_DELETE, e);
        }
    }

    /**
     * 获取范例
     *
     * @param id 范例编号
     */
    public Example find(String id) {
        try {
            // 获取范例信息
            Example example = mapper.find(id);
            return example;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_FIND, e);
        }
    }

    /**
     * 按条件查询范例
     *
     * @param terms 查询条件集合
     */
    public List<Example> findByAll(Map<String, Object> terms) {
        try {
            // 获取范例信息
//            List<Example> examples = mapper.findByAll(terms);
            List<Example> examples = DataProvider.getExamlpes();
            return examples;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_FIND_BY_ALL, e);
        }
    }

    /**
     * 按条件分页查询范例
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    public Page<Example> query(PageRequest page, Map<String, Object> terms) {
        try {
            long total = mapper.queryTotal(terms);
            List<Example> content = mapper.queryByPage(page, terms);
            return new PageImpl<Example>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_QUERY, e);
        }
    }

    /**
     * 按条件获取记录总数
     * @param terms 查询条件集合
     * @return
     */
    public long count(Map<String, Object> terms){
        try {
            long total = mapper.queryTotal(terms);
            return total;
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(ExampleModule.ERR_DAO_TODO_COUNT, e);
        }
    }
}
