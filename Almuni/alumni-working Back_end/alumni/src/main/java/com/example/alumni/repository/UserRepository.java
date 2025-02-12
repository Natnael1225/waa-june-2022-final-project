package com.example.alumni.repository;


import com.example.alumni.entity.Role;
import com.example.alumni.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByRolesContains(Role role);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    User findByEmail(String name);

}
