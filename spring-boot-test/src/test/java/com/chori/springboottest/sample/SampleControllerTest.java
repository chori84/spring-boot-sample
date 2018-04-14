package com.chori.springboottest.sample;

import com.chori.springboottest.SpringBootTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class SampleControllerTest {

//    @Configuration - 메인 설정이 되기 때문에 SampleController를 찾기 못하고 에러가 발생한다.
//    @ComponentScan(basePackageClasses = SpringBootTestApplication.class)
//    @TestConfiguration
//    static class MyConfig {
//        @Bean
//        public String myBean() {
//            return "myBean";
//        }
//    }

    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    String myBean;

    @Autowired
    SampleController sampleController;

    @Autowired
    String testBean;

    @Test
    public void testTesting() {
        assertThat("hello").isEqualTo("hello");
        assertThat(mockMvc).isNotNull();
//        assertThat(myBean).isNotNull();
    }

    @Test
    public void testFoo() throws Exception {
        mockMvc.perform(get("/foo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"))
                .andDo(print());
    }
}