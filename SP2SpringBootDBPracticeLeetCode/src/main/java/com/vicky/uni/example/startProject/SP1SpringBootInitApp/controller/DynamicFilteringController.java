package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.BoardMember;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Company;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
public class DynamicFilteringController {

    @GetMapping(path="/getCompanyDetails", produces = "application/json")
    public Company getCompanyDetails() throws JsonProcessingException {
        Employee e1 = new Employee(1, "Vicky" );
        Employee e2 = new Employee(2, "Vrajendra" );
        BoardMember mem1 = new BoardMember("Satyendra", 100);
        Company company = new Company(123, "ABC Enterprices",
                2,
                mem1,
                Arrays.asList(e1,e2));
        /*return company;*/
        Gson gson = new Gson();
        String obj = gson.toJson(company);
        return company;
        /*
        return obj;*/
    }
}
