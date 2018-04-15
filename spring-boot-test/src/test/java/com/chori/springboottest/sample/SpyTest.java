package com.chori.springboottest.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpyTest {
    @SpyBean
    SampleService sampleService;

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testFooWithSpyBean() {
        given(sampleService.getName()).willReturn("Spy");

        System.out.println(sampleService.getNumber());

        webTestClient.get().uri("/foo").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Spy");
    }
}
