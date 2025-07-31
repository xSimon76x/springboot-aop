package com.simon.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.app.aop.springboot_aop.services.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {


    @Autowired
    GreetingService greetingService;

    @GetMapping("/saludar")
    public ResponseEntity<?> greting() {
        System.out.println("=====Entrando al controlador saludar");
        return ResponseEntity.ok(Collections.singletonMap("greting", greetingService.sayHello("Simon", "Hola que tal!")));
    }

    @GetMapping("/saludar-error")
    public ResponseEntity<?> gretingError() {
        System.out.println("=====Entrando al controlador saludar");
        return ResponseEntity.ok(Collections.singletonMap("greting", greetingService.sayHelloError("Simon", "Hola que tal!")));
    }
    


}
