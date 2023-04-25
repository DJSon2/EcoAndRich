package com.dongin.ecoandrich1.hr.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
    @Column(name = "location_id")
    private Long locationId;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column(name = "state_province")
	private String stateProvince;

	@Column(name = "country_id")
	private String countryId;

	public Location() {}

	public Location(Long locationId, String postalCode, String city, String streetAddress, String stateProvince,
			String countryId) {
		super();
		this.locationId = locationId;
		this.postalCode = postalCode;
		this.city = city;
		this.streetAddress = streetAddress;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", postalCode=" + postalCode + ", city=" + city
				+ ", streetAddress=" + streetAddress + ", stateProvince=" + stateProvince + ", countryId=" + countryId
				+ "]";
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
