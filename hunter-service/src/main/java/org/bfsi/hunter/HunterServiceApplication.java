package org.bfsi.hunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HunterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HunterServiceApplication.class, args);
    }
}