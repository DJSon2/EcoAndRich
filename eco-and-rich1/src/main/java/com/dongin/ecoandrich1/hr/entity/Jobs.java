package com.dongin.ecoandrich1.hr.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Jobs {

	@Id	
    @Column(name = "job_id")
    private String jobId;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "min_salary")
	private BigDecimal minSalary;
	
	@Column(name = "max_salary")
	private BigDecimal maxSalary;

	public Jobs() {
		
	}
	
	public Jobs(String jobId, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}

	public String getJobId() {
		return jobId;
	}

	void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	
}
