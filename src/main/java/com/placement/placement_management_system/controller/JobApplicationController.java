
package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.placement.placement_management_system.entity.JobApplication;
import com.placement.placement_management_system.service.JobApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(
            JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    // Add Application
    @PostMapping
    public JobApplication saveApplication(
            @RequestBody JobApplication application) {
        return jobApplicationService.saveApplication(application);
    }

    // View All Applications
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    // View Application By ID
    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id);
    }

    // Update Application
    @PutMapping("/{id}")
    public JobApplication updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication application) {
        return jobApplicationService.updateApplication(id, application);
    }

    // Delete Application
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
        return "Application Deleted Successfully";
    }
}
