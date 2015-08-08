package com.lefthand.comm.mongodb;

import com.lefthand.comm.utils.PropertiesLoader;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * mongodb处理程序，负责上传和下载的组件
 * Created by PanjinF on 2015/4/24.
 */
public class GridfsHandle {
    private static Logger logger = LoggerFactory.getLogger(GridfsHandle.class);
//  文件上传的mongodb的IP
    public static String FSURL = new PropertiesLoader("application.properties").getProperty("gridfs.url");
//  上传的端口
    public static String FSPORT = new PropertiesLoader("application.properties").getProperty("gridfs.port");
//  mongoDB上传的指定数据库
    public static String DBNAME = new PropertiesLoader("application.properties").getProperty("gridfs.dbname");

    /**
     * @param in 上传offic文件流
     * @param LogName 上传者帐号
     * @param fileName 附件名称
     * @param fileType 文件类型
     * @param posterId 上传者用户ID
     */
    public String FileHandle(String fileName,InputStream in ,String LogName,String fileType,String posterId){
//      创建mongo驱动工厂
        Mongo mongo = null;
        try {
//      引入连接因素
            mongo = new Mongo(FSURL, Integer.parseInt(FSPORT));
            logger.debug("连接mongoDB数据库成功！");
        } catch (UnknownHostException e) {
            logger.debug("连接mongoDB数据库失败,原因："+e.getMessage());
            e.printStackTrace();
        }
//      指向所需操作的数据
        DB db = mongo.getDB(DBNAME);
//      创建网格文件类，引入所属数据和集合的名字
        GridFS gridFS= new GridFS(db,LogName);
//      上传文件流
        GridFSFile gridFSFile =  gridFS.createFile(in);
//      设置数据库文件携带信息
        gridFSFile.put("filename", fileName);
        gridFSFile.put("posterId", posterId);
        gridFSFile.put("contentType", fileType);
//      保存操作
        gridFSFile.save();
        logger.debug(gridFSFile.getFilename()+"-文件成功保存到mongoDB数据库中，类型为"+gridFSFile.getContentType()+",文件对象ID为"+gridFSFile.getId());
//      获取数据库中objectID,这是其他操作的文件标识，可提供下载预览的存取
        String filePath =gridFSFile.getId().toString();
//      返回文件存取的id
        return filePath;
    }

    /**
     * 获取文件输入流
     * @param path
     * @param LogName
     * @return
     */
    public InputStream readFileHandle(String path,String LogName){
        //      创建mongo驱动工厂
        Mongo mongo = null;
        try {
        //引入连接因素
            mongo = new Mongo(FSURL, Integer.parseInt(FSPORT));
            logger.debug("连接mongoDB数据库成功！");
        } catch (UnknownHostException e) {
            logger.debug("连接mongoDB数据库失败,原因："+e.getMessage());
            e.printStackTrace();
        }
        //指向所需操作的数据
        DB db = mongo.getDB(DBNAME);
        //创建网格文件类，引入所属数据和集合的名字
        GridFS gridFS= new GridFS(db,LogName);
        ObjectId objId = new ObjectId(path);
        GridFSDBFile gf = gridFS.findOne(objId);
        InputStream in = null;
        try {
            in = gf.getInputStream();
        }catch (Exception e){

        }
        logger.debug("输入流"+in);
        return in;
        }

    /**转成后的PDF文件上传DB处理
     * @param in 文件流
     * @param LogName 上传者帐号
     */
    public String FilePdfHandle(InputStream in ,String path,String LogName,String dbfilename){
//      创建mongo驱动工厂
        Mongo mongo = null;
        try {
//      引入连接因素
            mongo = new Mongo(FSURL, Integer.parseInt(FSPORT));
            logger.debug("连接mongoDB数据库成功！");
        } catch (UnknownHostException e) {
            logger.debug("连接mongoDB数据库失败,原因："+e.getMessage());
            e.printStackTrace();
        }
//      指向所需操作的数据
        DB db = mongo.getDB(DBNAME);
//      创建网格文件类，引入所属数据和集合的名字
        GridFS gridFS= new GridFS(db,LogName);
//      上传文件流
        GridFSFile gridFSFile =  gridFS.createFile(in);
//      设置数据库文件携带信息
        ObjectId objectId = new ObjectId(path);
        gridFSFile.put("filename", dbfilename);
        gridFSFile.put("_id", objectId);
        gridFSFile.put("contentType","pdf");
//      保存操作
        gridFSFile.save();
        logger.debug(gridFSFile.getFilename()+"-文件成功保存到mongoDB数据库中，类型为"+gridFSFile.getContentType()+",文件对象ID为"+gridFSFile.getId());
//      获取数据库中objectID,这是其他操作的文件标识，可提供下载预览的存取
        String filePath =gridFSFile.getId().toString();
//      返回文件存取的id
        return filePath;
    }
    /**
     * 获取pdf文件的contentType
     */
    public Map<String,String> getPdf(String path,String LogName){
        //      创建mongo驱动工厂
        Mongo mongo = null;
        try {
            //引入连接因素
            mongo = new Mongo(FSURL, Integer.parseInt(FSPORT));
            logger.debug("连接mongoDB数据库成功！");
        } catch (UnknownHostException e) {
            logger.debug("连接mongoDB数据库失败,原因："+e.getMessage());
            e.printStackTrace();
        }
        //指向所需操作的数据
        DB db = mongo.getDB(DBNAME);
        //创建网格文件类，引入所属数据和集合的名字
        GridFS gridFS= new GridFS(db,LogName);
        ObjectId objId = new ObjectId(path);
        GridFSDBFile gf = gridFS.findOne(objId);
        String ContentType = gf.getContentType().toString();
        String Filename=gf.getFilename().toString();
        Map<String,String> map = new HashMap<String, String>();
        map.put("attachType",ContentType);
        map.put("Filename",Filename);
        return map;
    }

    /**
     * 获取PDF文件输入流
     * @param path
     * @param LogName
     * @return
     */
    public InputStream readPdfHandle(String path,String LogName){
        //      创建mongo驱动工厂
        Mongo mongo = null;
        try {
            //引入连接因素
            mongo = new Mongo(FSURL, Integer.parseInt(FSPORT));
            logger.debug("连接mongoDB数据库成功！");
        } catch (UnknownHostException e) {
            logger.debug("连接mongoDB数据库失败,原因："+e.getMessage());
            e.printStackTrace();
        }
        DB db = mongo.getDB(DBNAME);
        GridFS gridFS= new GridFS(db,LogName);
        ObjectId objId = new ObjectId(path);
        GridFSDBFile gf = gridFS.findOne(objId);
        InputStream in = gf.getInputStream();
        logger.debug("PDF输入流------------------->"+in);
        return in;
    }

}
