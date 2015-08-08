package com.lefthand.attachment.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lefthand.attachment.domain.support.AttachmentSuffixConvert;
import com.lefthand.attachment.service.AttachmentContextHolder;
import com.lefthand.comm.domain.AbstractUpdatableEntity;
import com.lefthand.security.organization.domain.Post;

/**
 * 附件实体
 */
public class Attachment extends AbstractUpdatableEntity {

    /**
     * 附件名
     */
    private String name;

    /**
     * 附件后缀, doc|docx|xsl|xslx 等
     */
    private String suffix;

    /**
     * 附件关联类型
     */
    private AttachmentAssociateType associateType = AttachmentAssociateType.NULL;

    /**
     * 附件类型, 音频|视频|图片 等
     */
    private AttachmentType type;

    /**
     * 附件存储目录，是相对路径，而且不包括文件名
     */
    private String dir;

    /**
     * 附件大小
     */
    private double size;

    /**
     * 单位, B|KB|MB|GB
     */
    private String unit;

    /**
     * 附件验证码
     */
    private String md5;

    /**
     * 创建者
     */
//    @JsonIgnore
    private Post creator;

    public Attachment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix.toLowerCase();
        this.type = AttachmentSuffixConvert.convert(suffix);
    }

    public AttachmentAssociateType getAssociateType() {
        return associateType;
    }

    public void setAssociateType(AttachmentAssociateType associateType) {
        this.associateType = associateType;
    }

    public AttachmentType getType() {
        return type;
    }

//    @JsonIgnore
    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return 返回完整附件存储路径
     */
    @JsonIgnore
    public String getPath() {
        String root = AttachmentContextHolder.getRootDir();
        return root + dir + "/" + getId() + "." + suffix;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Post getCreator() {
        return creator;
    }

    public void setCreator(Post creator) {
        this.creator = creator;
    }
}
