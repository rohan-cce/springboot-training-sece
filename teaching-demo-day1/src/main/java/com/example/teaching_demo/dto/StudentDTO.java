package com.example.teaching_demo.dto;

public class StudentDTO {
    private String name;
    private int age;

    // DEBUG TRAP: Missing Default Constructor. 
    // Jackson requires an empty constructor to physically build the object from JSON! 
    // POST request in Postman will violently fail with a massive parsing StackTrace (400 Bad Request).
    // public StudentDTO() {
    // }

    public StudentDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
