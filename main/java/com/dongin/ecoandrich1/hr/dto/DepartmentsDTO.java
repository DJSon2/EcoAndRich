package com.dongin.ecoandrich1.hr.dto;

import java.util.List;

public class DepartmentsDTO {

	private Long departmentId;
	private String departmentName;
	private Long managerId;
	private Long locationId;
	
	public DepartmentsDTO() {}
	
	public DepartmentsDTO(Long departmentId, String departmentName, Long managerId, Long locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "DepartmentsDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	
	


	
}
