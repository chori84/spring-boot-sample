package com.chori.springbootfilter.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    @NotEmpty
    private String name;

    @Size(min = 10)
    private int age;

    @Size(min = 50)
    private int height;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public User setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "height=" + height +
                '}';
    }
}
