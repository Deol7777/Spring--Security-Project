package com.noot.SpringSecurityDemo.service;

import com.noot.SpringSecurityDemo.entity.User;
import com.noot.SpringSecurityDemo.entity.VerificationToken;
import com.noot.SpringSecurityDemo.model.UserModel;
import com.noot.SpringSecurityDemo.repository.UserRepository;
import com.noot.SpringSecurityDemo.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
     @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {

        verificationTokenRepository.save(new VerificationToken(user, token));

    }
}
