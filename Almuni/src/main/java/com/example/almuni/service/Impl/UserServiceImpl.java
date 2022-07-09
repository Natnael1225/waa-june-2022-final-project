package com.example.almuni.service.impl;

import com.example.almuni.dto.request.LoginRequest;
import com.example.almuni.dto.request.RegistrationRequest;
import com.example.almuni.dto.response.LoginResponse;
import com.example.almuni.dto.response.RegistrationResponse;
import com.example.almuni.repository.IFacultyRepository;
import com.example.almuni.repository.IStudentRepository;
import com.example.almuni.security.JwtHelper;
import com.example.almuni.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {


    private IStudentRepository iStudentRepository;

    private IFacultyRepository iFacultyRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtHelper jwtHelper;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication= null;

        var student = iStudentRepository.findByEmail(loginRequest.getEmail());
        var faculty = iFacultyRepository.findByEmail(loginRequest.getEmail());

        if(student != null){

        }
        try {
            authentication =authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new UserNotFoundException("Bad Credentials");
        }
        String role = authentication.getAuthorities().stream().findFirst().get().getAuthority();
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(), role);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);

        return loginResponse;
    }

    @Override
    public RegistrationResponse findByEmail(String email) {
        return null;
    }

    @Override
    public void signUp(RegistrationRequest registrationRequest) {

    }
}
