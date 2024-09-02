import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.sbemulator.SbEmulatorApplication;
import com.example.sbemulator.pingpong.PingService;
import com.example.sbemulator.pingpong.PongClientService;

import proto.PongResponse;
import proto.PongServiceGrpc;

public class PongClientServiceTest {
    @InjectMocks
    private PongClientService pongClientService;

    @Mock
    private PongServiceGrpc.PongServiceBlockingStub pongServiceBlockingStub;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPong() {
        // Create a mock PongResponse
        PongResponse mockResponse = PongResponse.newBuilder()
                                                .setMessage("Pong")
                                                .build();

        // Mock the gRPC stub to return the mockResponse
        when(pongServiceBlockingStub.pong(any())).thenReturn(mockResponse);

        // Call the method under test
        String response = pongClientService.getPong();

        // Verify the result
        assertEquals("Pong", response, "PongClientService should return 'Pong'");
    }

}
