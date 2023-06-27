package org.bfsi.bre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BreServiceApplication.class, args);
    }
}