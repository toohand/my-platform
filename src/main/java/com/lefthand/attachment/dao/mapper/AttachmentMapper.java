package com.lefthand.attachment.dao.mapper;

import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.security.organization.domain.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 附件映射接口
 */
@Repository
public interface AttachmentMapper {

    /**
     * 插入附件
     *
     * @param attachment 附件实体对象
     */
    void insert(@Param("attachment") Attachment attachment);

    /**
     * 更新附件
     *
     * @param attachment 附件实体对象
     */
    void update(@Param("attachment") Attachment attachment);

    /**
     * 更新附件新名称
     *
     * @param id         附件流水号
     * @param newName    新名称
     * @param creator    创建人, 岗位对象
     * @param updateTime 更新时间
     */
    void updateNewName(@Param("id") String id, @Param("newName") String newName, @Param("creator") Post creator, @Param("updateTime") Date updateTime);

    /**
     * 更新删除状态
     *
     * @param id         附件编号
     * @param isDeleted  是否删除标识
     * @param updateTime 更新时间
     */
    void updateDeteleStatus(@Param("id") String id, @Param("isDeleted") boolean isDeleted, @Param("updateTime") Date updateTime);

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    Attachment find(@Param("id") String id);

    /**
     * 获取附件
     *
     * @param entityId      与附件关联的实体对象
     * @param associateType 附件关联类型
     */
    Attachment findByOwnerAndAssociate(@Param("entityId") String entityId, @Param("associateType") AttachmentAssociateType associateType);

    /**
     * @param entityId       与附件关联的实体对象
     * @param associateTypes 附件关联类型集合
     */
    List<Attachment> findsByOwnerAssociate(@Param("entityId") String entityId, @Param("associateTypes") AttachmentAssociateType... associateTypes);

    /**
     * 按条件查询资料总数
     *
     * @param terms 查询条件集合
     */
    long queryTotal(@Param("terms") Map<String, Object> terms);

    /**
     * 按条件查询资料分页结果集
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    List<Attachment> queryContent(@Param("page") PageRequest page, @Param("terms") Map<String, Object> terms);

    /**
     * 检测md5码是否存在
     *
     * @param md5 md5字符串
     * @return md5数量
     */
    long checkmd5(@Param("md5") String md5);

}
