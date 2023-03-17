package com.example.microservice.VaccinationCenter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.VaccinationCenter.entity.VaccinationCenterEntity;
import com.example.microservice.VaccinationCenter.repositories.VaccinationCenterRepo;
@Service
public class VaccinationServiceImpl implements VaccinationService {
	@Autowired
	private VaccinationCenterRepo repo;

	@Override
	public VaccinationCenterEntity save(VaccinationCenterEntity vaccinationCenterEntity) {
		VaccinationCenterEntity pp = repo.save(vaccinationCenterEntity);
		return pp;
	}

	@Override
	public VaccinationCenterEntity getById(Integer id) {
		
		VaccinationCenterEntity cc = repo.findById(id).get();
		return cc;
		
	}

}
