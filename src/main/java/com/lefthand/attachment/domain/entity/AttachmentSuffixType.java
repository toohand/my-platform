package com.lefthand.attachment.domain.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * 附件后缀枚举类
 */
@JsonSerialize(using = AttachmentSuffixTypeSerializer.class)
@JsonDeserialize(using = AttachmentSuffixTypeDeserializer.class)
public enum AttachmentSuffixType {

  // 音频
  ADU_WMA(2000, "wma"),
  ADU_MP3(2001, "mp3"),
  ADU_RA(2002, "ra"),

  // 视频
  VID_AVI(2100, "avi"),
  VID_MKV(2101, "mkv"),
  VID_WMV(2102, "wmv"),
  VID_MP4(2103, "mp4"),
  VID_RM(2104, "rm"),
  VID_RMVB(2105, "rmvb"),
  VID_3GP(2106, "3gp"),

  // 图片
  IMG_JPEG(2200, "jpeg"),
  IMG_JPG(2201, "jpg"),
  IMG_GIF(2202, "gif"),
  IMG_BMP(2203, "bmp"),
  IMG_PNG(2204, "png"),

  // Office Word
  OFC_DOC(2300, "doc"),
  OFC_DOCX(2301, "docx"),

  // Office Excel
  OFC_XLS(2400, "xls"),
  OFC_XLSX(2401, "xlsx"),

  // Office Power Point
  OFC_PPT(2500, "ppt"),
  OFC_PPTX(2501, "pptx"),

  // PDF
  OTH_PDF(2600, "pdf"),

  // 压缩文件
  OTH_RAR(2700, "rar"),
  OTH_ZIP(2701, "zip"),

  // 文本文件
  OTH_TXT(2800, "txt"),

  UNKNOWN(9999, "unknown");

  // 成员变量
  private int id;
  private String desc;

  // 构造方法
  private AttachmentSuffixType(int id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  // 静态方法
  public static AttachmentSuffixType fromTypeId(final int id) {
    switch (id) {
      // 音频
      case 2000:
        return ADU_WMA;
      case 2001:
        return ADU_MP3;
      case 2002:
        return ADU_RA;

      // 视频
      case 2100:
        return VID_AVI;
      case 2101:
        return VID_MKV;
      case 2102:
        return VID_WMV;
      case 2103:
        return VID_MP4;
      case 2104:
        return VID_RM;
      case 2105:
        return VID_RMVB;
      case 2106:
        return VID_3GP;

      // 图片
      case 2200:
        return IMG_JPEG;
      case 2201:
        return IMG_JPG;
      case 2202:
        return IMG_GIF;
      case 2203:
        return IMG_BMP;
      case 2204:
        return IMG_PNG;

      // Office Word
      case 2300:
        return OFC_DOC;
      case 2301:
        return OFC_DOCX;

      // Office Excel
      case 2400:
        return OFC_XLS;
      case 2401:
        return OFC_XLSX;

      // Office Power Point
      case 2500:
        return OFC_PPT;
      case 2501:
        return OFC_PPTX;

      // PDF
      case 2600:
        return OTH_PDF;

      // 压缩文件
      case 2700:
        return OTH_RAR;
      case 2701:
        return OTH_ZIP;

      // 文本文件
      case 2800:
        return OTH_TXT;

      default:
        return UNKNOWN;
    }
  }

  public int id() {
    return id;
  }

  public String desc() {
    return desc;
  }

  public void desc(String desc) {
    this.desc = desc;
  }
}

class AttachmentSuffixTypeSerializer extends JsonSerializer<AttachmentSuffixType> {

  @Override
  public void serialize(AttachmentSuffixType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
    generator.writeStartObject();
    generator.writeFieldName("id");
    generator.writeNumber(value.id());
    generator.writeFieldName("desc");
    generator.writeString(value.desc());
    generator.writeEndObject();
  }
}

class AttachmentSuffixTypeDeserializer extends JsonDeserializer<AttachmentSuffixType> {

  @Override
  public AttachmentSuffixType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
    String id = null;
    while (parser.nextToken() != JsonToken.END_OBJECT) {
      if (StringUtils.equals(parser.getText(), "id")) {
        parser.nextToken();
        id = parser.getText();
      }
    }
    return AttachmentSuffixType.fromTypeId(Integer.valueOf(id));
  }
}