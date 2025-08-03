package com.simon.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //? si quiero que devuelva lo que sea, como un any
    // @Before("execution(* com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    //? En este otro caso, se ejecutara en cualquier metodo del servicio GreetingService
    // @Before("execution(* com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    //? Aqui se aplica para cualquier clase que implemente en el package services
    // @Before("execution(String com.simon.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    //? Aqui es para cualquier metodo que este dentro de las clases de todos los package (muy global)
    // @Before("execution(* *.*(..))")
    @Before("GreetingServicePointCuts.greetingLoggerPointCut()")
    public void loggerBeforeJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Antes: " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointCuts.greetingLoggerPointCut()")
    public void loggerAfterReturningJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Despues de retornar: " + method + " con los argumentos " + args);
    }

    @After("GreetingServicePointCuts.greetingLoggerPointCut()")
    public void loggerAfterJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Despues: " + method + " con los argumentos " + args);
    }


    @AfterThrowing("execution(String com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHelloError(..))")
    public void loggerAfterThrowingJoin(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=====Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    @Around("execution(String com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public Object loggerAroundJoin(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {   
            logger.info("=====Alrededor de: " + method + " con los argumentos " + args);
            result = joinPoint.proceed();
            logger.info("=====Retorna el metodo: " + method + " con el resultado: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("=====Error en el metodo: " + method + " con los argumentos " + args, e);
            throw e;
        }
    }

}
