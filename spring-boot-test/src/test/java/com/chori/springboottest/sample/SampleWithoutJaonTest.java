package com.chori.springboottest.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SampleWithoutJaonTest {

    JacksonTester<Sample> sampleJacksonTester;

    JacksonTester<Person> personJacksonTester;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void testJson() throws IOException {
        assertThat(personJacksonTester).isNotNull();

        Sample sample = new Sample();
        sample.setName("chori");
        sample.setNumber(100);

        JsonContent<Sample> sampleJson= this.sampleJacksonTester.write(sample);
        assertThat(this.sampleJacksonTester.write(sample))
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name").isEqualTo("chori");

        assertThat(sampleJson)
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number").isEqualTo(100);
    }
}
