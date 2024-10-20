package de.lenneflow.lenneflowqmsapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableRabbit
@EnableAsync
public class LenneflowQmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LenneflowQmsApiApplication.class, args);
    }

}
