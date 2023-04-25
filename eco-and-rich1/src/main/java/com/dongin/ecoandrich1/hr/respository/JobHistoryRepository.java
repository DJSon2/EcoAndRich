package com.dongin.ecoandrich1.hr.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongin.ecoandrich1.hr.entity.JobHistory;

public interface JobHistoryRepository extends JpaRepository <JobHistory, Long> {

	List<JobHistory> findByEmployeeId(Long employeeId);
}
