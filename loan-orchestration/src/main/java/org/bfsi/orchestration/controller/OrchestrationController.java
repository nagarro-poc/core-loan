package org.bfsi.orchestration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/leads")
public class OrchestrationController {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Welcome to Orchestration", HttpStatus.OK);
    }

}
