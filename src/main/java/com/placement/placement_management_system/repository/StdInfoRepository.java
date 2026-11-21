
package com.placement.placement_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.placement_management_system.entity.StdInfo;

public interface StdInfoRepository extends JpaRepository<StdInfo, Long> {

    Optional<StdInfo> findByStudentId(Long studentId);

    boolean existsByStudentId(Long studentId);

}
