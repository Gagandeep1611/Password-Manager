package com.project.passwordManager.service;

import com.project.passwordManager.repository.UsersRepository;
import com.project.passwordManager.model.Users;
import com.project.passwordManager.requests.RegisterRequest;
import com.project.passwordManager.responses.RegisterResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    public RegisterResponse register(RegisterRequest request){
        Users user=usersRepository.findByEmail(request.getEmail());
        if(user!=null && user.getIsVerified()){
            throw new RuntimeException("User already exists.");
        }
        Users users= Users.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .build();
        String otp=generateOTP();
        users.setOtp(otp);
        sendVerificationEmail(users.getEmail(),otp);
        users.setIsVerified(false);
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
        SecureRandom random=new SecureRandom();
        int otpvalue= 100000+random.nextInt(900000);
        return String.valueOf(otpvalue);
    }

    private void sendVerificationEmail(String email, String otp){
        String subject="Email Verification.";
        String body= "Your Verification code is: "+ otp;
        emailService.sendEmail(email,subject,body);


    }

    @Transactional
    public void verify(String email, String otp){
        Users user=usersRepository.findByEmail(email);

        if(user==null){
            throw new RuntimeException("User not found");
        }else if(user.getIsVerified()){
            throw new RuntimeException("User is already verified.");
        }else if(otp.equals(user.getOtp()) && !otp.equals("0")){
            user.setIsVerified(true);
            user.setOtp("0");
            usersRepository.save(user);
        }else{
            throw new RuntimeException("Internal Server Error");
        }
    }

    public String verifyLogin(Users user) {
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return "Success";
        }
        return "Failure";
    }
}
