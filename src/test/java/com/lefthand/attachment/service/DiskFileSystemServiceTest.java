package com.lefthand.attachment.service;

import com.lefthand.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * 磁盘文件管理服务测试类
 * Created by wangmz on 2015/6/19.
 */
public class DiskFileSystemServiceTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(DiskFileSystemServiceTest.class);

    @Resource(name = "diskFileSystemServiceImpl")
    private FileSystemService fileSystemService;

    /**
     * 测试读写文件
     * @throws Exception
     */
    @Test()
    public void testReadAndWrite() throws Exception {
        String inpath = "F:/temp/in/in.txt";
        InputStream inputStream = fileSystemService.read(inpath);

        String outpath = "F:/temp/out/out.txt";
        fileSystemService.write(outpath, inputStream);
    }

    /**
     * 测试删除文件
     * @throws Exception
     */
    @Test()
    public void testDelete() throws Exception {
        String outpath = "F:/temp/out/out.txt";
        Assert.isTrue(fileSystemService.delete(outpath));
    }
}
