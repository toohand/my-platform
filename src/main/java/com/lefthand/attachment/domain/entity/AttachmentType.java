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
 * 附件类型枚举类
 */
@JsonSerialize(using = AttachmentTypeSerializer.class)
@JsonDeserialize(using = AttachmentTypeDeserializer.class)
public enum AttachmentType {
  NULL(19,"默认没有"),
  AUDIO(20, "音频"),
  VIDEO(21, "视频"),
  IMAGE(22, "图片"),
  OFFICEWORD(23, "Word"),
  OFFICEEXCEL(24, "Excel"),
  OFFICEPOWERPOINT(25, "Power Point"),
  PDF(26, "PDF"),
  ZIP(27, "压缩文件"),
  TXT(28, "文本文件"),
  UNKNOWN(99, "其它文件");

  // 成员变量
  private int id;
  private String desc;

  // 构造方法
  private AttachmentType(int id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  // 静态方法
  public static AttachmentType fromTypeId(final int id) {
    switch (id) {
      case 19:
        return NULL;
      case 20:
        return AUDIO;
      case 21:
        return VIDEO;
      case 22:
        return IMAGE;
      case 23:
        return OFFICEWORD;
      case 24:
        return OFFICEEXCEL;
      case 25:
        return OFFICEPOWERPOINT;
      case 26:
        return PDF;
      case 27:
        return ZIP;
      case 28:
        return TXT;
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
}

class AttachmentTypeSerializer extends JsonSerializer<AttachmentType> {

  @Override
  public void serialize(AttachmentType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
    generator.writeStartObject();
    generator.writeFieldName("id");
    generator.writeNumber(value.id());
    generator.writeFieldName("desc");
    generator.writeString(value.desc());
    generator.writeEndObject();
  }
}

class AttachmentTypeDeserializer extends JsonDeserializer<AttachmentType> {

  @Override
  public AttachmentType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
    String id = null;
    while (parser.nextToken() != JsonToken.END_OBJECT) {
      if (StringUtils.equals(parser.getText(), "id")) {
        parser.nextToken();
        id = parser.getText();
      }
    }
    return AttachmentType.fromTypeId(Integer.valueOf(id));
  }
}
