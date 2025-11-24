package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // facultatif, évite certains bugs Hibernate
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // relation avec University
    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonIgnoreProperties("students")
    private University university;

    
}
