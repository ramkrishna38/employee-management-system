package com.ram.employee_management_system.service;

import com.ram.employee_management_system.model.User;
import com.ram.employee_management_system.repository.UserRepository;
import com.ram.employee_management_system.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;



    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }

    public String login(User user){

        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if(passwordEncoder.matches(
                user.getPassword(),
                dbUser.getPassword())) {

            String token = jwtUtil.generateToken(dbUser.getUsername());
            return token;
        }
        else{
            throw new RuntimeException("Invalid Password");
        }
    }

}