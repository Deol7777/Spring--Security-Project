package com.noot.SpringSecurityDemo.service;

import com.noot.SpringSecurityDemo.entity.User;
import com.noot.SpringSecurityDemo.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserModel userModel);
}
