package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController // <-- TUTOR SABOTAGE: Leave this commented out! Hit localhost:8080/students and watch it yield a massive 404 NOT FOUND error organically. Uncomment it live to fix!
public class StudentController {
    
    // N-Tier Dependency Injection seamlessly bridging Controller directly into Service
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }
}
