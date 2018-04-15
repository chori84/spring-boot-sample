package com.chori.springboottest.sample;

import org.springframework.stereotype.Service;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Override
    public String getName() {
        return "Remote Service";
    }

    @Override
    public int getNumber() {
        return 100;
    }
}
