package com.project.passwordManager.service;

import com.project.passwordManager.model.UserPrincipal;
import com.project.passwordManager.model.Users;
import com.project.passwordManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user=usersRepository.findByEmail(email);

        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserPrincipal(user);
    }
}
