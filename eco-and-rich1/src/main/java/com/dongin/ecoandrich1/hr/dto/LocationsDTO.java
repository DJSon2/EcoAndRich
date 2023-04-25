package com.dongin.ecoandrich1.hr.dto;

import java.util.List;

public class LocationsDTO {

	private Long locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	
	private String countryId;

	public LocationsDTO() {}
	
	public LocationsDTO(Long locationId, String streetAddress, String postalCode, String city, String stateProvince,
			String countryId) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "LocationsDTO [locationId=" + locationId + ", streetAddress=" + streetAddress + ", postalCode="
				+ postalCode + ", city=" + city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	
	
	

}
