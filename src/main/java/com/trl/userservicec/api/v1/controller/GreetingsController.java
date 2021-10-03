package com.trl.userservicec.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @GetMapping("/greetings")
    public String getGreetings() {
        return "Hello !!!";
    }

}
