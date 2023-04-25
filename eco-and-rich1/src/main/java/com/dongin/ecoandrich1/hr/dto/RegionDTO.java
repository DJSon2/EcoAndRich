package com.dongin.ecoandrich1.hr.dto;

public class RegionDTO {

	private Long regionId;
	private String regionName;
	
	
	public RegionDTO(Long regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}
	@Override
	public String toString() {
		return "regionDTO [regionId=" + regionId + ", regionName=" + regionName + "]";
	}
	
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
}
