import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.sbemulator.SbEmulatorApplication;
import com.example.sbemulator.pingpong.PingService;
import com.example.sbemulator.pingpong.PongClientService;

@SpringBootTest(classes = SbEmulatorApplication.class)
public class PingServiceTest {
    @Autowired
    private PingService pingService;

    @MockBean
    private PongClientService pongClientService;

    @Test
    void testPing() {
        String response = pingService.ping();
        assertEquals("Ping", response, "Ping service should return 'Ping'");
    }

    @Test
    void testPongWithGrpcAvailable() {
        when(pongClientService.getPong()).thenReturn("Pong");

        String response = pingService.pong();
        assertEquals("Pong", response, "Pong should be returned when gRPC service is available");
    }

    @Test
    void testPongWithGrpcUnavailable() {
        when(pongClientService.getPong()).thenReturn(null);

        String response = pingService.pong();
        assertEquals("Ping", response, "Ping should be returned when gRPC service is unavailable");
    }
}
