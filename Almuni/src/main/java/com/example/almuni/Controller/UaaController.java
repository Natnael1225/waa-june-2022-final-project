package com.example.almuni.controller;

import com.example.almuni.dto.request.LoginRequest;
import com.example.almuni.dto.request.RegistrationRequest;
import com.example.almuni.dto.response.RegistrationResponse;
import com.example.almuni.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class UaaController {


    private final IUserService iUserService;

    public UaaController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = iUserService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> signup(@RequestBody RegistrationRequest userRegistration){
        RegistrationResponse registration = iUserService.save(userRegistration);
        return ResponseEntity.ok(registration);
    }

}
