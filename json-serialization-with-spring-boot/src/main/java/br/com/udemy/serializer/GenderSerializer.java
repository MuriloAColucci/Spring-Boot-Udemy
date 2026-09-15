package br.com.udemy.serializer;

import org.springframework.boot.jackson.ObjectValueSerializer;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.SerializationContext;

import java.io.IOException;

public class GenderSerializer extends ValueSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jgen, SerializationContext provider) {
        if (value == null) {
            jgen.writeNull();
            return;
        }

        String upper = value.trim().toUpperCase();
        if (upper.startsWith("M")) {
            jgen.writeString("M");
        } else if (upper.startsWith("F")) {
            jgen.writeString("F");
        } else {
            jgen.writeString(value); // Fallback caso venha outro valor
        }
    }
}