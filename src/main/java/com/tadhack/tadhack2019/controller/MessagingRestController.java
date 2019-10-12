package com.tadhack.tadhack2019.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class MessagingRestController {

    @GetMapping
    public String sendMessage(@RequestParam final String urlString) {
        return urlString;
    }

}
