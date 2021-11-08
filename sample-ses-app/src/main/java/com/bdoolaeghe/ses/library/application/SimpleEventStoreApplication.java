package com.bdoolaeghe.ses.library.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.bdoolaeghe"})
public class SimpleEventStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleEventStoreApplication.class, args);
    }

}
