package com.covid.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class District {
	@Id
	@GeneratedValue
	private Long id;
	private String districtName;
	private Long covidConfirmed;
	private Long covidActive;
	private Long covidRecovered;
	private Long covidDeceased;

	public District() {

	}

	@ManyToOne
	 private State state ;

	public District(Long id, String districtName, Long covidConfirmed, Long covidActive, Long covidRecovered,
			Long covidDeceased) {
		super();
		this.id = id;
		this.districtName = districtName;
		this.covidConfirmed = covidConfirmed;
		this.covidActive = covidActive;
		this.covidRecovered = covidRecovered;
		this.covidDeceased = covidDeceased;
	}



	public Long getId() {
		return id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Long getCovidConfirmed() {
		return covidConfirmed;
	}

	public void setCovidConfirmed(Long covidConfirmed) {
		this.covidConfirmed = covidConfirmed;
	}
	

	public Long getCovidActive() {
		return covidActive;
	}

	public void setCovidActive(Long covidActive) {
		this.covidActive = covidActive;
	}



	public Long getCovidRecovered() {
		return covidRecovered;
	}

	public void setCovidRecovered(Long covidRecovered) {
		this.covidRecovered = covidRecovered;
	}

	public Long getCovidDeceased() {
		return covidDeceased;
	}

	public void setCovidDeceased(Long covidDeceased) {
		this.covidDeceased = covidDeceased;
	}



	public State getState() {
		return state;
	}



	public void setState(State state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + ", covidConfirmed=" + covidConfirmed
				+ ", covidActive=" + covidActive + ", covidRecovered=" + covidRecovered + ", covidDeceased="
				+ covidDeceased + "]";
	}

	

}
