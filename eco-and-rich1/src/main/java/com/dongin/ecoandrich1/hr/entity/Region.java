
package com.dongin.ecoandrich1.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

	@Id
    @Column(name = "region_id")
    private Long regionId;
	
	@Column(name = "region_name")
	private String regionName;

	public Region(Long regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}

	Long getRegionId() {
		return regionId;
	}

	void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	String getRegionName() {
		return regionName;
	}

	void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	

	
}
