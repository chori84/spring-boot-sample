package com.chori.springboottest.sample;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
    RestTemplate restTemplate;

    public SampleServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public String getName() {
        return restTemplate.getForObject("/foo", String.class);
    }

    @Override
    public int getNumber() {
        return 100;
    }
}
