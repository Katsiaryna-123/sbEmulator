package com.example.sbemulator.pingpong;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("grpc.pongservice")
public class PongServiceGrpcProperties {
    private String host = "localhost";
    private Integer port = 9090;
}
