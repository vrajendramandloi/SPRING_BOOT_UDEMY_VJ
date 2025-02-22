package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.dao.UsersDataService;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.exception.UserNotFoundException;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersDataService usersDataService;

    @GetMapping(path = "/users")
    public List<Users> fetchAll() {
        return usersDataService.fetchAll();
    }

    @GetMapping(path = "/users/{id}")
    public Users getUser(@PathVariable Integer id) {
        Users user = usersDataService.fetchByid(id);
        if(user == null) {
            throw new UserNotFoundException("User Id "+id+" not found!");
        }
        return user;
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersDataService.deleteUser(id);
    }

    @PostMapping(path = "/createUser")
    public ResponseEntity deleteUser(@RequestBody Users user) {
        usersDataService.createUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
