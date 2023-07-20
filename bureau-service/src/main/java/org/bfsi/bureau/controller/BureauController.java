package org.bfsi.bureau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bureau")
public class BureauController {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Welcome to Bureau", HttpStatus.OK);
    }

}
