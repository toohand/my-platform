package com.lefthand.attachment.service;

import com.lefthand.attachment.AttachmentModule;
import com.lefthand.attachment.dao.AttachmentAssociateDao;
import com.lefthand.attachment.dao.AttachmentDao;
import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.attachment.domain.support.MultipartFileWrapper;
import com.lefthand.comm.domain.Entity;
import com.lefthand.comm.exception.ApplicationException;
import com.lefthand.comm.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 附件服务实现类
 */
@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

    private static Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Autowired
    private AttachmentDao dao;
    @Autowired
    private AttachmentAssociateDao associateDao;
    @Resource(type = MongoFileSystemServiceImpl.class)
    private FileSystemService fileSystemService;

    /**
     * 保存一个或多个附件<附件关系类型默认没有>
     *
     * @param entityId      业务编号
     * @param attachmentIds 一个或多个附件编号
     */
    @Override
    public void save(String entityId, String... attachmentIds) {
        this.save(entityId,AttachmentAssociateType.NULL.id(),attachmentIds);
    }

    /**
     * 保存一个或多个附件
     *
     * @param entityId      业务编号
     * @param associateType 附件关系类型，参考 AttachmentAssociateType
     * @param attachmentIds 一个或多个附件编号
     */
    @Override
    public void save(String entityId, int associateType, String... attachmentIds) {
        try {
            for(String attachmentId : attachmentIds){
                Attachment attachment = this.find(attachmentId);
                attachment.setAssociateType(AttachmentAssociateType.fromTypeId(associateType));
                associateDao.save(entityId, attachment);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_SAVE, e);
        }
    }

    /**
     * 保存一个附件
     *
     * @param entity     业务对象
     * @param attachment 附件
     */
    @Override
    public void save(Entity entity, Attachment attachment) {
        try {
            associateDao.save((String)entity.getId(), attachment);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_SAVE, e);
        }
    }

    /**
     * 保存多个附件
     *
     * @param entity        业务对象
     * @param attachments   附件集合
     */
    @Override
    public void save(Entity entity, List<Attachment> attachments) {
        try {
            associateDao.save((String)entity.getId(), attachments);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_SAVE, e);
        }
    }

    /**
     * 保存附件<一次性保存文件和附件关系>
     *
     * @param entityId      业务编号
     * @param associateType 附件关系类型，参考 AttachmentAssociateType
     * @param file          文件对象
     * @return
     */
    @Override
    public Attachment save(String entityId, int associateType, MultipartFile file) {
        try {
            Attachment attachment = this.create(file);
            attachment.setAssociateType(AttachmentAssociateType.fromTypeId(associateType));
            associateDao.save(entityId, attachment);
            return attachment;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_SAVE, e);
        }
    }

    /**
     * 创建附件
     *
     * @param file 文件对象
     */
    @Override
    public Attachment create(MultipartFile file) {
        try {
            // 构建附件对象
            Attachment attachment = new MultipartFileWrapper(file).toAttachment();
            // 构建文件存储的目录
            attachment.setDir(attachment.getDir());
            // 保存附件对象
            dao.save(attachment);

            // 检测附件md5码是否已经存在，如果不存在，则是新的文件，写入文件系统
//            if(!dao.checkmd5(attachment.getMd5())){
                // 将文件写入存储介质
                fileSystemService.write(attachment.getPath(), file.getInputStream());
//            }

            return attachment;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_CREATE, e);
        }
    }

    /**
     * 读取附件文件
     *
     * @param path 附件路径
     */
    @Override
    public InputStream read(String path) {
        try {
            return fileSystemService.read(path);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 更新附件
     *
     * @param id   附件编号
     * @param file 文件对象
     */
    @Override
    public Attachment update(String id, MultipartFile file) {
        try {
            // 获取需要更新的附件对象
            Attachment temp = dao.find(id);
            // 构建附件对象
            Attachment attachment = new MultipartFileWrapper(file).toAttachment();
            attachment.setId(temp==null ? null : temp.getId());
            attachment.setDir(attachment.getDir());

            // 保存附件对象
            dao.save(attachment);

            // 检测附件md5码是否已经存在，如果不存在，则是新的文件，写入文件系统
//            if(!dao.checkmd5(attachment.getMd5())){
            // 将文件写入存储介质
            fileSystemService.write(attachment.getPath(), file.getInputStream());
//            }
            return attachment;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_UPDATE, e);
        }
    }

    /**
     * 删除附件
     *
     * @param id 附件流水号
     */
    @Override
    public void delete(String id) {
        try {
            // 逻辑删除附件
            dao.delete(id);
            // 删除附件与业务的关系
            associateDao.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_DELETE, e);
        }
    }

    /**
     * 根据业务编号，删除附件
     *
     * @param entityId 业务编号
     */
    @Override
    public void deleteByOwner(String entityId, AttachmentAssociateType associateType) {
        try {
            List<Attachment> attachments = this.findByOwnerAndAssociateTypes(entityId,associateType);
            for(Attachment attachment : attachments){
                this.delete(attachment.getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_DELETE, e);
        }
    }

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    @Transactional(readOnly = true)
    @Override
    public Attachment find(String id) {
        try {
            return dao.find(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 获取附件
     *
     * @param entityId      与附件关联的实体对象流水号
     * @param associateType 附件关联类型
     */
    @Transactional(readOnly = true)
    @Override
    public Attachment findByOwnerAndAssociateType(String entityId, AttachmentAssociateType associateType) {
        try {
            return dao.findByOwnerAndAssociate(entityId, associateType);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE_TYPE, e);
        }
    }

    /**
     * 获取附件集合
     *
     * @param entityId       与附件关联的实体对象流水号
     * @param associateTypes 附件关联类型集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Attachment> findByOwnerAndAssociateTypes(String entityId, AttachmentAssociateType... associateTypes) {
        try {
            return dao.findByOwnerAndAssociates(entityId, associateTypes);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(AttachmentModule.ERR_SEV_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE_TYPES, e);
        }
    }

    /**
     * 按条件分页查询附件
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    @Transactional(readOnly = true)
    @Override
    public Page<Attachment> query(PageRequest page, Map<String, Object> terms){
        try {
            return dao.query(page,terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
}
