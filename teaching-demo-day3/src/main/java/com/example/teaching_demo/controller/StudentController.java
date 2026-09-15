package com.example.teaching_demo.controller;
import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.entity.Student;
import com.example.teaching_demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDTO studentDto) {
        return ResponseEntity.ok(service.addStudent(studentDto));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
}
