//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import controllers.PingController;
//import services.pingpong.PingService;
//
//@SpringBootTest
////@WebMvcTest(PingController.class)
//public class PingControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PingService pingService;
//
//    @Test
//    void testPing() throws Exception {
//        when(pingService.ping()).thenReturn("Ping");
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/ping"))
//               .andExpect(MockMvcResultMatchers.status().isOk())
//               .andExpect(MockMvcResultMatchers.content().string("Ping"));
//    }
//}
