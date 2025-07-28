package com.simon.curso.springboot.app.aop.springboot_aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // si quiero que devuelva lo que sea, como un any
    // @Before("execution(* com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    @Before("execution(String com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerBeforeJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

}
