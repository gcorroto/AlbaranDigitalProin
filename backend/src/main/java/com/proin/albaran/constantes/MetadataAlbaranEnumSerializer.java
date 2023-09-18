package com.proin.albaran.constantes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MetadataAlbaranEnumSerializer extends StdSerializer<MetadataAlbaranEnum> {
    
    public MetadataAlbaranEnumSerializer() {
        super(MetadataAlbaranEnum.class);
    }
@Override
    public void serialize(
        MetadataAlbaranEnum albaran, JsonGenerator generator, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("name");
        generator.writeString(albaran.getName());
        generator.writeFieldName("displayName");
        generator.writeString(albaran.getDisplayName());
        generator.writeFieldName("groupName");
        generator.writeString(albaran.getGroupName());
        generator.writeFieldName("index");
        generator.writeNumber(albaran.getIndex());
        generator.writeFieldName("editor");
        generator.writeString(albaran.getEditor());
        generator.writeEndObject();
    }

}