package com.lefthand.attachment.domain.support;


import com.lefthand.attachment.domain.entity.AttachmentType;

/**
 *
 */
public class AttachmentSuffixConvert {

  private AttachmentSuffixConvert() {
  }

  public static AttachmentType convert(String suffix) {

    AttachmentType result = null;

    // 音频
    if (ADU_WMA.desc().equals(suffix)
            || ADU_MP3.desc().equals(suffix)
            || ADU_RA.desc().equals(suffix)) {
      result = AttachmentType.AUDIO;
    }
    // 视频
    else if (VID_AVI.desc().equals(suffix)
            || VID_MKV.desc().equals(suffix)
            || VID_WMV.desc().equals(suffix)
            || VID_MP4.desc().equals(suffix)
            || VID_RM.desc().equals(suffix)
            || VID_RMVB.desc().equals(suffix)
            || VID_3GP.desc().equals(suffix)) {
      result = AttachmentType.VIDEO;
    }
    // 图片
    else if (IMG_JPEG.desc().equals(suffix)
            || IMG_JPG.desc().equals(suffix)
            || IMG_GIF.desc().equals(suffix)
            || IMG_BMP.desc().equals(suffix)
            || IMG_PNG.desc().equals(suffix)) {
      result = AttachmentType.IMAGE;
    }
    // Office Word
    else if (OFC_DOC.desc().equals(suffix)
            || OFC_DOCX.desc().equals(suffix)) {
      result = AttachmentType.OFFICEWORD;
    }
    // Office Excel
    else if (OFC_XLS.desc().equals(suffix)
            || OFC_XLSX.desc().equals(suffix)) {
      result = AttachmentType.OFFICEEXCEL;
    }
    // Office Power Point
    else if (OFC_PPT.desc().equals(suffix)
            || OFC_PPTX.desc().equals(suffix)) {
      result = AttachmentType.OFFICEPOWERPOINT;
    }
    // PDF
    else if (OTH_PDF.desc().equals(suffix)) {
      result = AttachmentType.PDF;
    }
    // 压缩文件
    else if (OTH_RAR.desc().equals(suffix)
            || OTH_ZIP.desc().equals(suffix)) {
      result = AttachmentType.ZIP;
    }
    // 压缩文件
    else if (OTH_TXT.desc().equals(suffix)) {
      result = AttachmentType.TXT;
    }
    // 其它文件
    else {
      result = AttachmentType.UNKNOWN;
    }
    return result;
  }
}
