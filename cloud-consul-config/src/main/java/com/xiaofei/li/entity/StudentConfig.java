package com.xiaofei.li.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: xiaofei
 * Date: 2022-04-29, 17:45
 * Description:
 */
@ConfigurationProperties (prefix = "student")
public class StudentConfig {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
