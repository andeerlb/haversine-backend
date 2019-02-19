package br.coordinates.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

@Component
public class MyObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 4219938065516862637L;

    public MyObjectMapper() {
        super();
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}