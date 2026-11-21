
package com.placement.placement_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.placement_management_system.entity.JobApplication;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

}
