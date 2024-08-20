package com.app.webf1;

import com.app.webf1.config.ObjectMapperConfig;

public class JsonString {
    private static ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();

    public static    String asJsonString(final Object obj) {
        try {
            return objectMapperConfig.objectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
