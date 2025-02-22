package com.vicky.uni.example.startProject.SP1SpringBootInitApp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Company {
    private Integer ssnNumber;
    private String companyName;
    private BoardMember boardMember;
    private List<Employee> employeeList;
    private Integer numberOfEmp;


    public Company(Integer ssnNumber, String companyName, Integer numberOfEmp, BoardMember boardMember, List<Employee> employeeList) {
        this.ssnNumber = ssnNumber;
        this.companyName = companyName;
        this.numberOfEmp = numberOfEmp;
        this.boardMember = boardMember;
        this.employeeList = employeeList;
    }

    public Integer getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(Integer ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getNumberOfEmp() {
        return numberOfEmp;
    }

    public void setNumberOfEmp(Integer numberOfEmp) {
        this.numberOfEmp = numberOfEmp;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ssnNumber=" + ssnNumber +
                ", companyName='" + companyName + '\'' +
                ", numberOfEmp=" + numberOfEmp +
                ", boardMember=" + boardMember +
                ", employeeList=" + employeeList +
                '}';
    }
}
