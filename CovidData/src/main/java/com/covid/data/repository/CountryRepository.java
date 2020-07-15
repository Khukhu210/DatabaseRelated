package com.covid.data.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.covid.data.entity.Country;
import com.covid.data.entity.District;
import com.covid.data.entity.State;



@Repository
@Transactional
public class CountryRepository {

	private Logger logger = LoggerFactory.getLogger(CountryRepository.class);
	
	@Autowired
	EntityManager em;
	
	public void persistCountryData(Country country) {

		em.persist(country);

		for (State state : country.getState()) {
			em.persist(state);
			
			for(District  district : state.getDistricts()) {
			em.persist(district);
			}
		}

		em.flush();
		//em.refresh(country);

	}
	

	public Country allCountry() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> cq = cb.createQuery(Country.class);

		Root<Country> courseRoot = cq.from(Country.class);

		TypedQuery<Country> query = em.createQuery(cq.select(courseRoot));
		List<Country> resultList = query.getResultList();
		logger.info("Typed Query having all courses->{}", resultList);
		return resultList.get(0);

	}  
	 
	
}
	 