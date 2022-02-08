package com.sbrf.reboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;

public class JSONUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    public static String toJSON(Request request) {
        return objectMapper.writeValueAsString(request);
    }

    @SneakyThrows
    public static String toJSON(Response response) {
        return objectMapper.writeValueAsString(response);
    }

    @SneakyThrows
    public static Request JSONtoRequest(String s) {
        return objectMapper.readValue(s, Request.class);
    }

    @SneakyThrows
    public static Response JSONtoResponse(String s) {
        return objectMapper.readValue(s, Response.class);
    }
}
