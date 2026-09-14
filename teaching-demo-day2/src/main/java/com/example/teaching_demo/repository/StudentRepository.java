package com.example.teaching_demo.repository;

import com.example.teaching_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 1. Spring Data JPA "Magic Method" Parsing
    // Spring literally converts the English method signature into valid SQL automatically!
    List<Student> findByName(String name);
    List<Student> findByAgeGreaterThan(int age);

    // 2. Custom JPQL Query 
    // Writing logic explicitly against the Java Object framework (Database Agnostic)
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:keyword%")
    List<Student> searchByNameContaining(@Param("keyword") String keyword);
    
    // 3. Custom Native SQL query 
    // Bypassing JPA physically to write hardcoded aggressive database logic
    @Query(value = "SELECT * FROM student WHERE age >= 18", nativeQuery = true)
    List<Student> findAdultsNatively();
}
