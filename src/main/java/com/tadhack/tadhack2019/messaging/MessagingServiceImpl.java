package com.tadhack.tadhack2019.messaging;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.tadhack.tadhack2019.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessagingServiceImpl implements MessagingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingServiceImpl.class);

    @Override
    public String sendMessage(final UserDto userDto, String messageURL) throws FirebaseMessagingException {
        final String topic = userDto.getName() + " " + userDto.getSurname();
        final Message message = Message.builder().setNotification(new Notification(messageURL, messageURL)).setTopic(topic).build();
        final String response = FirebaseMessaging.getInstance().send(message);
        LOGGER.info("Successfully sent message: ", response);
        return messageURL;
    }

}