package com.example.teaching_demo.repository;

import com.example.teaching_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Basic CRUD operations are completely implicitly generated!
}
