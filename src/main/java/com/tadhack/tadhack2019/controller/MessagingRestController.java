package com.tadhack.tadhack2019.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.tadhack.tadhack2019.messaging.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class MessagingRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(MessagingRestController.class);

    private MessagingService messagingService;

    public MessagingRestController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @GetMapping("send/{urlString}")
    public String sendMessage(@PathVariable final String urlString) throws FirebaseMessagingException, IOException {
        LOGGER.info("Sending message to URL {}", urlString);
        return messagingService.sendMessage(urlString);
    }

}
