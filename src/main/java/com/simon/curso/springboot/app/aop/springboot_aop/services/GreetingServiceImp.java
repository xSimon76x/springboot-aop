package com.simon.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImp implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) {
        System.out.println("=====Durante");
        String greeting = phrase + " " + person;
        // System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("Error al saludar a " + person + " con la frase: " + phrase);
    }



}
