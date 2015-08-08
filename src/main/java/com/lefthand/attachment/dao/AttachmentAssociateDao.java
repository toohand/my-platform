package com.lefthand.attachment.dao;

import com.lefthand.attachment.AttachmentModule;
import com.lefthand.attachment.dao.mapper.AttachmentAssociateMapper;
import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 附件关联关系数据访问类
 */
@Repository
public class AttachmentAssociateDao {

    private static Logger logger = LoggerFactory.getLogger(AttachmentAssociateDao.class);

    @Autowired
    private AttachmentAssociateMapper mapper;

    /**
     * 保存附件与所有者关系
     *
     * @param entityId   所有者编号
     * @param attachment 附件对象
     */
    public void save(String entityId, Attachment attachment) {
        /*List<Attachment> attachments = Lists.newArrayList();
        attachments.add(attachment);*/
        mapper.insert(entityId, attachment);
    }

    /**
     * 保存附件集合与所有者关系
     *
     * @param entityId    所有者编号
     * @param attachments 附件对象集合
     */
    public void save(String entityId, List<Attachment> attachments) {
        try {
            // 删除所有者所有附件关系
            mapper.deleteByOwner(entityId);
            // 如果当前所有者附件关系不为空, 则插入新的附件关系
            if (CollectionUtils.isNotEmpty(attachments)) {
                for(Attachment attachment : attachments){
                    this.save(entityId, attachment);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_SAVE, e);
        }
    }

    /**
     * 保存附件集合与所有者关系
     *
     * @param entityId    所有者编号
     * @param attachments 附件对象集合
     * @param delete      保存前是否删除所有者所有附件关系
     */
    public void save(String entityId, List<Attachment> attachments, boolean delete) {
        try {
            if (delete) {
                // 删除所有者所有附件关系
                mapper.deleteByOwner(entityId);
            } else {
                // 如果当前所有者附件关系不为空, 则插入新的附件关系
                if (CollectionUtils.isNotEmpty(attachments)) {
                    for(Attachment attachment : attachments){
                        this.save(entityId, attachment);
                    }
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_SAVE, e);
        }
    }

    /**
     * 删除附件关联关系
     *
     * @param id 附件编号
     */
    public void delete(String id) {
        try {
            mapper.deleteByAttachment(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_DELETE, e);
        }
    }

    /**
     * 删除附件关联关系
     *
     * @param entityId 与附件关联的实体对象流水号
     */
    public void deleteByOwner(String entityId) {
        try {
            mapper.deleteByOwner(entityId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_DELETE, e);
        }
    }

    /**
     * 删除附件关联关系
     *
     * @param entityId      与附件关联的实体对象流水号
     * @param associateType 附件关联类型
     */
    public void deleteByOwnerAndAssociate(String entityId, AttachmentAssociateType associateType) {
        try {
            mapper.deleteByOwnerAndAssociate(entityId, associateType);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_DELETE, e);
        }
    }

    /**
     * 获取附件关系集合
     *
     * @param entityId 附件流水号
     */
    public List<String> findByOwner(String entityId) {
        try {
            return mapper.findByOwner(entityId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_FIND, e);
        }
    }

    /**
     * 获取附件关系集合
     *
     * @param entityId      附件流水号
     * @param associateType 附件关联类型
     */
    public List<String> findByOwnerAndAssociate(String entityId, AttachmentAssociateType associateType) {
        try {
            return mapper.findByOwnerAndAssociate(entityId, associateType);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_ASSOCIATE_FIND, e);
        }
    }
}
