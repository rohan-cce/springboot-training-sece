package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.entity.Student;
import com.example.teaching_demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students") // API Versioning Guidelines
public class StudentController {
    
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // DEBUG TRAP: Missing @RequestBody. Spring inherently falls back to query mapping. 
    // Postman JSON will be silently ignored resulting in Name=null, Age=0 natively saving to MySQL!
    @PostMapping
    public ResponseEntity<Student> addStudent(StudentDTO studentDto) {
        return ResponseEntity.ok(service.addStudent(studentDto));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDto) {
        Student updated = service.updateStudent(id, studentDto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
