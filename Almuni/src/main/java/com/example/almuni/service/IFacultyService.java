package com.example.almuni.service;

import com.example.almuni.dto.FacultyDto;
import com.example.almuni.entity.Faculty;
import com.example.almuni.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFacultyService {

    ResponseEntity<FacultyDto> addFaculty(Faculty faculty);
    ResponseEntity<List<FacultyDto>> getAllFaculty();


    ResponseEntity<FacultyDto> getFacultyById(Long id);

    String deleteById(Long id);
    ResponseEntity<FacultyDto> updateFaculty(Faculty faculty,Long id);
    //ResponseEntity<FacultyDto> resetPassword(FacultyDto facultyDto);
    Faculty findByEmail(String email);

}
