package com.dongin.ecoandrich1.hr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dongin.ecoandrich1.hr.dto.JobsDTO;
import com.dongin.ecoandrich1.hr.respository.JobsRepository;
import com.dongin.ecoandrich1.hr.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/job")
public class JobController {

	private static final Logger log = LoggerFactory.getLogger(JobController.class);
	private final EmployeeService employeeService;
	
	@Autowired
	private JobsRepository jobsRepository;
	public JobController(EmployeeService employeeService, JobsRepository jobsRepository, EmployeeService employeeService2) {
		this.employeeService = employeeService;
		this.jobsRepository = jobsRepository;		
	}
	
	/* 특정 직업 조회 요청 */
	@GetMapping("/{jobId}")
	public ModelAndView findJobById(ModelAndView mv, @PathVariable String jobId) {

	    JobsDTO jobs = employeeService.findJobByJobId(jobId);
	    
	    mv.addObject("jobId", jobs.getJobId());
	    mv.addObject("jobTitle", jobs.getJobTitle());
	    mv.addObject("minSalary", jobs.getMinSalary());
	    mv.addObject("maxSalary", jobs.getMaxSalary());
	    mv.setViewName("/hr/job");
	    
	    String jobId1 = jobs.getJobId();
	    log.info("[JobController] findJobById jobs 정보 잘 가져오나? " + jobs);
	    log.info("[JobController] findJobById jobId 정보 잘 가져오나? " + jobId);
	    log.info("[JobController] findJobById jobId1 정보 잘 가져오나? " + jobId1);

	    return mv;
	}
	
	
	@GetMapping("/1/{jobId}")
	@ApiOperation(value = "특정 직업 조회", notes = "Job ID로 특정 직업의 정보를 조회합니다.")
	public JobsDTO findJobById(@PathVariable String jobId) {
		return employeeService.findJobByJobId(jobId);
	}
	
}
