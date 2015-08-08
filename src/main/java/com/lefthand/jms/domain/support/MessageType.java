package com.lefthand.jms.domain.support;

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
 * 消息类型
 * Created by wangmz on 2015/7/10.
 */
@JsonSerialize(using = MessageTypeSerializer.class)
@JsonDeserialize(using = MessageTypeDeserializer.class)
public enum MessageType {
    NULL(1000,"默认没有"),
    TODO(1001, "待办"),
    NOTICE(1002, "通知");

    // 成员变量
    private int id;
    private String desc;

    // 构造方法
    private MessageType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    // 静态方法
    public static MessageType fromTypeId(final int id) {
        switch (id) {
            case 1000:
                return NULL;
            case 1001:
                return TODO;
            case 1002:
                return NOTICE;
            default:
                return NULL;
        }
    }

    public int id() {
        return id;
    }

    public String desc() {
        return desc;
    }
}

class MessageTypeSerializer extends JsonSerializer<MessageType> {

    @Override
    public void serialize(MessageType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeNumber(value.id());
        generator.writeFieldName("desc");
        generator.writeString(value.desc());
        generator.writeEndObject();
    }
}

class MessageTypeDeserializer extends JsonDeserializer<MessageType> {

    @Override
    public MessageType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        String id = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (StringUtils.equals(parser.getText(), "id")) {
                parser.nextToken();
                id = parser.getText();
            }
        }
        return MessageType.fromTypeId(Integer.valueOf(id));
    }
}
