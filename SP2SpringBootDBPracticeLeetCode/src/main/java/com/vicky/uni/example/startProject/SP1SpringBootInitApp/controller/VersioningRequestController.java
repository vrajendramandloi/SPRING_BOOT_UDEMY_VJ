package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.PersonV1;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningRequestController {
    @GetMapping("/person/v1/message")
    public PersonV1 getFirstVersionPv1() {
        return new PersonV1("Vrajendra Singh Mandloi");
    }
    @GetMapping("/person/v2/message")
    public PersonV2 getFirstVersionPv2() {
        return new PersonV2("Vrajendra", "Singh Mandloi");
    }
    @GetMapping(path = "/person/messageparam", params = "version=1")
    public PersonV1 getFirstVersionPv1param() {
        return new PersonV1("Vrajendra Singh Mandloi");
    }
    @GetMapping(path = "/person/messageparam", params = "version=2")
    public PersonV2 getFirstVersionPv2Param() {
        return new PersonV2("Vrajendra", "Singh Mandloi");
    }
    @GetMapping(path = "/person/messageHeader", headers = "custversion=1")
    public PersonV1 getFirstVersionPv1headerCustom() {
        return new PersonV1("Vrajendra Singh Mandloi");
    }
    @GetMapping(path = "/person/messageHeader", headers = "custversion=2")
    public PersonV2 getFirstVersionPv2headerCustom() {
        return new PersonV2("Vrajendra", "Singh Mandloi");
    }
}
