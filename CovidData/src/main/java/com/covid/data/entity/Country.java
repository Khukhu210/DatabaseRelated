package com.covid.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Country {

	@Id
	@GeneratedValue
     private Long id ;
	 private String countryName;
	 private Long covidConfirmed;
	 private Long covidActive;
	 private Long covidRecovered;
	 private Long covidDeceased;
	 
	 
	
	 @OneToMany(mappedBy = "country")
	 private List<State> state = new ArrayList<State>();
	 
     public Country() {
		 
	 }
	
	public Country(Long id, String countryName, Long covidConfirmed, Long covidActive, Long covidRecovered,
			Long covidDeceased) {
		
		this.id = id;
		this.countryName = countryName;
		this.covidConfirmed = covidConfirmed;
		this.covidActive = covidActive;
		this.covidRecovered = covidRecovered;
		this.covidDeceased = covidDeceased;
	}


	public Long getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public List<State> getState() {
		return state;
	}


	public void setState(List<State> state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", covidConfirmed=" + covidConfirmed
				+ ", covidActive=" + covidActive + ", covidRecovered=" + covidRecovered + ", covidDeceased="
				+ covidDeceased + "]";
	}

	
	
	
	
	
	 
	 
}
