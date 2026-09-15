package br.com.udemy.serilization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public final class YamlJackson2HttpMessageConverter extends AbstractHttpMessageConverter {

    private final YAMLMapper yamlMapper;

    public YamlJackson2HttpMessageConverter() {
        super(MediaType.valueOf("application/yaml"));

        this.yamlMapper = YAMLMapper.builder()
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

    @Override
    protected boolean supports(Class clazz) {
        return false;
    }
}
