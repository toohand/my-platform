package com.lefthand.attachment.dao.mapper;

import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 附件关联关系映射接口
 */
@Repository
public interface AttachmentAssociateMapper {

    /**
     * 插入附件关联关系
     *
     * @param entityId    与附件关联的实体对象流水号
     * @param attachments 附件对象集合
     */
    void insertBatch(@Param("entityId") String entityId, @Param("attachments") List<Attachment> attachments);

    /**
     * @param entityId   与附件关联的实体对象流水号
     * @param attachment 附件对象
     */
    void insert(@Param("entityId") String entityId, @Param("attachment") Attachment attachment);

    /**
     * 删除附件关联关系, 根据实体对象流水号
     *
     * @param entityId 与附件关联的实体对象流水号
     */
    void deleteByOwner(@Param("entityId") String entityId);

    /**
     * 删除附件关联关系, 根据实体对象流水号和附件关联类型
     *
     * @param entityId      与附件关联的实体对象流水号
     * @param associateType 附件关联类型
     */
    void deleteByOwnerAndAssociate(@Param("entityId") String entityId, @Param("associateType") AttachmentAssociateType associateType);

    /**
     * 删除附件关联关系, 根据附件流水号
     *
     * @param id 附件流水号
     */
    void deleteByAttachment(@Param("id") String id);

    /**
     * 获取附件关系集合
     *
     * @param entityId 附件流水号
     */
    List<String> findByOwner(@Param("entityId") String entityId);

    /**
     * 获取附件关系集合
     *
     * @param entityId      附件流水号
     * @param associateType 附件关联类型
     */
    List<String> findByOwnerAndAssociate(@Param("entityId") String entityId, @Param("associateType") AttachmentAssociateType associateType);
}
