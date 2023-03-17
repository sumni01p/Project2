package com.example.microservice.VaccinationCenter.services;



import java.util.List;

import com.example.microservice.VaccinationCenter.entity.VaccinationCenterEntity;



public interface VaccinationService {
	VaccinationCenterEntity save ( VaccinationCenterEntity vaccinationCenterEntity);
	VaccinationCenterEntity getById(Integer id );
	

}
