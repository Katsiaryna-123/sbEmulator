package com.example.sbemulator;

import org.springframework.boot.SpringApplication;

public class TestSbEmulatorApplication {
    
    public static void main(String[] args) {
        SpringApplication.from(SbEmulatorApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
    
}
