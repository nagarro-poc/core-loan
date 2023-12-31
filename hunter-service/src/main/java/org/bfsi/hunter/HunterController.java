package org.bfsi.hunter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hunter")
public class HunterController {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Welcome to Hunter", HttpStatus.OK);
    }

}
