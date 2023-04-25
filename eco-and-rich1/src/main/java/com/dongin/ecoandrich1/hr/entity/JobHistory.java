package com.dongin.ecoandrich1.hr.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dongin.ecoandrich1.hr.dto.DepartmentsDTO;

@Entity
@Table(name = "job_history")
public class JobHistory {
	
	@Id
    @Column(name = "employee_id")
    private Long employeeId;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	
	@Column(name = "job_id")
	private String jobId;
	
	
	@Column(name = "department_id")
	private Long departmentId;

	public JobHistory() {}

	public JobHistory(Long employeeId, Date startDate, Date endDate, String jobId, Long departmentId) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}


	@Override
	public String toString() {
		return "JobHistory [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate + ", jobId="
				+ jobId + ", departmentId=" + departmentId + "]";
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	
}
