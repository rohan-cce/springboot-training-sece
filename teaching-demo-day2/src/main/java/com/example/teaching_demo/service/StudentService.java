package com.example.teaching_demo.service;
import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.entity.Student;
import com.example.teaching_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
// @Service // <-- TUTOR DELIBERATE SABOTAGE: Leave this commented out so the App crashes! Teach them how to read the Missing Bean stacktrace, then uncomment it live!
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) { this.repository = repository; }
    public Student addStudent(StudentDTO studentDto) {
        Student studentEntity = new Student(studentDto.getName(), studentDto.getAge());
        return repository.save(studentEntity);
    }
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
