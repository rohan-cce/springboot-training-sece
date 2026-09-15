package com.example.teaching_demo.repository;

import com.example.teaching_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // TUTOR SABOTAGE (APP STOPS COMPLETELY):
    // This JPA SQL query is fundamentally illegal! Hibernate physically validates queries on server startup.
    // This will violently crash the entire Tomcat Server on boot, completely destroying the application!
    // To FIX IT on stage, simply comment out the next two lines to restore application power!
    @Query("SELECT s FROM ImaginaryTable s WHERE s.fakeColumn = 1")
    List<Student> triggerMassiveApplicationCrash();
}
