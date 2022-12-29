package com.noot.SpringSecurityDemo.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
