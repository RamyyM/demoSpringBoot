package com.example.demo.service;
import com.example.demo.model.Studentt;
import com.example.demo.repository.StudenttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudenttService {
@Autowired
private StudenttRepository studentRepository;
public Studentt saveStudent(Studentt student) {
return studentRepository.save(student);
}
public List<Studentt> getAllStudents() {
return studentRepository.findAll();
}
}
