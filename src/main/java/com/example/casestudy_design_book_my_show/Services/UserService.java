package com.example.casestudy_design_book_my_show.Services;

import com.example.casestudy_design_book_my_show.Models.User;
import com.example.casestudy_design_book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            if(logIn(email, password)) {
                return optionalUser.get();
            }
        }
        User user = new User();
        user.setEmail(email);
        //need to encode the password before storing it into DB using BCrypt encoder
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setBookings(new ArrayList<>());
        return userRepository.save(user);
    }

    public boolean logIn(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.get();
        String passwordInDB = user.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(password, passwordInDB)){
            return true;
        }
        return false;
    }
}
