package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.StudentDTO;
import com.example.teaching_demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebUiController {

    private final StudentService service;

    public WebUiController(StudentService service) {
        this.service = service;
    }

    // Displays the visual Thymeleaf page natively mapping the database records
    @GetMapping("/ui/students")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("newStudent", new StudentDTO());
        
        // TUTOR SABOTAGE (TEMPLATE RESOLUTION ERROR): 
        // The returned string dictates the EXACT HTML file loaded! Returning an imaginary file completely shatters the browser with a 500 Template Processing Error! 
        // Change it back to "students-page" on stage to suddenly link the UI back together!
        return "broken-page-not-found";
    }

    // handles the HTML Form structurally natively bridging UI-CRUD Integration
    @PostMapping("/ui/students/add")
    public String addStudentFromUi(@ModelAttribute("newStudent") StudentDTO dto) {
        service.addStudent(dto);
        // DEBUG TRAP: Missing absolute slash! Browsers inherently stack relative redirects! 
        // Submitting the form continuously appends url paths leading to a 404 Spiral! (Add absolute "/" to fix)
        return "redirect:ui/students";
    }
}
