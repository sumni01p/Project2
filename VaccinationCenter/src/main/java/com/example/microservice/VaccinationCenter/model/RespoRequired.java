package com.example.microservice.VaccinationCenter.model;

import java.util.List;

import com.example.microservice.VaccinationCenter.entity.VaccinationCenterEntity;



public class RespoRequired {
	private VaccinationCenterEntity center;
	private  CitizenEntity  citizens;
	public VaccinationCenterEntity getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenterEntity center) {
		this.center = center;
	}
	public CitizenEntity getCitizens() {
		return citizens;
	}
	public void setCitizens(CitizenEntity citizens) {
		this.citizens = citizens;
	}
	@Override
	public String toString() {
		return "RequiredResponse [center=" + center + ", citizens=" + citizens + "]";
	}
	public RespoRequired(VaccinationCenterEntity center, CitizenEntity citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}
	public RespoRequired() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}



