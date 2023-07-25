package org.bfsi.notification.consumer;

import org.bfsi.notification.model.KafkaModel;
import org.bfsi.notification.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name1}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(String msg) {
        logger.info("Message Consumed Success: " + msg);
    }

}
