package com.dongin.ecoandrich1.hr.respository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dongin.ecoandrich1.hr.entity.Employees;


public interface EmployeesRepository extends JpaRepository <Employees, Long> {

	List<Employees> findByEmployeeIdContaining(String searchValue, Pageable paging);
	
  
}
