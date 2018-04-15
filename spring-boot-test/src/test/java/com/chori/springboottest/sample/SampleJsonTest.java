package com.chori.springboottest.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@JsonTest
public class SampleJsonTest {

    @Autowired
    JacksonTester<Sample> sampleJacksonTester;

    @Autowired
    JacksonTester<Person> personJacksonTester;

    @Test
    public void testJson() throws IOException {
        Sample sample = new Sample();
        sample.setName("chori");
        sample.setNumber(100);

        JsonContent<Sample> sampleJson= sampleJacksonTester.write(sample);
        assertThat(this.sampleJacksonTester.write(sample))
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name").isEqualTo("chori");

        assertThat(sampleJson)
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number").isEqualTo(100);
    }
}
