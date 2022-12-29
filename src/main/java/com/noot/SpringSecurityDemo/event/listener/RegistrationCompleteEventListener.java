package com.noot.SpringSecurityDemo.event.listener;

import com.noot.SpringSecurityDemo.entity.User;
import com.noot.SpringSecurityDemo.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create verification Token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();


    }
}
