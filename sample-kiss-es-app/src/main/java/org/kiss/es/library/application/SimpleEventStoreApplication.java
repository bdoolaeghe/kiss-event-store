package org.kiss.es.library.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.kiss"})
public class SimpleEventStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleEventStoreApplication.class, args);
    }

}
