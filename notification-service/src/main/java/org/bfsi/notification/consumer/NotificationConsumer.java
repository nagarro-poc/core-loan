package org.bfsi.notification.consumer;

import org.bfsi.notification.serviceImpl.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @Autowired
    NotificationService notificationService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name1}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(String msg) {
        /*org.bfsi.notification.Entity.NotificationEntity  entity = new
                org.bfsi.notification.Entity.NotificationEntity ();

        entity.setEmail(msg.getEmail());
        entity.setFirstName(msg.getFirstName());
        entity.setLastname(msg.getLastname());
        entity.setMessage(msg.getMessage());
        entity.setStatus(msg.getStatus());
        entity.setLeadId(msg.getLeadId());*/

        //notificationService.createNotification(entity);
        logger.info("Message Consumed Success: " + msg);
    }

}
