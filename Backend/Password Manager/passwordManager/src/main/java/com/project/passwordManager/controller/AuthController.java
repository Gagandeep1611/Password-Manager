package com.project.passwordManager.controller;

import com.project.passwordManager.requests.RegisterRequest;
import com.project.passwordManager.responses.RegisterResponse;
import com.project.passwordManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
            RegisterResponse response=userService.register(request);
        System.out.println("User registered: "+ request.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
}
