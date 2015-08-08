package com.lefthand.attachment.service;

import com.lefthand.comm.exception.ServiceException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * 磁盘文件管理服务实现类
 * Created by wangmz on 2015/6/17.
 */
@Service
public class DiskFileSystemServiceImpl implements FileSystemService {

    private static Logger logger = LoggerFactory.getLogger(DiskFileSystemServiceImpl.class);

    /**
     * 读取文件流
     *
     * @param path 文件存储路径
     * @return
     */
    @Override
    public InputStream read(String path) {
        try {
            logger.debug("正在读取磁盘文件："+path);
            return new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("读取磁盘文件失败...", e);
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
            logger.debug("正在写入磁盘文件："+path);
            //文件目录
            String dir = FilenameUtils.getFullPath(path);
            //文件名称
            String name = FilenameUtils.getName(path);
            // 检查目录是否存在, 不存在则创建
            FileUtils.forceMkdir(new File(dir));

            //将输入流写入磁盘
            OutputStream outputStream = new FileOutputStream(new File(dir+name));
            IOUtils.copy(inputStream, outputStream);
            //关闭流
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            return path;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("写入磁盘文件失败...", e);
        }
    }

    /**
     * 删除文件
     *
     * @param path 文件存储路径
     */
    @Override
    public boolean delete(String path) {
        File file = new File(path);
        if(file.exists()){
            logger.debug("删除磁盘文件："+path);
            return file.delete();
        }else{
            throw new ServiceException("删除磁盘文件失败...");
        }
    }

    public static void main(String args[]) {
        String filePath = "F:/temp/a/b";
        File file = new File(filePath);
        try {
            System.out.println("file.exists()? " + file.exists());
            FileUtils.forceMkdir(file);
            System.out.println("getPathNoEndSeparator:"+FilenameUtils.getPathNoEndSeparator(filePath+"/c.txt"));
            System.out.println("getPath:"+FilenameUtils.getPath(filePath+"/c.txt"));
            System.out.println("getBaseName:"+FilenameUtils.getBaseName(filePath+"/c.txt"));
            System.out.println("getExtension:"+FilenameUtils.getExtension(filePath+"/c.txt"));
            System.out.println("getFullPath:"+FilenameUtils.getFullPath(filePath+"/c.txt"));
            System.out.println("getFullPathNoEndSeparator:"+FilenameUtils.getFullPathNoEndSeparator(filePath+"/c.txt"));
            System.out.println("getName:"+FilenameUtils.getName(filePath+"/c.txt"));
            System.out.println("getPrefix:"+FilenameUtils.getPrefix(filePath+"/c.txt"));
            System.out.println("getPrefixLength:"+FilenameUtils.getPrefixLength(filePath+"/c.txt"));
            System.out.println("normalize:"+FilenameUtils.normalize(filePath+"/c.txt"));
            System.out.println("normalizeNoEndSeparator:"+FilenameUtils.normalizeNoEndSeparator(filePath+"/c.txt"));
            System.out.println("removeExtension:"+FilenameUtils.removeExtension(filePath+"/c.txt"));
            System.out.println("separatorsToSystem:"+FilenameUtils.separatorsToSystem(filePath+"/c.txt"));
            System.out.println("separatorsToUnix:"+FilenameUtils.separatorsToUnix(filePath+"/c.txt"));
            System.out.println("separatorsToWindows:"+FilenameUtils.separatorsToWindows(filePath+"/c.txt"));
            System.out.println("file.exists()? " + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
