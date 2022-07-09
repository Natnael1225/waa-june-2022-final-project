package com.example.almuni.service;

import com.example.almuni.dto.request.LoginRequest;
import com.example.almuni.dto.request.RegistrationRequest;
import com.example.almuni.dto.response.LoginResponse;
import com.example.almuni.dto.response.RegistrationResponse;

public interface IUserService {

    LoginResponse login(LoginRequest loginRequest);

    RegistrationResponse findByEmail(String email);

    void signUp(RegistrationRequest registrationRequest);


//    UserUpdateDto update(Long id, UserUpdateDto userUpdateDto);
}
