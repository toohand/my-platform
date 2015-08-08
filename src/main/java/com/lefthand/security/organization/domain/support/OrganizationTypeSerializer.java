package com.lefthand.security.organization.domain.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

class OrganizationTypeSerializer extends JsonSerializer<OrganizationType>
{
    public void serialize(OrganizationType value, JsonGenerator generator, SerializerProvider provider)
            throws IOException
    {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeNumber(value.id());
        generator.writeFieldName("desc");
        generator.writeString(value.desc());
        generator.writeEndObject();
    }
}