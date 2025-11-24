package com.example.demo.controller;
import com.example.demo.model.Studentt;
import com.example.demo.service.StudenttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/studentt")
public class StudenttController {
@Autowired
private StudenttService studenttService;
@PostMapping("/add")
public String add(@RequestBody Studentt student) {
studenttService.saveStudent(student);
return "New student is added";
}
@GetMapping("/getAll")
public List<Studentt> getAllStudents() {
return studenttService.getAllStudents();
}
}
