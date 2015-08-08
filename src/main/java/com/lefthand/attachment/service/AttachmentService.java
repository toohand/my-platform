package com.lefthand.attachment.service;

import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.comm.domain.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 附件服务接口
 */
public interface AttachmentService {

    /**
     * 保存一个或多个附件<附件关系类型默认没有>
     *
     * @param entityId      业务编号
     * @param attachmentIds 一个或多个附件编号
     */
    void save(String entityId, String... attachmentIds);

    /**
     * 保存一个或多个附件
     *
     * @param entityId      业务编号
     * @param associateType 附件关系类型，参考 AttachmentAssociateType
     * @param attachmentIds 一个或多个附件编号
     */
    void save(String entityId, int associateType, String... attachmentIds);

    /**
     * 保存一个附件
     *
     * @param entity        业务对象
     * @param attachment    附件
     */
    void save(Entity entity, Attachment attachment);

    /**
     * 保存多个附件
     *
     * @param entity        业务对象
     * @param attachments   附件集合
     */
    void save(Entity entity, List<Attachment> attachments);

    /**
     * 保存附件<一次性保存文件和附件关系>
     *
     * @param entityId      业务编号
     * @param associateType 附件关系类型，参考 AttachmentAssociateType
     * @param file          文件对象
     * @return
     */
    Attachment save(String entityId, int associateType, MultipartFile file);

    /**
     * 创建附件文件
     *
     * @param file 文件对象
     */
    Attachment create(MultipartFile file);

    /**
     * 读取附件文件
     *
     * @param path 附件路径
     */
    InputStream read(String path);

    /**
     * 更新附件
     *
     * @param id   附件编号
     * @param file 文件对象
     */
    Attachment update(String id, MultipartFile file);

    /**
     * 删除附件
     *
     * @param id 附件流水号
     */
    void delete(String id);

    /**
     * 根据业务编号，删除附件
     *
     * @param entityId      业务编号
     * @param associateType 附件关联类型
     */
    void deleteByOwner(String entityId, AttachmentAssociateType associateType);

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    Attachment find(String id);

    /**
     * 获取附件
     *
     * @param entityId      与附件关联的实体对象流水号
     * @param associateType 附件关联类型
     */
    Attachment findByOwnerAndAssociateType(String entityId, AttachmentAssociateType associateType);

    /**
     * 获取附件集合
     *
     * @param entityId       与附件关联的实体对象流水号
     * @param associateTypes 附件关联类型集合
     */
    List<Attachment> findByOwnerAndAssociateTypes(String entityId, AttachmentAssociateType... associateTypes);

    /**
     * 按条件分页查询附件
     *
     * @param page  分页对象
     * @param terms 查询条件集合
     */
    Page<Attachment> query(PageRequest page, Map<String, Object> terms);

}
