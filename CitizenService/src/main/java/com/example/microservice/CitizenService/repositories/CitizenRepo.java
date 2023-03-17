package com.example.microservice.CitizenService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.CitizenService.Entity.CitizenEntity;
@Repository
public interface CitizenRepo extends JpaRepository<CitizenEntity, Integer> {

// custom method 
public List<CitizenEntity>  findByVaccinationCenterId( Integer id );

	

}
