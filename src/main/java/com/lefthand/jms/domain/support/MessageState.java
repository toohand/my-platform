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
 * 消息状态枚举
 * Created by wangmz on 2015/7/15.
 */
@JsonSerialize(using = MessageStateSerializer.class)
@JsonDeserialize(using = MessageStateDeserializer.class)
public enum MessageState {
    NULL(1000,"默认没有"),
    SUCCESS(1001, "成功"),
    FAIL(1002, "失败");

    // 成员变量
    private int id;
    private String desc;

    // 构造方法
    private MessageState(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    // 静态方法
    public static MessageState fromTypeId(final int id) {
        switch (id) {
            case 1000:
                return NULL;
            case 1001:
                return SUCCESS;
            case 1002:
                return FAIL;
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

class MessageStateSerializer extends JsonSerializer<MessageState> {

    @Override
    public void serialize(MessageState value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeNumber(value.id());
        generator.writeFieldName("desc");
        generator.writeString(value.desc());
        generator.writeEndObject();
    }
}

class MessageStateDeserializer extends JsonDeserializer<MessageState> {

    @Override
    public MessageState deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        String id = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (StringUtils.equals(parser.getText(), "id")) {
                parser.nextToken();
                id = parser.getText();
            }
        }
        return MessageState.fromTypeId(Integer.valueOf(id));
    }
}
