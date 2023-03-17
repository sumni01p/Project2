package com.example.microservice.CitizenService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservice.CitizenService.Entity.CitizenEntity;

public interface CitizenService {
	List<CitizenEntity>getAll();

	CitizenEntity save(CitizenEntity citizen);

//	List<CitizenEntity> getByVaccinationCenterId(Integer id);
	CitizenEntity getById(Integer id);

	List<CitizenEntity> getByVaccinationCenterId(Integer id);
	
	

}
