package com.dreammakerteam.ss.core.sdk.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

public class NullSafeJacksonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> Optional<T> parse(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(MAPPER.readValue(json, clazz));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}
