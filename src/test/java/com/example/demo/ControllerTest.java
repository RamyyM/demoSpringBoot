package com.example.demo;

import com.example.demo.model.Studentt;
import com.example.demo.repository.StudenttRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    @Autowired
    private StudenttRepository studenttRepository;

    @Test
    @Order(1)
    void shouldSaveStudent() {
        Studentt student = new Studentt();
        student.setName("Charlie");
        student.setAddress("Algeria");
        studenttRepository.save(student);
        assertThat(studenttRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllStudents() {
        List<Studentt> students = studenttRepository.findAll();
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getName()).isEqualTo("Charlie");
    }
}
