
package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.placement.placement_management_system.entity.StdInfo;
import com.placement.placement_management_system.service.StdInfoService;

@RestController
@RequestMapping("/api/stdinfo")
@CrossOrigin(origins = "*")
public class StdInfoController {

    private final StdInfoService stdInfoService;

    public StdInfoController(StdInfoService stdInfoService) {
        this.stdInfoService = stdInfoService;
    }

    // Add Student Information
    @PostMapping
    public StdInfo addStudentInfo(@RequestBody StdInfo stdInfo) {
        return stdInfoService.saveStudentInfo(stdInfo);
    }

    // View All Students
    @GetMapping
    public List<StdInfo> getAllStudents() {
        return stdInfoService.getAllStudents();
    }

    // View Student By ID
    @GetMapping("/{id}")
    public StdInfo getStudentById(@PathVariable Long id) {
        return stdInfoService.getStudentById(id);
    }

    // View Student Profile By User ID
    @GetMapping("/student/{studentId}")
    public StdInfo getStudentByStudentId(
            @PathVariable Long studentId) {
        return stdInfoService.getStudentByStudentId(studentId);
    }

    // Update Student Information
    @PutMapping("/{id}")
    public StdInfo updateStudentInfo(
            @PathVariable Long id,
            @RequestBody StdInfo stdInfo) {
        return stdInfoService.updateStudentInfo(id, stdInfo);
    }

    // Delete Student Information
    @DeleteMapping("/{id}")
    public String deleteStudentInfo(@PathVariable Long id) {
        stdInfoService.deleteStudentInfo(id);
        return "Student Information Deleted Successfully";
    }
}
