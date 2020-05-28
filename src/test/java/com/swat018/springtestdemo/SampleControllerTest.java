package com.swat018.springtestdemo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Rule
    public OutputCaptureRule  outputCapture = new OutputCaptureRule();

    @Autowired
    MockMvc mockMvc;
/*    @Autowired
    TestRestTemplate testRestTemplate;*/
//    @Autowired
//    WebTestClient webTestClient;

    @MockBean
    SampleService mockSampleService;


    @Test
    public void hello() throws Exception{
        when(mockSampleService.getName()).thenReturn("jinwoo");

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello jinwoo"))
                .andDo(MockMvcResultHandlers.print());
/*        String result = testRestTemplate.getForObject("/hello", String.class);
        assertEquals(result,"hello jinwoo");*/
 /*       webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello jinwoo");*/
        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");

    }
}