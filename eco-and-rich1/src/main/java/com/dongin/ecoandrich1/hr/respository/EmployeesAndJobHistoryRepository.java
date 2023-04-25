package com.dongin.ecoandrich1.hr.respository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dongin.ecoandrich1.hr.entity.EmployeesAndJobHistory;

public interface EmployeesAndJobHistoryRepository extends JpaRepository <EmployeesAndJobHistory, Long> {

	@Query("SELECT e, j FROM Employees e LEFT JOIN e.jobHistory j WHERE e.employeeId = :employeeId")
	EmployeesAndJobHistory findEmployeesAndJobHistoryByEmployeeId(@Param("employeeId") Long employeeId);

	
}
