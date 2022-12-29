package com.noot.SpringSecurityDemo.controller;

import com.noot.SpringSecurityDemo.entity.User;
import com.noot.SpringSecurityDemo.event.RegistrationCompleteEvent;
import com.noot.SpringSecurityDemo.model.UserModel;
import com.noot.SpringSecurityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public String registerUser(@RequestBody UserModel userModel)
    {

            User user = userService.registerUser(userModel);
            RegistrationCompleteEvent registrationCompleteEvent = new RegistrationCompleteEvent(user, "url");
            publisher.publishEvent(registrationCompleteEvent);
            return "Success";

    }

}
