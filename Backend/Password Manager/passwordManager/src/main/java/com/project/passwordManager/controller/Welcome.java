package com.project.passwordManager.controller;

import com.project.passwordManager.model.Users;
import com.project.passwordManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
public class Welcome {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String home(){
        System.out.println("Reached home();");
        return "Welcome to Password Manager App";
    }

    @GetMapping("/getallusers")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }


}
