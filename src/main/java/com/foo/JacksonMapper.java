package com.foo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2015-3-10.
 */
public class JacksonMapper {
    private JacksonMapper(){}

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getJacksonMapper(){
        return objectMapper;
    }

}
