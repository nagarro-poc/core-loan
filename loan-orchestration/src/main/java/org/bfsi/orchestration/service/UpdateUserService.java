package org.bfsi.orchestration.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.bfsi.orchestration.bean.NotificationEntity;
import org.bfsi.orchestration.entity.LoanRequest;
import org.bfsi.orchestration.entity.UserModel;
import org.bfsi.orchestration.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {
    Logger logger = LoggerFactory.getLogger(UpdateUserService.class);

    @Autowired
    UserServiceFeignClient userServiceFeignClient;

    @Autowired
    KafkaProducer kafkaProducer;

    @Cacheable(value = "user", key = "#id")
    @CircuitBreaker(name = "userService", fallbackMethod = "userFallback")
    public UserModel callUserModelFeign(Long id) {
        logger.info("Fetching User using feign:" + id);
        kafkaProducer.sendMessage("Hello from loan orchestration-" + id);
        return userServiceFeignClient.getUserDetails(id);
    }

    //@Cacheable(value = "loanUser", key = "#id")
    @CircuitBreaker(name = "userService", fallbackMethod = "saveFallback")
    public LoanRequest udpateLoanFeign(LoanRequest loanRequest) {
        logger.info("Fetching User using feign:" + loanRequest);
        return userServiceFeignClient.saveLeadData(loanRequest).getBody();
    }

    public UserModel userFallback(Exception e) {
        logger.info("UserFallback:" + e.toString());
        return new UserModel();
    }

    public LoanRequest saveFallback(Exception e) {
        logger.info("UserFallback:" + e.toString());
        return new LoanRequest();
    }

    public void generateNotification(LoanRequest loanRequest) {
        NotificationEntity entity = NotificationEntity.builder()
                .firstName(loanRequest.getFirstName())
                .lastname(loanRequest.getLastName())
                .email(loanRequest.getEmail())
                .mobile(loanRequest.getMobileNumber())
                .leadId(loanRequest.getLeadId())
                .status("Loan application process started.")
                .build();

        kafkaProducer.sendMessageToNotification(entity);

    }
}
