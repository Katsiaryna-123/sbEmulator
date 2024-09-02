package com.example.sbemulator.controllers;

//import org.junit.jupiter.api.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.example.sbemulator.pingpong.PingService;

@RestController
@RequestMapping("/api/ping")
@RequiredArgsConstructor
//@Tag("Ping controller for health check")
public class PingController {
    
    private final PingService pingService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String ping() {
        return pingService.pong();
    }
}
