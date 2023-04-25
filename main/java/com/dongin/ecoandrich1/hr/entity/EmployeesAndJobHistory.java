package com.dongin.ecoandrich1.hr.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EmployeesAndJobHistory {


    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

	@Column(name = "start_date")
    private Date startDate;

	@Column(name = "end_date")
    private Date endDate;

//    @OneToMany
//    @JoinColumn(name = "managerId")
//    private List<Departments> departments;

    @OneToMany
    @JoinColumn(name = "job_id")
    private List<Jobs> jobId;

    @OneToMany
    @JoinColumn(name = "departmentId")
    private List<Departments> departments;

	public EmployeesAndJobHistory(Long employeeId, String firstName, String lastName, String email, String phoneNumber,
			Date hireDate, BigDecimal salary, BigDecimal commissionPct, Date startDate, Date endDate, List<Jobs> jobId,
			List<Departments> departments) {
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
		this.jobId = jobId;
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "EmployeesAndJobHistory [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", commissionPct=" + commissionPct + ", startDate=" + startDate + ", endDate="
				+ endDate + ", jobId=" + jobId + ", departments=" + departments + "]";
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

	public List<Jobs> getJobId() {
		return jobId;
	}

	public void setJobId(List<Jobs> jobId) {
		this.jobId = jobId;
	}

	public List<Departments> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Departments> departments) {
		this.departments = departments;
	}
	

	
    
	
	
}
