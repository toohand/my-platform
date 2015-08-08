package com.lefthand.attachment.service;

import java.io.InputStream;

/**
 * 文件管理服务接口
 * Created by wangmz on 2015/6/17.
 */
public interface FileSystemService {

    /**
     * 读取文件流
     * @param path 文件存储路径
     * @return
     */
    InputStream read(String path);

    /**
     * 写入文件流
     * @param path         文件存储路径
     * @param inputStream  文件流
     * @return
     */
    String write(String path, InputStream inputStream);

    /**
     * 删除文件
     * @param path 文件存储路径
     * @return true:删除成功，false:删除失败
     */
    boolean delete(String path);
}
