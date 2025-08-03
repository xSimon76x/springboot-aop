package com.simon.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointCuts.greetingFooLoggerPointCut()")
    public void loggerBeforeJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Antes: " + method + " invocando con los argumentos " + args + " desde GreetingFooAspect");
    }

    @After("GreetingServicePointCuts.greetingFooLoggerPointCut()")
    public void loggerAfterJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Despues: " + method + " con los argumentos " + args + " desde GreetingFooAspect");
    }
}
