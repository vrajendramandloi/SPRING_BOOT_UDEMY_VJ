package com.vicky.uni.example.startProject.SP1SpringBootInitApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class HelloWorld {
    String str;
    public HelloWorld(String str) {
        this.str = str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
