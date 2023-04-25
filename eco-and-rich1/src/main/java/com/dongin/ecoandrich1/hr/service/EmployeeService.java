package com.dongin.ecoandrich1.hr.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongin.ecoandrich1.hr.dto.DepartmentsDTO;
import com.dongin.ecoandrich1.hr.dto.EmployeesDTO;
import com.dongin.ecoandrich1.hr.dto.JobHistoryDTO;
import com.dongin.ecoandrich1.hr.dto.JobsDTO;
import com.dongin.ecoandrich1.hr.dto.LocationsDTO;
import com.dongin.ecoandrich1.hr.entity.Departments;
import com.dongin.ecoandrich1.hr.entity.Employees;
import com.dongin.ecoandrich1.hr.entity.JobHistory;
import com.dongin.ecoandrich1.hr.entity.Jobs;
import com.dongin.ecoandrich1.hr.entity.Location;
import com.dongin.ecoandrich1.hr.respository.DepartmentsRepository;
import com.dongin.ecoandrich1.hr.respository.EmployeesAndJobHistoryRepository;
import com.dongin.ecoandrich1.hr.respository.EmployeesRepository;
import com.dongin.ecoandrich1.hr.respository.JobHistoryRepository;
import com.dongin.ecoandrich1.hr.respository.JobsRepository;
import com.dongin.ecoandrich1.hr.respository.LocationRepository;

@Service
public class EmployeeService {
				
			private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
			private final EmployeesRepository employeeRepository;
			private final JobsRepository jobsRepository;
			private final ModelMapper modelMapper;
			private final EmployeesAndJobHistoryRepository employeesAndJobHistoryRepository;
			private final JobHistoryRepository jobHistoryRepository;
			private final DepartmentsRepository departmentsRepository;
			private final LocationRepository locationRepository;
			
			@Autowired
			public EmployeeService (EmployeesRepository employeeRepository, ModelMapper modelMapper, JobsRepository jobHistoryRepository, JobsRepository jobsRepository, EmployeesAndJobHistoryRepository employeesAndJobHistoryRepository, JobHistoryRepository jobHistoryRepository2, DepartmentsRepository departmentsRepository, LocationRepository locationRepository) {
				this.employeeRepository = employeeRepository;
				this.jobsRepository = jobsRepository;
				this.modelMapper = modelMapper;
				this.employeesAndJobHistoryRepository = employeesAndJobHistoryRepository;
				this.jobHistoryRepository = jobHistoryRepository2;
				this.departmentsRepository = departmentsRepository;
				this.locationRepository = locationRepository;
			}
			
			/* 직원 리스트 조회 */
			@Transactional
			public List<EmployeesDTO> findEmployeeList() {
				
				List<Employees> employeeList = employeeRepository.findAll();
							
				
				return employeeList.stream().map(employees -> modelMapper.map(employees, EmployeesDTO.class)).collect(Collectors.toList());
			}

			/* 특정 직원 정보 조회 */
			@Transactional
			public EmployeesDTO findEmployeeById(Long employeeId) {

				Employees employee = employeeRepository.findById(employeeId).get();
				
				/* ModelMapper로 entity를 DTO로 변환 후 EmployeesDTO로 반환 */
				return modelMapper.map(employee, EmployeesDTO.class);
			}
			
			/* 특정 부서 정보 조회 */
			@Transactional
			public DepartmentsDTO findDepartmentsById(Long departmentId) {
				log.info("[EmployeeService] findDepartmentsById start ==================");
		    	log.info("[EmployeeService] findDepartmentsById departmentId 정보 잘 가져오나? " + departmentId);

				Departments departments = departmentsRepository.findById(departmentId).get();
				
				log.info("[EmployeeService] findDepartmentsById end ==================");
				/* ModelMapper로 entity를 DTO로 변환 후 DepartmentsDTO로 반환 */
				return modelMapper.map(departments, DepartmentsDTO.class);
			}
			
			/* 특정 직원 이력 조회 */
			@Transactional
			public JobHistoryDTO findJobHistoryById(Long employeeId) {
			    log.info("[EmployeeService] findJobHistoryByEmployeeId start ==================");
			    log.info("[EmployeeService] findJobHistoryByEmployeeId employeeId 정보 잘 가져오나? " + employeeId);
			    Optional<JobHistory> jobHistoryOptional = jobHistoryRepository.findById(employeeId);
			    if (!jobHistoryOptional.isPresent()) {
			        throw new NoSuchElementException("No job history found for employee with id: " + employeeId);
			    }
			    JobHistory employee = jobHistoryOptional.get();
			    log.info("[EmployeeService] findJobHistoryByEmployeeId employee 정보 잘 가져오나? " + employee);
			    log.info("[EmployeeService] findJobHistoryByEmployeeId End ==================");
			   
			    /* ModelMapper로 entity를 DTO로 변환 후 JobHistoryDTO로 반환 */
			    return modelMapper.map(employee, JobHistoryDTO.class);
			}

			
			/* 특정 직업 조회 */
			@Transactional
			public JobsDTO findJobByJobId(String jobId) {
				
				 log.info("[EmployeeService] findJobByJobId Start ==========");
				 
				Jobs jobs = jobsRepository.findByJobId(jobId).get(0);
				
				 log.info("[EmployeeService] findJobByJobId jobs 정보 잘 가져오나? " + jobs);
				
			    log.info("[EmployeeService] findJobByJobId End ==========");
				/* ModelMapper로 entity를 DTO로 변환 후 JobsDTO로 반환 */
				return modelMapper.map(jobs, JobsDTO.class);
			} 


			/* 급여 수정 */
			@Transactional
			public void modifyAcceptSalary(JobsDTO jobs, BigDecimal percentage) {
			    log.info("[EmployeeService] modifySalary2 Start ==========");
			    if (percentage == null) {
			        throw new IllegalArgumentException("Percentage value cannot be null.");
			    }
			    log.info("[EmployeeService] modifySalary {} percentage 넘어오나? " + percentage);

			    Optional<Jobs> optionalFoundSalary = jobsRepository.findByJobId(jobs.getJobId()).stream().findFirst();
			    if (optionalFoundSalary.isPresent()) {
			        Jobs foundSalary = optionalFoundSalary.get();
			        log.info("[EmployeeService] modifySalary {} salary 잘 가져오나? " + foundSalary);

			        foundSalary.setMinSalary(foundSalary.getMinSalary().multiply(percentage));
			        foundSalary.setMaxSalary(foundSalary.getMaxSalary().multiply(percentage));

			        log.info("[EmployeeService] modifySalary {} salary 적용됐나? " + foundSalary);
			    } else {
			        throw new IllegalArgumentException("Salary not found.");
			    }
			    log.info("[EmployeeService] modifySalary2 End ==========");
			}

			/* 특정 위치 정보 조회 */
			@Transactional
			public LocationsDTO findLocationsById(Long locationId) {
			    log.info("[EmployeeService] findLocationsById start ==================");
			    log.info("[EmployeeService] findLocationsById locationId 정보 잘 가져오나? " + locationId);
			    Location locations = locationRepository.findById(locationId).get();
			    log.info("[EmployeeService] findLocationsById end ==================");

			    /* ModelMapper로 entity를 DTO로 변환 후 LocationsDTO로 반환 */
			    return modelMapper.map(locations, LocationsDTO.class);
			}
			
		


}
