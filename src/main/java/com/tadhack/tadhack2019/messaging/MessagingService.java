package com.tadhack.tadhack2019.messaging;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.tadhack.tadhack2019.model.UserDto;

public interface MessagingService {

    String sendMessage(UserDto userDto, String messageURL) throws FirebaseMessagingException;

}
