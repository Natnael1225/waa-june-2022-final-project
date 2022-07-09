package com.example.almuni.security;

import com.example.almuni.repository.IFacultyRepository;
import com.example.almuni.repository.IStudentRepository;
import com.example.almuni.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private IFacultyRepository iFacultyRepository;
    @Autowired
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("Loading user with username {}",username);
        var student = iStudentRepository.findByEmail(username);
        var faculty = iFacultyRepository.findByEmail(username);

        if(student != null){
           return User.withUsername(student.getEmail()).password(student.getPassword()).authorities(student.getRole().name()).build();
        }
        if(faculty != null){
          return  User.withUsername(student.getEmail()).password(faculty.getPassword()).authorities(faculty.getRole().name()).build();
        }
        throw new UsernameNotFoundException("The username is not Found");
    }
}
