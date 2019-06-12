package com.example.helper;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class LoggerHelper {

    public static String requestLogBuilder(HttpServletRequest httpServletRequest) throws IOException {
        return "REQ -- METHOD: [" + httpServletRequest.getMethod() + "],\t PATH: [" + httpServletRequest.getServletPath() + "],\t HEADERS: "
                + LoggerHelper.customGetHeaders(httpServletRequest).entrySet().toString();
    }

    public static String responseLogBuilder(HttpServletResponse response) throws JsonProcessingException {
        return "RES -- HEADERS: " + response.getHeaderNames().toString() + "],\t STATUS: [" + response.getStatus() + "]";
    }

    private static Map<String, String> customGetHeaders(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}