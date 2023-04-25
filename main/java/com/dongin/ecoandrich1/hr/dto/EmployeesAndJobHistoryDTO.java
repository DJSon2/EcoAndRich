package com.dongin.ecoandrich1.hr.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.dongin.ecoandrich1.hr.entity.Departments;
import com.dongin.ecoandrich1.hr.entity.Jobs;

public class EmployeesAndJobHistoryDTO {

	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private BigDecimal salary;
	private BigDecimal commissionPct;
	private Date startDate;
	private Date endDate;
	private List<Departments> managerId;
	private List<Jobs> jobId;
	private List<Departments> departmentId;
	
	public EmployeesAndJobHistoryDTO () {}
	
	public EmployeesAndJobHistoryDTO(Long employeeId, String firstName, String lastName, String email,
			String phoneNumber, Date hireDate, BigDecimal salary, BigDecimal commissionPct, Date startDate,
			Date endDate, List<Departments> managerId, List<Jobs> jobId, List<Departments> departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "EmployeesAndJobHistoryDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", commissionPct=" + commissionPct + ", startDate=" + startDate + ", endDate="
				+ endDate + ", managerId=" + managerId + ", jobId=" + jobId + ", departmentId=" + departmentId + "]";
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Departments> getManagerId() {
		return managerId;
	}

	public void setManagerId(List<Departments> managerId) {
		this.managerId = managerId;
	}

	public List<Jobs> getJobId() {
		return jobId;
	}

	public void setJobId(List<Jobs> jobId) {
		this.jobId = jobId;
	}

	public List<Departments> getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(List<Departments> departmentId) {
		this.departmentId = departmentId;
	}
	

	
}
