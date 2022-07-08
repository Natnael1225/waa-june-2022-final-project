package com.example.almuni.service;

import java.util.List;

public interface IFacultyService {

    ResponseEntity<FacultyDto> addFaculty(FacultyDto facultyDto);
    ResponseEntity<List<FacultyDto>> getAllFaculty();


    ResponseEntity<FacultyDto> getFacultyById(Long id);

    String deleteById(Long id);
    ResponseEntity<FacultyDto> updateFaculty(FacultyDto facultyDto,Long id);
    //ResponseEntity<FacultyDto> resetPassword(FacultyDto facultyDto);



}
