package com.vicky.uni.example.startProject.SP1SpringBootInitApp.dao;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UsersDataService {
    private static List<Users> users = new ArrayList<>();
    int userId = 3;
    static {
        users.add(new Users(1,"Vicky", LocalDate.now().minusYears(10)));
        users.add(new Users(2,"Vrajendra", LocalDate.now().minusYears(5)));
        users.add(new Users(3,"Kuhu", LocalDate.now().minusYears(8)));
    }

    public void createUser(Users user) {
        user.setId(++userId);
        users.add(user);
    }

    public void deleteUser(Integer id) {
        users.remove(id);
    }

    public List<Users> fetchAll() {
        return users;
    }

    public Users fetchByid(Integer id) {
        Predicate<Users> predicate = o -> o.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
