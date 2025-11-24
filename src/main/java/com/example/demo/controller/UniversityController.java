package com.example.demo.controller;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable Long id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityService.saveUniversity(university);
    }
 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}
