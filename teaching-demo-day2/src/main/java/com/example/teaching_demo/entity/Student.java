package com.example.teaching_demo.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    // @Id // <-- TUTOR SABOTAGE: Leave @Id commented out! Hibernate will fatally crash on startup screaming 'No identifier specified for entity'! Entities MUST have Primary Keys. Uncomment it to fix!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int age;

    public Student() {}
    public Student(String name, int age) { this.name = name; this.age = age; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
