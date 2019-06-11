package com.example.utils;

import com.example.helper.LoggerHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UsersRequestIncreptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger("request-log");

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {
        logger.info(LoggerHelper.requestLogBuilder(request));
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws JsonProcessingException {
        logger.info(LoggerHelper.responseLogBuilder(response));

    }
}