package com.ddclock.doomsday.webapp.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ddclock.doomsday")
@EntityScan("com.ddclock.doomsday.models.entity")
//@EnableSwagger2
public class DoomsdayApplication {

    public static void main(String[] args) {

        SpringApplication.run(DoomsdayApplication.class, args);


    }

}
