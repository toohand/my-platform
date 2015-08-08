package com.lefthand.attachment.dao;

import com.lefthand.attachment.AttachmentModule;
import com.lefthand.attachment.dao.mapper.AttachmentMapper;
import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.security.organization.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 附件数据访问类
 */
@Repository
public class AttachmentDao {

    private static Logger logger = LoggerFactory.getLogger(AttachmentDao.class);

    @Autowired
    private AttachmentMapper mapper;

    /**
     * 保存附件
     *
     * @param attachment 附件实体对象
     */
    public void save(Attachment attachment) {
        try {
            final Date NOW = new Date();
            if (null == attachment.getId()) {
                // 设置附件编号
                attachment.setId(com.lefthand.comm.utils.Identities.uuid2());
                // 设置创建时间
                attachment.setCreateTime(NOW);
                mapper.insert(attachment);
            } else {
                // 设置更新时间
                attachment.setUpdateTime(NOW);
                mapper.update(attachment);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_SAVE, e);
        }
    }

    /**
     * 更新附件新名称
     *
     * @param id      附件流水号
     * @param newName 新名称
     * @param creator 创建人, 岗位对象
     */
    public void updateNewName(String id, String newName, Post creator) {
        try {
            mapper.updateNewName(id, newName, creator, new Date());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_UPDATE_NEW_NAME, e);
        }
    }

    /**
     * 删除附件, 更新删除标识为TRUE
     *
     * @param id 附件编号
     */
    public void delete(String id) {
        try {
            mapper.updateDeteleStatus(id, true, new Date());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_DELETE, e);
        }
    }

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    public Attachment find(String id) {
        try {
            return mapper.find(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 获取附件
     *
     * @param entityId      与附件关联的实体对像流水号
     * @param associateType 附件关联类型
     */
    public Attachment findByOwnerAndAssociate(String entityId, AttachmentAssociateType associateType) {
        try {
            return mapper.findByOwnerAndAssociate(entityId, associateType);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE, e);
        }
    }

    /**
     * 获取附件集合
     *
     * @param entityId       与附件关联的实体对象流水号
     * @param associateTypes 附件关联类型集合
     */
    public List<Attachment> findByOwnerAndAssociates(String entityId, AttachmentAssociateType... associateTypes) {
        try {
            return mapper.findsByOwnerAssociate(entityId, associateTypes);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_FIND_BY_OWNER_ASSOCIATES, e);
        }
    }

    /**
     * 按条件分页查询附件
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    public Page<Attachment> query(PageRequest page, Map<String, Object> terms){
        try {
            long total = mapper.queryTotal(terms);
            List<Attachment> content = mapper.queryContent(page, terms);
            return new PageImpl<Attachment>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(e.getMessage(), e);
        }
    }

    /**
     * 检测md5码是否存在
     *
     * @param md5 md5字符串
     * @return true：存在，false:不存在
     */
    public boolean checkmd5(String md5){
        try {
            long count = mapper.checkmd5(md5);
            if(count>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.DataAccessException(e.getMessage(), e);
        }
    }

}
