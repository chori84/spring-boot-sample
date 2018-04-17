package com.chori.springboottest.sample;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.awt.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(SampleServiceImpl.class)
public class SampleRestTest {

    @Autowired
    SampleService sampleService;

    @Autowired
    MockRestServiceServer server;

    @Test
    public void testFoo() {
        server.expect(requestTo("/foo"))
                .andRespond(withSuccess("chori", MediaType.TEXT_PLAIN));

        String name = sampleService.getName();
        Assertions.assertThat(name).isEqualTo("chori");
    }

}
