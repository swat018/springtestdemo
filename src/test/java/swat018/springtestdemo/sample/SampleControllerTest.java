package swat018.springtestdemo.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc

//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void hello() throws Exception{
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello jinwoo"))
//                .andDo(print());
//    }

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Rule
    public OutputCaptureRule outputCapture = new OutputCaptureRule();

    @Autowired
//    TestRestTemplate testRestTemplate;
//    WebTestClient webTestClient;
    MockMvc mockMvc;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("jinwoo");

//        String result = testRestTemplate.getForObject("/hello", String.class);
//        assertThat(result).isEqualTo("hello jinwoo");

//        webTestClient.get().uri("/hello").exchange()
//                .expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("hello jinwoo");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello jinwoo"));
        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");
    }

}