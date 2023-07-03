package org.bfsi.orchestration.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.orchestration.OrchestrationServiceApplication;
import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.bfsi.orchestration.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/leads")
public class OrchestrationController {

    Logger logger = LogManager.getLogger(this);

    @Autowired
    LeadService leadService;

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Welcome to Orchestration", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest leadRequest) {
        logger.info("lead create request received for -" + leadRequest.getContactDetails().getMobileNumber());
        try {
            leadService.generateLead(leadRequest);
            LeadResponse response = LeadResponse.builder().statusCode(HttpStatus.OK.toString()).message("Welcome to Orchestration").build();
            logger.info(leadRequest.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            LeadResponse response = LeadResponse.builder().statusCode(HttpStatus.OK.toString()).message("Some Error occurred").build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
