package com.tadhack.tadhack2019.messaging;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface MessagingService {

    String sendMessage(final String messageURL) throws FirebaseMessagingException;

}
