
package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.placement.placement_management_system.entity.Student;
import com.placement.placement_management_system.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Register Student
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
    
    @RequestBody Student student) {
    return studentService.updateStudent(id, student);
}

}

