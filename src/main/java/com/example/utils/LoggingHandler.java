package com.example.utils;

import com.example.helper.LoggerHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;

@Aspect
@Component
public class LoggingHandler {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoggingHandler(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {
    }


    @Before("controller()")
    public void logBefore(JoinPoint thisJoinPoint) throws IOException {
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
        Annotation[][] annotationMatrix = methodSignature.getMethod().getParameterAnnotations();
        int index = -1;
        for (Annotation[] annotations : annotationMatrix) {
            index++;
            for (Annotation annotation : annotations) {
                if (!(annotation instanceof RequestBody))
                    continue;
                Object requestBody = thisJoinPoint.getArgs()[index];
                log.info(LoggerHelper.requestLogBuilder(request) + "\nRequest body = " + requestBody);
            }
        }
    }

    @AfterReturning(pointcut = "controller()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        log.info(LoggerHelper.responseLogBuilder(response) + "\tResponse body : " + result.toString());
    }
}
