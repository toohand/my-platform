package com.lefthand.attachment.service;

import com.lefthand.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * mongodb文件管理服务测试类
 * Created by wangmz on 2015/6/19.
 */
public class MongoFileSystemServiceTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(DiskFileSystemServiceTest.class);

    @Resource(name = "diskFileSystemServiceImpl")
    private FileSystemService diskFileSystemServiceImpl;

    @Resource(name = "mongoFileSystemServiceImpl")
    private FileSystemService mongoFileSystemServiceImpl;

    /**
     * 测试读取文件
     * @throws Exception
     */
    @Test()
    public void testRead() throws Exception {

        String readpath = "F:/temp/out/TEST_123456.txt";
        InputStream inputStream = mongoFileSystemServiceImpl.read(readpath);

        String writepath = "F:/temp/out/TEST_MONGO_123456.txt";
        diskFileSystemServiceImpl.write(writepath, inputStream);
    }

    /**
     * 测试写入文件
     * @throws Exception
     */
    @Test()
    public void testWrite() throws Exception {

        String readpath = "F:/temp/in/in.txt";
        InputStream inputStream = diskFileSystemServiceImpl.read(readpath);

        String writepath = "F:/temp/out/TEST_123456.txt";
        mongoFileSystemServiceImpl.write(writepath, inputStream);
    }

    /**
     * 测试删除文件
     * @throws Exception
     */
    @Test()
    public void testDelete() throws Exception {
        String outpath = "F:/temp/out/TEST_123456.txt";
        Assert.isTrue(mongoFileSystemServiceImpl.delete(outpath));
    }
}
