package com.tadhack.tadhack2019.messaging;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class MessagingServiceImpl implements MessagingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingServiceImpl.class);
    private static final String TOPIC_STRING = "tadhack2019";
    private static final String PATH = "src/tadhack2019-e0e16-firebase-adminsdk-n4i43-d1828b889d.json";

    @Override
    public String sendMessage(final String messageURL) throws FirebaseMessagingException, IOException {
        final String topic = TOPIC_STRING;
        configureFirebaseOptions();
        final Message message = Message.builder().setNotification(new Notification(messageURL, messageURL)).setTopic(topic).build();
        final String response = FirebaseMessaging.getInstance().send(message);
        LOGGER.info("Successfully sent message: {}", response);
        return messageURL;
    }

    private void configureFirebaseOptions() throws IOException {
        final FileInputStream refreshToken = new FileInputStream(PATH);
        final FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .build();
        FirebaseApp.initializeApp(options);
    }

}