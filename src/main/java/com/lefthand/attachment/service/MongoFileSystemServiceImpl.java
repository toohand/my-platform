package com.lefthand.attachment.service;

import com.lefthand.attachment.AttachmentModule;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * MongoDB文件管理服务实现类
 * Created by wangmz on 2015/6/17.
 */
@Service
public class MongoFileSystemServiceImpl implements FileSystemService {

    private static Logger logger = LoggerFactory.getLogger(MongoFileSystemServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    /**
     * 读取文件流
     *
     * @param path 文件存储路径
     * @return
     */
    @Override
    public InputStream read(String path) {
        try {
            logger.debug("正在读取mongodb文件："+path);
            String id = FilenameUtils.getBaseName(path);
            GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
            return file.getInputStream();
        } catch (Exception e) {
            logger.error("读取mongodb文件失败...", e);
            throw new com.lefthand.comm.exception.ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
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
            logger.debug("正在写入mongodb文件："+path);
            String id = FilenameUtils.getBaseName(path);
            String filename = FilenameUtils.getName(path);
            String contentType = FilenameUtils.getExtension(path);

            /*DBObject metaData = new BasicDBObject();
            metaData.put("_id", id);
            metaData.put("filename", filename);
            metaData.put("contentType", contentType);
            GridFSFile file =gridFsTemplate.store(inputStream, metaData);*/

            //spring的gridFsTemplate操作模板并不支持自定义ID，所以采用以下驱动API接口写入
            DB db = mongoTemplate.getDb();
            GridFS gridFS= new GridFS(db,"fs");//@TODO 固定放在名称为“fs”的集合，可以考虑按年月放在多个集合
            GridFSFile gridFSFile =  gridFS.createFile(inputStream);
            gridFSFile.put("_id", id);
            gridFSFile.put("filename", filename);
            gridFSFile.put("contentType", contentType);
            gridFSFile.save();
            return path;
        } catch (Exception e) {
            logger.error("写入mongodb文件失败...", e);
            throw new com.lefthand.comm.exception.ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
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
            logger.debug("删除mongodb文件："+path);
            String id = FilenameUtils.getBaseName(path);
            gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
            return true;
        } catch (Exception e) {
            logger.error("删除mongodb文件失败...", e);
            throw new com.lefthand.comm.exception.ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }
}
