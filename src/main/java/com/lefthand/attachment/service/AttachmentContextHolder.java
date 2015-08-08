package com.lefthand.attachment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * 以静态变量持有附件上下文
 */
@Component
@Lazy(false)
public class AttachmentContextHolder {

    private static String storageType;//存储介质类型

    private static String diskPath;   //磁盘存储地址
    private static String hadoopPath; //Hadoop存储地址
    private static String mongoPath;  //MongoDB存储地址


    private AttachmentContextHolder() {
    }

    public static String getStorageType() {
        return storageType;
    }

    @Value(value = "${attachment.storage.type}")
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public static String getDiskPath() {
        return diskPath;
    }

    @Value(value = "${attachment.disk.path}")
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    public static String getHadoopPath() {
        return hadoopPath;
    }

    @Value(value = "${attachment.hadoop.path}")
    public void setHadoopPath(String hadoopPath) {
        this.hadoopPath = hadoopPath;
    }

    public static String getMongoPath() {
        return mongoPath;
    }

    @Value(value = "${attachment.mongo.path}")
    public void setMongoPath(String mongoPath) {
        this.mongoPath = mongoPath;
    }

    public static String getRootDir(){
        String type = getStorageType();
        if("hadoop".equals(type)){
            return getHadoopPath();
        }
        if("mongo".equals(type)){
            return getMongoPath();
        }
        return getDiskPath();
    }
}
