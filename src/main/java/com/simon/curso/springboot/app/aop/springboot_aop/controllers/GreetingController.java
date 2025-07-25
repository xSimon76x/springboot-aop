package com.simon.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {


    @GetMapping("/saludar")
    public ResponseEntity<?> greting() {
        return ResponseEntity.ok(Collections.singletonMap("greting", null));
    }
    


}
