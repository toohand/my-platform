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
 * 附件关联类型枚举类
 */
@JsonSerialize(using = AttachmentAssociateTypeSerializer.class)
@JsonDeserialize(using = AttachmentAssociateTypeDeserializer.class)
public enum AttachmentAssociateType {

    // 罗列十个附件类型的值, 业务系统各自分配认领
    NULL(1000,"默认没有"),
    ATTACHMENT_TYPE_1001(1001, "个人相册"),//个人相册
    ATTACHMENT_TYPE_1002(1002, "工作照"),//工作照
    ATTACHMENT_TYPE_1003(1003, "附件类型1003"),
    ATTACHMENT_TYPE_1004(1004, "附件类型1004"),
    ATTACHMENT_TYPE_1005(1005, "附件类型1005"),
    ATTACHMENT_TYPE_1006(1006, "附件类型1006"),
    ATTACHMENT_TYPE_1007(1007, "附件类型1007"),
    ATTACHMENT_TYPE_1008(1008, "附件类型1008"),
    ATTACHMENT_TYPE_1009(1009, "附件类型1009");

    // 成员变量
    private int id;
    private String desc;

    // 构造方法
    private AttachmentAssociateType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    // 静态方法
    public static AttachmentAssociateType fromTypeId(final int id) {
        switch (id) {
            case 1000:
                return NULL;
            case 1001:
                return ATTACHMENT_TYPE_1001;// 附件类型1001
            case 1002:
                return ATTACHMENT_TYPE_1002;// 附件类型1002
            case 1003:
                return ATTACHMENT_TYPE_1003;// 附件类型1003
            case 1004:
                return ATTACHMENT_TYPE_1004;// 附件类型1004
            case 1005:
                return ATTACHMENT_TYPE_1005;// 附件类型1005
            case 1006:
                return ATTACHMENT_TYPE_1006;// 附件类型1006
            case 1007:
                return ATTACHMENT_TYPE_1007;// 附件类型1007
            case 1008:
                return ATTACHMENT_TYPE_1008;// 附件类型1008
            case 1009:
                return ATTACHMENT_TYPE_1009;// 附件类型1009
        }
        throw new IllegalArgumentException("Invalid AttachmentAssociateType Id: " + id);
    }

    public int id() {
        return id;
    }

    public String desc() {
        return desc;
    }
}


class AttachmentAssociateTypeSerializer extends JsonSerializer<AttachmentAssociateType> {

    @Override
    public void serialize(AttachmentAssociateType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeNumber(value.id());
        generator.writeFieldName("desc");
        generator.writeString(value.desc());
        generator.writeEndObject();
    }
}

class AttachmentAssociateTypeDeserializer extends JsonDeserializer<AttachmentAssociateType> {

    @Override
    public AttachmentAssociateType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        String id = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (StringUtils.equals(parser.getText(), "id")) {
                parser.nextToken();
                id = parser.getText();
            }
        }
        return AttachmentAssociateType.fromTypeId(Integer.valueOf(id));
    }
}
