package com.lefthand.attachment.service;

import com.lefthand.attachment.AttachmentModule;
import com.lefthand.comm.exception.ServiceException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Hadoop文件管理服务实现类
 * Created by wangmz on 2015/6/17.
 */
@Service
public class HadoopFileSystemServiceImpl implements FileSystemService{

    private static Logger logger = LoggerFactory.getLogger(HadoopFileSystemServiceImpl.class);

    private static Configuration conf;

    private static FileSystem hdfs;

    static {
        conf = new Configuration();
        try {
            logger.debug("正在连接hadoop服务器...");
            hdfs = FileSystem.get(URI.create(AttachmentContextHolder.getHadoopPath()), conf);
            logger.debug("连接hadoop服务器成功...");
        } catch (IOException e) {
            logger.error("连接hadoop服务器失败...", e);
        }
    }

    /**
     * 读取文件流
     *
     * @param path 文件存储路径
     * @return
     */
    @Override
    public InputStream read(String path) {
        try {
            logger.debug("正在读取hadoop文件："+path);
            return hdfs.open(new Path(path));
        } catch (IOException e) {
            logger.error("读取hadoop文件失败...", e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 写入文件流
     *
     * @param path        文件存储路径
     * @param inputStream 文件流
     * @return
     */
    @Override
    public String write(String path, InputStream inputStream) {
        try {
            logger.debug("正在写入hadoop文件："+path);
            // 获取输出流
            OutputStream outputStream = hdfs.create(new Path(path), new Progressable() {
                @Override
                public void progress() {
                    logger.debug("write success.");
                }
            });
            // 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
            IOUtils.copyBytes(inputStream, outputStream, 1024, true);
            IOUtils.closeStream(outputStream);
            IOUtils.closeStream(inputStream);
            return path;
        } catch (IOException e) {
            logger.error("写入hadoop文件失败...", e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 删除文件
     *
     * @param path 文件存储路径
     */
    @Override
    public boolean delete(String path) {
        try {
            logger.debug("删除hadoop文件："+path);
            return hdfs.delete(new Path(path), true);
        } catch (IOException e) {
            logger.error("删除hadoop文件失败...", e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }
}
