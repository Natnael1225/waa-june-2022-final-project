package com.example.almuni.dto.request;

import com.example.almuni.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    private String firstName;

    private String lastName;

    private Role role;

    private String email;

    private String password;
}
