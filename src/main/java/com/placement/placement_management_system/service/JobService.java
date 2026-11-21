
package com.placement.placement_management_system.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.Job;
import com.placement.placement_management_system.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Save Job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    // Update Job
    public Job updateJob(Long id, Job updatedJob) {
        Job existingJob = jobRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Job not found"));

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setSalary(updatedJob.getSalary());
        existingJob.setVacancies(updatedJob.getVacancies());
        existingJob.setJobType(updatedJob.getJobType());

        return jobRepository.save(existingJob);
    }

    // Delete Job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
