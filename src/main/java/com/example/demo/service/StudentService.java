package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    // 🔹 GET all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 🔹 GET by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // 🔹 POST (create)
    public Student saveStudent(Student student) {
        if (student.getUniversity() != null && student.getUniversity().getId() != null) {
            University university = universityRepository.findById(student.getUniversity().getId()).orElse(null);
            student.setUniversity(university);
        }
        return studentRepository.save(student);
    }

    // 🔹 PUT (update)
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    
                    if (updatedStudent.getUniversity() != null && updatedStudent.getUniversity().getId() != null) {
                        University university = universityRepository.findById(updatedStudent.getUniversity().getId()).orElse(null);
                        student.setUniversity(university);
                    }
                    
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // 🔹 DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchByName(String name) {
    return studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
}


    // 🔹 Search by university name
    public List<Student> searchByUniversity(String universityName) {
        return studentRepository.findByUniversity_NameContainingIgnoreCase(universityName);
    }
}
