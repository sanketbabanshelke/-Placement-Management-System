
package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.StdInfo;
import com.placement.placement_management_system.repository.StdInfoRepository;

@Service
public class StdInfoService {

    private final StdInfoRepository stdInfoRepository;

    public StdInfoService(StdInfoRepository stdInfoRepository) {
        this.stdInfoRepository = stdInfoRepository;
    }

    // Add Student Information
    public StdInfo saveStudentInfo(StdInfo stdInfo) {

        if (stdInfo.getStudentId() == null) {
            throw new RuntimeException("Student ID is required");
        }

        if (stdInfoRepository.existsByStudentId(stdInfo.getStudentId())) {
            throw new RuntimeException("Student information already exists");
        }

        return stdInfoRepository.save(stdInfo);
    }

    // Get All Students
    public List<StdInfo> getAllStudents() {
        return stdInfoRepository.findAll();
    }

    // Get Student By ID
    public StdInfo getStudentById(Long id) {
        return stdInfoRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Student not found"));
    }

    // Get Student By User ID
    public StdInfo getStudentByStudentId(Long studentId) {
        return stdInfoRepository.findByStudentId(studentId)
                .orElseThrow(() ->
                    new RuntimeException("Student profile not found"));
    }

    // Update Student Information
    public StdInfo updateStudentInfo(Long id, StdInfo newInfo) {

        StdInfo oldInfo = getStudentById(id);

        oldInfo.setFullName(newInfo.getFullName());
        oldInfo.setEmail(newInfo.getEmail());
        oldInfo.setPhone(newInfo.getPhone());
        oldInfo.setDepartment(newInfo.getDepartment());
        oldInfo.setGraduationYear(newInfo.getGraduationYear());
        oldInfo.setResumePath(newInfo.getResumePath());

        return stdInfoRepository.save(oldInfo);
    }

    // Delete Student Information
    public void deleteStudentInfo(Long id) {
        stdInfoRepository.deleteById(id);
    }
}

