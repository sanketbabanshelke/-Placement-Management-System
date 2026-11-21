
package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.JobApplication;
import com.placement.placement_management_system.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(
            JobApplicationRepository jobApplicationRepository) {

        this.jobApplicationRepository = jobApplicationRepository;
    }

    // Save Application
    public JobApplication saveApplication(JobApplication application) {
        return jobApplicationRepository.save(application);
    }

    // Get All Applications
    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    // Get Application By ID
    public JobApplication getApplicationById(Long id) {
        return jobApplicationRepository.findById(id).orElse(null);
    }

    // Update Application
    public JobApplication updateApplication(
            Long id, JobApplication updatedApplication) {

        JobApplication existingApplication =
            jobApplicationRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Application not found"));

        existingApplication.setStudentId(
            updatedApplication.getStudentId());

        existingApplication.setJobId(
            updatedApplication.getJobId());

        existingApplication.setApplicationDate(
            updatedApplication.getApplicationDate());

        existingApplication.setStatus(
            updatedApplication.getStatus());

        return jobApplicationRepository.save(existingApplication);
    }

    // Delete Application
    public void deleteApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}
