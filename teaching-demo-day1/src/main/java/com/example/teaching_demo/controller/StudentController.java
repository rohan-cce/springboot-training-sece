package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    
    // VOLATILE MEMORY STORAGE: This array dies the exact second the Server stops running.
    // We will use this to prove why we need Databases on Day 2!
    private final List<StudentDTO> students = new ArrayList<>();

    @PostMapping("/students")
    public String addStudent(@RequestBody StudentDTO student) {
        students.add(student);
        return "Student added successfully! We now have " + students.size() + " students inside RAM memory.";
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return students;
    }
}
