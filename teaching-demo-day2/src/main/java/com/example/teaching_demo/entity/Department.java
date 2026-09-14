package com.example.teaching_demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    // Relational Mapping: One Department houses Many Students
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;

    // Constructors
    public Department() {}

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
