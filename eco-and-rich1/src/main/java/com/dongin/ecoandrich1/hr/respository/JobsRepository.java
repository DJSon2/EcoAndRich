package com.dongin.ecoandrich1.hr.respository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import com.dongin.ecoandrich1.hr.dto.EmployeesDTO;
import com.dongin.ecoandrich1.hr.entity.JobHistory;
import com.dongin.ecoandrich1.hr.entity.Jobs;

public interface JobsRepository extends JpaRepository <Jobs, Long> {

	@Modifying
    @Query("UPDATE Job j SET j.minSalary = j.minSalary * (1 + :percentage / 100), j.maxSalary = j.maxSalary * (1 + :percentage / 100)")
    List<Jobs> findMinSalaryAndMaxSalaryByJobId(@Param("percentage") BigDecimal percentage);


	List<Jobs> findByJobId(String jobId);

}
