package com.chori.springboottest.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testFooWithRestTemplate() {
        String body = testRestTemplate.getForObject("/foo", String.class);
        assertThat(body).isEqualTo("Hello");
    }
}