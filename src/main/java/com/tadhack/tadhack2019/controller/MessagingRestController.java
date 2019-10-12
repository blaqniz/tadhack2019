package com.tadhack.tadhack2019.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.tadhack.tadhack2019.messaging.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class MessagingRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(MessagingRestController.class);

    private MessagingService messagingService;

    public MessagingRestController(@Qualifier("MessagingServiceImpl") MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @GetMapping("send/{liveStreamVideoUrl}")
    public String sendMessage(@PathVariable final String liveStreamVideoUrl) throws FirebaseMessagingException, IOException {
        LOGGER.info("Sending message to URL {}", liveStreamVideoUrl);
        return messagingService.sendMessage(liveStreamVideoUrl);
    }

}
