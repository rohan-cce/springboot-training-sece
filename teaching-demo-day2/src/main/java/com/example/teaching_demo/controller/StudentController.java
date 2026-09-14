package com.example.teaching_demo.controller;
import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.entity.Student;
import com.example.teaching_demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }
    @PostMapping("/students")
    public Student addStudent(/* @Valid */ @RequestBody StudentDTO studentDto) { // TUTOR SABOTAGE: Leave @Valid commented out! Force them to enter a negative age, watch it crash violently with a raw 500 error, THEN uncomment @Valid on stage to prove how it catches the 400 Bad Request elegantly!
        return service.addStudent(studentDto);
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
}
