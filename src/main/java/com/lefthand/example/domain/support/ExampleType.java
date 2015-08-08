package com.lefthand.example.domain.support;

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
 * Created by wangmz on 2014/9/29.
 */
@JsonSerialize(using = ExampleTypeSerializer.class)
@JsonDeserialize(using = ExampleTypeDeserializer.class)
public enum ExampleType {
    DBLZ      (1,"代表履职系统"),
    DZYW     (2,"电子阅文系统"),
    OA         (3,"OA办文系统"),
    HWGL     (4,"会务管理系统"),
    YAJY  (5,"议案建议系统"),
    DXPT  (6,"短信平台"),
    TWZY  (7,"图文资源系统"),
    CWHZCRYLZ  (8,"常委会组成人员履职系统"),
    DEFAULT (99,"请选择");//默认值

    private ExampleType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private int id;
    private String desc;

    // 静态方法
    public static ExampleType fromTypeId(final int id) {
        switch (id) {
            case 1:
                return DBLZ;
            case 2:
                return DZYW;
            case 3:
                return OA;
            case 4:
                return HWGL;
            case 5:
                return YAJY;
            case 6:
                return DXPT;
            case 7:
                return TWZY;
            case 8:
                return CWHZCRYLZ;
            case 99:
                return DEFAULT;
        }
        throw new IllegalArgumentException("Invalid ExampleType Id: " + id);
    }

    public int id(){
        return id;
    }

    public String desc(){
        return desc;
    }
}

class ExampleTypeSerializer extends JsonSerializer<ExampleType> {

    @Override
    public void serialize(ExampleType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeNumber(value.id());
        generator.writeFieldName("desc");
        generator.writeString(value.desc());
        generator.writeEndObject();
    }
}

class ExampleTypeDeserializer extends JsonDeserializer<ExampleType> {

    @Override
    public ExampleType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        String id = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (StringUtils.equals(parser.getText(), "id")) {
                parser.nextToken();
                id = parser.getText();
            }
        }
        return ExampleType.fromTypeId(Integer.valueOf(id));
    }
}
