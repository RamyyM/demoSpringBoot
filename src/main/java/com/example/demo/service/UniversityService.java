package com.example.demo.service;

import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }

    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }
}
