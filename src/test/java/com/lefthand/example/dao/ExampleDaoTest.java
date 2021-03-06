package com.lefthand.example.dao;

import com.lefthand.AbstractTest;
import com.lefthand.example.data.ExampleDataProvider;
import com.lefthand.example.domain.Example;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Repeat;
import org.springframework.util.Assert;

/**
 * 单元测试范例-数据访问单元测试类
 * Created by wangmz on 2015/6/15.
 */
public class ExampleDaoTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(ExampleDaoTest.class);

    @Autowired
    private ExampleDao exampleDao;

    /**
     * 测试新增和更新数据
     * 通过 @Repeat注解 执行3次测试用例，不需要的话可以注释掉
     * @throws Exception
     */
    @Repeat(3)
    @Test()
    public void testSave() throws Exception {
        //新增
        Example example1 = ExampleDataProvider.example1();
        exampleDao.save(example1);

        //更新
        Example example1_ = ExampleDataProvider.example1_();
        example1_.setName(example1_.getName()+"_更新");
        exampleDao.save(example1_);
    }

    /**
     * 测试删除单条数据
     * @throws Exception
     */
    @Test()
    public void testDelete() throws Exception {
        exampleDao.delete(ExampleDataProvider.example1_().getId());
    }

    /**
     * 测试获取单条数据
     * @throws Exception
     */
    @Test()
    public void testFind() throws Exception {
        Assert.notNull(exampleDao.find(ExampleDataProvider.example1_().getId()));
    }

    /**
     * 测试获取所有数据
     * @throws Exception
     */
    @Test()
    public void testFindByAll() throws Exception {
        Assert.notEmpty(exampleDao.findByAll(null));
    }

    /**
     * 测试分页查询
     * @throws Exception
     */
    @Test()
    public void testQuery() throws Exception {
        Assert.notEmpty(exampleDao.query(new PageRequest(0, 20), null).getContent());
    }

    /**
     * 测试方法抛出期待的异常
     * 如果你期待一个异常发生，那么可以用下面这个expected属性
     * 如果测试的方法中抛出了DataAccessException异常，那么当前测试用例会绿色通过
     */
    @Test(expected= com.lefthand.comm.exception.DataAccessException.class)
    public void testFindByAllException() {
        Assert.notEmpty(exampleDao.findByAll(null));
    }
}
