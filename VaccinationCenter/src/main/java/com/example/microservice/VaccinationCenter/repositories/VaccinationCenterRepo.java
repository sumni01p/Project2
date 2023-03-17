package com.example.microservice.VaccinationCenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.VaccinationCenter.entity.VaccinationCenterEntity;


@Repository
public interface  VaccinationCenterRepo extends JpaRepository<VaccinationCenterEntity, Integer> {

}
