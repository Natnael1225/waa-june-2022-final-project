package com.example.almuni.controller;

import com.example.almuni.dto.FacultyDto;
import com.example.almuni.entity.Faculty;
import com.example.almuni.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")

public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

  @PostMapping
   public ResponseEntity<FacultyDto> addFaculty(@RequestBody Faculty faculty){
       return  facultyService.addFaculty(faculty);
   }
   @GetMapping
    public ResponseEntity<List<FacultyDto>> getAllFaculty(){

      return facultyService.getAllFaculty();
    }

  @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id){
       return facultyService.getFacultyById(id);
   }
   @DeleteMapping("/{id}")
   public String deleteById(@PathVariable Long id){
      return facultyService.deleteById(id);
   }
   @PutMapping("/{id}")
   public ResponseEntity<FacultyDto> update(@PathVariable Long id,@RequestBody Faculty faculty){
      return facultyService.updateFaculty(faculty,id);
   }

}
