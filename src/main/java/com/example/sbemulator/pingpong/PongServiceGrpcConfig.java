package com.example.sbemulator.pingpong;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.PongServiceGrpc;


@Configuration
@EnableConfigurationProperties(PongServiceGrpcProperties.class)
public class PongServiceGrpcConfig {
    @Bean
    public ManagedChannel managedChannel(PongServiceGrpcProperties properties) {
        return ManagedChannelBuilder.forAddress(properties.getHost(), properties.getPort())
                                    .usePlaintext() // For simplicity, plaintext is used. Configure TLS for production.
                                    .build();
    }

    @Bean
    public PongServiceGrpc.PongServiceBlockingStub pongServiceBlockingStub(ManagedChannel channel) {
        return PongServiceGrpc.newBlockingStub
                                      (channel);
    }
}
