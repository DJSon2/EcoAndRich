package com.dongin.ecoandrich1.hr.dto;

import java.util.List;

public class CountriesDTO {

	private String countryId;
	private String countryName;
	
	private List<RegionDTO> regionId;
	
	
	public CountriesDTO(String countryId, String countryName, List<RegionDTO> regionId) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionId = regionId;
	}
	@Override
	public String toString() {
		return "CountriesDTO [countryId=" + countryId + ", countryName=" + countryName + ", regionId=" + regionId + "]";
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<RegionDTO> getRegionId() {
		return regionId;
	}
	public void setRegionId(List<RegionDTO> regionId) {
		this.regionId = regionId;
	}
	
	
	
}
