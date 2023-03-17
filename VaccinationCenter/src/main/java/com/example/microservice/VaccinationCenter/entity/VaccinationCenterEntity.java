package com.example.microservice.VaccinationCenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenterEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	@Column
	private String centerName;
	@Column
	private String centerAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	@Override
	public String toString() {
		return "VaccinationCenterEntity [id=" + id + ", centerName=" + centerName + ", centerAddress=" + centerAddress
				+ "]";
	}
	public VaccinationCenterEntity(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}
	public VaccinationCenterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
