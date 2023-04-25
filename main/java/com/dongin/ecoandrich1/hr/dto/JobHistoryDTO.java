package com.dongin.ecoandrich1.hr.dto;

import java.sql.Date;
import java.util.List;

public class JobHistoryDTO {

	private Long employeeId;
	private Date startDate;
	private Date endDate;
	private String jobId;
	private Long departmentId;
	
	public JobHistoryDTO() {}
	
	public JobHistoryDTO(Long employeeId, Date startDate, Date endDate, String jobId, Long departmentId) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "JobHistoryDTO [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", jobId=" + jobId + ", departmentId=" + departmentId + "]";
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
