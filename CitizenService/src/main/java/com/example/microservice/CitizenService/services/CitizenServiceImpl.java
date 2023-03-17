package com.example.microservice.CitizenService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.microservice.CitizenService.Entity.CitizenEntity;
import com.example.microservice.CitizenService.repositories.CitizenRepo;

@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	private CitizenRepo repo;

	@Override
	public List<CitizenEntity> getAll() {

		List<CitizenEntity> pp = repo.findAll();
		return pp;

	}

	@Override
	public CitizenEntity save(CitizenEntity citizen) {
		CitizenEntity sav = repo.save(citizen);
		return sav;
	}

	@Override
	public  CitizenEntity getById(Integer id) {
		Optional <CitizenEntity> jj = repo.findById(id);
		CitizenEntity emp =jj.orElseThrow(()->new EmployeeNotFoundException("Citizens  not exist"));
	return emp;
	}

	@Override
	public List<CitizenEntity> getByVaccinationCenterId(Integer id) {
		List<CitizenEntity> cc = repo.findByVaccinationCenterId(id);
	return cc;
		
	}



}
