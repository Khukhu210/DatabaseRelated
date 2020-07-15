package com.covid.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name = "find_all_states", query = "select s from State s")
public class State {

	@Id
	@GeneratedValue
	private Long id;
	private String stateName;
	private Long covidConfirmed;
	private Long covidActive;
	private Long covidRecovered;
	private Long covidDeceased;

	public State() {

	}

	@ManyToOne
	private Country country;

	@OneToMany(mappedBy = "state")
	private List<District> districts = new ArrayList<District>();

	public State(Long id, String stateName, Long covidConfirmed, Long covidActive, Long covidRecovered,
			Long covidDeceased) {

		this.id = id;
		this.stateName = stateName;
		this.covidConfirmed = covidConfirmed;
		this.covidActive = covidActive;
		this.covidRecovered = covidRecovered;
		this.covidDeceased = covidDeceased;
	}

	public Long getId() {
		return id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", stateName=" + stateName + ", covidConfirmed=" + covidConfirmed + ", covidActive="
				+ covidActive + ", covidRecovered=" + covidRecovered + ", covidDeceased=" + covidDeceased + "]";

	}

}
