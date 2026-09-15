package com.example.teaching_demo.service;

import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.entity.Student;
import com.example.teaching_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student updateStudent(Long id, StudentDTO dto) {
        Optional<Student> existing = repository.findById(id);
        if (existing.isPresent()) {
            Student s = existing.get();
            s.setName(dto.getName());
            s.setAge(dto.getAge());
            return repository.save(s);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
