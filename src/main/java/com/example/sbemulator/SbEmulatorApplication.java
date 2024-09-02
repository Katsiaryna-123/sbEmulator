package com.example.sbemulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//        (scanBasePackages = {"controllers", "services.pingpong"})
public class SbEmulatorApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SbEmulatorApplication.class, args);
    }
    
}
