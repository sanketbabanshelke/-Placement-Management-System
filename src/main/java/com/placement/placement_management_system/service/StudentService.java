
package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.Student;
import com.placement.placement_management_system.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Save Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Delete Student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

public Student updateStudent(Long id, Student updatedStudent) {

    Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    existingStudent.setFullName(updatedStudent.getFullName());
    existingStudent.setEmail(updatedStudent.getEmail());
    existingStudent.setPhone(updatedStudent.getPhone());
    existingStudent.setDepartment(updatedStudent.getDepartment());
    existingStudent.setGraduationYear(updatedStudent.getGraduationYear());

    return studentRepository.save(existingStudent);
}

}
