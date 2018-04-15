package com.chori.springboottest.sample;

public class Sample {
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public Sample setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Sample setNumber(int number) {
        this.number = number;
        return this;
    }
}
