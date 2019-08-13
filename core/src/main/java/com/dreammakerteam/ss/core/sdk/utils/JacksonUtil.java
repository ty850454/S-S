package com.dreammakerteam.ss.core.sdk.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

public class JacksonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> Optional<T> nullSafeParse(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(MAPPER.readValue(json, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static String toJson(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }

    }

}
