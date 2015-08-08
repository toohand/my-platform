package com.lefthand.attachment.domain.support;

import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.attachment.service.AttachmentContextHolder;
import com.lefthand.comm.domain.Entity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 *上传附件包装处理类
 */
public class MultipartFileWrapper {

    static final String SLANT = "/";
    static final String DOT = ".";

    static final String B = "B";
    static final String KB = "KB";
    static final String MB = "MB";
    static final String GB = "GB";

    static final long kilobyte = 1024;
    static final long megabyte = 1024 * 1024L;
    static final long gigabyte = 1024 * 1024 * 1024L;

    static final BigDecimal kilobyteDividend = new BigDecimal(kilobyte);
    static final BigDecimal megabyteDividend = new BigDecimal(megabyte);
    static final BigDecimal gigabyteDividend = new BigDecimal(gigabyte);

    private MultipartFile file;

    public MultipartFileWrapper(MultipartFile file) {
        this.file = file;
    }

    public Attachment toAttachment() {
        Attachment attachment = new Attachment();
        attachment.setName(this.getFileName());
        attachment.setSuffix(this.getFileSuffix());
        attachment.setDir(this.getFileDir());
        attachment.setSize(this.getFileSize());
        attachment.setUnit(this.getFileUnit());
        attachment.setMd5(this.getFileVerifyCode());
        attachment.setCreator((com.lefthand.security.organization.domain.Post) com.lefthand.comm.context.SecurityContextHolder.getHandler());
        return attachment;
    }

    /**
     * 获取文件名称
     */
    public String getFileName() {
        return StringUtils.substringBeforeLast(this.file.getOriginalFilename(), DOT);
    }

    /**
     * 获取文件后缀
     */
    public String getFileSuffix() {
        return StringUtils.substringAfterLast(this.file.getOriginalFilename(), DOT);
    }

    /**
     * 获取文件存储目录，以斜杠开头
     */
    public String getFileDir() {
        //按照年月构建目录
        Calendar ca = Calendar.getInstance();
        StringBuilder builder = new StringBuilder();
        builder.append(SLANT);
        builder.append(ca.get(Calendar.YEAR));
        builder.append(SLANT);
        builder.append(ca.get(Calendar.MONTH) + 1);
        return builder.toString();
    }

    /**
     * 获取文件存储目录
     *
     * @param owner         附件所有者
     * @param associateType 附件关联类型
     */
    public String getFileDir(Entity owner, AttachmentAssociateType associateType) {
        StringBuilder builder = new StringBuilder();
        builder.append(AttachmentContextHolder.getRootDir());
        builder.append(SLANT);
        builder.append(StringUtils.substring(String.valueOf(associateType.id()), 0, 2));
        builder.append(SLANT);
        builder.append(owner.getId());
        builder.append(SLANT);
        builder.append(associateType.id());
        return builder.toString();
    }

    /**
     * 获取文件大小, 根据不同的单位进行运算
     */
    public double getFileSize() {
        long size = this.file.getSize();
        BigDecimal divisor = new BigDecimal(size);
        String unit = this.getFileUnit();

        if (B.equals(unit)) {
            return size;
        } else if (KB.equals(unit)) {
            return divisor.divide(kilobyteDividend, 2, RoundingMode.HALF_UP).doubleValue();
        } else if (MB.equals(unit)) {
            return divisor.divide(megabyteDividend, 2, RoundingMode.HALF_UP).doubleValue();
        } else if (GB.equals(unit)) {
            return divisor.divide(gigabyteDividend, 2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0;
    }

    /**
     * 获取文件单位, B|KB|MB|GB
     */
    public String getFileUnit() {
        long size = this.file.getSize();
        if (size > 0 && size <= kilobyte) {
            return B;
        } else if (size > kilobyte && size <= megabyte) {
            return KB;
        } else if (size > megabyte && size <= gigabyte) {
            return MB;
        } else if (size > gigabyte) {
            return GB;
        }
        return B;
    }

    /**
     * 获取文件校验码, MD5
     */
    public String getFileVerifyCode() {
        try {
            return DigestUtils.md5Hex(this.file.getBytes());
        } catch (IOException e) {
            throw new com.lefthand.comm.exception.ServiceException("file verify code error.", e);
        }
    }
}
