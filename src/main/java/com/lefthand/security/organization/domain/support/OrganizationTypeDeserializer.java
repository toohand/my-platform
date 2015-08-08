package com.lefthand.security.organization.domain.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

class OrganizationTypeDeserializer extends JsonDeserializer<OrganizationType>
{
    public OrganizationType deserialize(JsonParser parser, DeserializationContext context)
            throws IOException
    {
        String id = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (StringUtils.equals(parser.getText(), "id")) {
                parser.nextToken();
                id = parser.getText();
            }
        }
        return OrganizationType.fromTypeId(Integer.valueOf(id).intValue());
    }
}