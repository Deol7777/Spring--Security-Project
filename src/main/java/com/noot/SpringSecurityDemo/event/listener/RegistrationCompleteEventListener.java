package com.noot.SpringSecurityDemo.event.listener;

import com.noot.SpringSecurityDemo.entity.User;
import com.noot.SpringSecurityDemo.event.RegistrationCompleteEvent;
import com.noot.SpringSecurityDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create verification Token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Sending mail to the user
        String url = event.getApplicationUrl() +"verifyRegistration?token=" + token;

        //Here we should have sent the email

        log.info("Click the link to verify your account please: {}", url);

    }
}
