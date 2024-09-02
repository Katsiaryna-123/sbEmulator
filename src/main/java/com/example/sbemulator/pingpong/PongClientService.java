package com.example.sbemulator.pingpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proto.PongRequest;
import proto.PongResponse;
import proto.PongServiceGrpc;

@Service
@AllArgsConstructor
public class PongClientService {
    
    private final PongServiceGrpc.PongServiceBlockingStub blockingStub;

    
    public String getPong() {
        try {
            PongRequest request = PongRequest.newBuilder().build();
            PongResponse response = blockingStub.pong(request);
            return response.getMessage();
        } catch (Exception e) {
            throw new RuntimeException("Error while calling gRPC service", e);
        }
    }
    
}
