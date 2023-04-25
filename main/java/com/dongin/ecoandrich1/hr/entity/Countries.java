package com.dongin.ecoandrich1.hr.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dongin.ecoandrich1.hr.dto.RegionDTO;

@Entity
@Table(name = "countries")
public class Countries {
	
	@Id
	@Column(name = "country_id")
	private String countryId;
	
	@Column(name = "country_name")
	private String countryName;
	
	@OneToMany
	@JoinColumn(name = "region_id")
	private List<Region> regionId;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Countries(String countryId, String countryName, List<Region> regionId, Location location) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionId = regionId;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Countries [countryId=" + countryId + ", countryName=" + countryName + ", regionId=" + regionId
				+ ", location=" + location + "]";
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

	public List<Region> getRegionId() {
		return regionId;
	}

	public void setRegionId(List<Region> regionId) {
		this.regionId = regionId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	
}
