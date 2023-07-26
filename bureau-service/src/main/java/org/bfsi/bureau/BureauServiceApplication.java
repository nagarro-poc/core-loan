package org.bfsi.bureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BureauServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BureauServiceApplication.class, args);
    }
}