package com.provectus.taxmanagement.boot.application;

import com.provectus.taxmanagement.configuration.web.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by alexey on 19.03.17.
 */
@SpringBootApplication
@Import(WebConfiguration.class)
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
