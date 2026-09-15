package br.com.udemy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public JsonMapper jsonMapper(JsonMapper.Builder builder) {
        // Define your filter criteria
        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("PersonFilter", SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));

        // Stops Jackson from throwing exceptions on classes missing the @JsonFilter annotation
        filters.setFailOnUnknownId(false);

        // Safely bake the filters directly into Jackson 3's immutable JsonMapper architecture
        return builder
                .filterProvider(filters)
                .build();
    }
}
