package com.vicky.uni.example.startProject.SP1SpringBootInitApp.model;

public class PersonV1 {
    private String name;
    public PersonV1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
