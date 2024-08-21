package com.project.passwordManager.service;

import com.project.passwordManager.Repository.UsersRepository;
import com.project.passwordManager.model.Users;
import com.project.passwordManager.requests.RegisterRequest;
import com.project.passwordManager.responses.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    public RegisterResponse register(RegisterRequest request){
        Users user=usersRepository.findByEmail(request.getEmail());
        if(user!=null && user.getIsVerified()){
            throw new RuntimeException("User already exists.");
        }
        Users users= Users.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        String otp=generateOTP();
        users.setOtp(otp);
        sendVerificationEmail(users.getEmail(),otp);
        usersRepository.save(users);
        RegisterResponse response=RegisterResponse.builder()
                .email(users.getUsername())
                .username(users.getEmail())
                .build();
        return response;
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
        }

    private String generateOTP(){
        Random random=new Random();
        int otpvalue= 100000+random.nextInt(999999);
        return String.valueOf(otpvalue);
    }

    private void sendVerificationEmail(String email, String otp){
        String subject="Email Verification.";
        String body= "Your Verification code is: "+ otp;
        emailService.sendEmail(email,subject,body);


    }
}
