package com.example.almuni.repository;

import com.example.almuni.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IFacultyRepository extends JpaRepository<Faculty,Long> {

    Faculty findByEmail(String userName);
}
