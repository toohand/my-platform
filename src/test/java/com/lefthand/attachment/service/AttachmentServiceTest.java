package com.lefthand.attachment.service;

import com.lefthand.AbstractTest;
import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件服务接口测试
 * Created by wangmz on 2015/7/7.
 */
public class AttachmentServiceTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(AttachmentServiceTest.class);

    @Autowired
    private AttachmentService service;

    @Test
    public void testCreate() throws Exception {
        String base64str = Base64.encodeBase64String("这是一次测试移动端文件上传：abcdefgewewewewewewewe".getBytes("UTF-8"));
        String name = "test45678.txt";
        byte[] content = Base64.decodeBase64(base64str);
        MultipartFile file = new MockMultipartFile(name, name, null, content);
        Attachment attachment = service.create(file);
        Assert.notNull(attachment);
    }
}
