package com.simon.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {


    @Pointcut("execution(String com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void greetingLoggerPointCut() {}

    @Pointcut("execution(* com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void greetingFooLoggerPointCut() {}
}
