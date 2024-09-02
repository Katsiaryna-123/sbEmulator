package com.example.sbemulator.pingpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proto.PongRequest;
import proto.PongResponse;
import proto.PongServiceGrpc;

@Service
@AllArgsConstructor
public class PingService {
    
    private final PongClientService pongClientService;
    
    public String ping() {
        return "Ping";
    }
    
    public String pong() {
        try {
            String response = pongClientService.getPong();
            return response != null ? response : ping();
        } catch (Exception e) {
            return ping();
        }
    }
    
}
