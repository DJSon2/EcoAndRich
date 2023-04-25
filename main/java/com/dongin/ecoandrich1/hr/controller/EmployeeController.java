package com.dongin.ecoandrich1.hr.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongin.ecoandrich1.hr.dto.DepartmentsDTO;
import com.dongin.ecoandrich1.hr.dto.EmployeesDTO;
import com.dongin.ecoandrich1.hr.dto.JobHistoryDTO;
import com.dongin.ecoandrich1.hr.dto.JobsDTO;
import com.dongin.ecoandrich1.hr.dto.LocationsDTO;
import com.dongin.ecoandrich1.hr.service.EmployeeService;

@Controller
@RequestMapping("/hr")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

		/* 직원 리스트 조회 요청 */
	    @GetMapping("/employeeList")
	    public ModelAndView findEmployeeList(ModelAndView mv) {
	    
	    	List<EmployeesDTO> employeeList = employeeService.findEmployeeList();
	      	
	    	
	        mv.addObject("employeeList", employeeList);
	        mv.setViewName("hr/list");
	        return mv;
	    }
	    
	    /* 특정 직원 조회 요청 */
	    @GetMapping("/{employeeId}")
	    public ModelAndView findEmployeeById(ModelAndView mv, @PathVariable Long employeeId) {
	    
	    	EmployeesDTO employee = employeeService.findEmployeeById(employeeId);
	    	
	        mv.addObject("employeeId", employee.getEmployeeId());
	        mv.addObject("firstName", employee.getFirstName());
	        mv.addObject("lastName", employee.getLastName());
	        mv.addObject("email", employee.getEmail());
	        mv.addObject("phoneNumber", employee.getPhoneNumber());
	        mv.addObject("salary", employee.getSalary());
	        mv.setViewName("/hr/one");
	        
	    	return mv;
	    	
	    }
	    
	    /* 특정 부서 조회 요청 */
	    @GetMapping("/departments/{departmentId}")
	    public ModelAndView findDepartmentsById(ModelAndView mv, @PathVariable Long departmentId) {
	    	
	    	log.info("[EmployeeController] findDepartmentsById start ==================");
	    	log.info("[EmployeeController] findDepartmentsById departmentId 정보 잘 가져오나? " + departmentId);
	    	DepartmentsDTO departments = employeeService.findDepartmentsById(departmentId);
	    	
	        mv.addObject("departmentId", departments.getDepartmentId());
	        mv.addObject("departmentName", departments.getDepartmentName());
	        mv.addObject("managerId", departments.getManagerId());
	        mv.addObject("locationId", departments.getLocationId());
	        
	        /* locationId로 해당 부서의 위치 정보를 조회하여 추가 */
	        LocationsDTO locations = employeeService.findLocationsById(departments.getLocationId());
	        mv.addObject("streetAddress", locations.getStreetAddress());
	        mv.addObject("postalCode", locations.getPostalCode());
	        mv.addObject("city", locations.getCity());
	        mv.addObject("stateProvince", locations.getStateProvince());
	        mv.addObject("countryId", locations.getCountryId());

	    	log.info("[EmployeeController] findDepartmentsById locations 정보 잘 가져오나? " + locations);

	        
	        mv.setViewName("/hr/departments");
	        
	        log.info("[EmployeeController] findDepartmentsById end ==================");
	    	return mv;
	    	
	    }
	    
	    /* 특정 직원 이력 조회 요청 */
	    @GetMapping("/history/{employeeId}")
	    public ModelAndView findEmployeesAndJobHistoryById(ModelAndView mv, @PathVariable Long employeeId) {
	    
	    	log.info("[EmployeeController] findEmployeesAndJobHistoryById start ==================");
	    	log.info("[EmployeeController] findJobById jobId 정보 잘 가져오나? " + employeeId);
	    	JobHistoryDTO employee = employeeService.findJobHistoryById(employeeId);
	    	
	        mv.addObject("employeeId", employee.getEmployeeId());
	        mv.addObject("jobId", employee.getJobId());
	        mv.addObject("startDate", employee.getStartDate());
	        mv.addObject("endDate", employee.getEndDate());
	        mv.setViewName("/hr/employeeHistory");
		    log.info("[EmployeeController] findJobById Service 이후 jobId 정보 잘 가져오나? " + employeeId);
		    log.info("[EmployeeController] findJobById employee 정보 잘 가져오나? " + employee);

		    log.info("[EmployeeController] findEmployeesAndJobHistoryById End ==================");
		    
	    	return mv;
	    	
	    }
	    
	    /* 수정 페이지 조회 */
	    @GetMapping("/modify")
	    public void modifyPage() {}    
	    
	    /* 급여 수정 */
	    @PostMapping("/modify")
	    public String modifyPage(RedirectAttributes rttr, @ModelAttribute JobsDTO jobs,
	                              @RequestParam(name = "percentage", required = false) BigDecimal percentageParam) {
	        BigDecimal percentage = percentageParam == null ? BigDecimal.ZERO : percentageParam;
	        employeeService.modifyAcceptSalary(jobs, percentage);
	        rttr.addFlashAttribute("modifySuccessMessage", "급여 수정에 성공했습니다.");
	        return "redirect:/job/" + jobs.getJobId();
	    }
	    
	  

	 
}

	

