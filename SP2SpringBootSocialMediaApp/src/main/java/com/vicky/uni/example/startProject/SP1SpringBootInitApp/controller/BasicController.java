package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.HelloWorld;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class BasicController {
    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return "hello World "+ LocalDateTime.now();
    }

    @GetMapping(path = "/gethelloWorldbean")
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld("Vicky");
    }

    @GetMapping(path = "/gethelloWorld/{phrase}")
    public HelloWorld getHelloWorldObject(@PathVariable String phrase) {
        return new HelloWorld(phrase);
    }
}
