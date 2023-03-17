package com.example.microservice.CitizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.CitizenService.Entity.CitizenEntity;
import com.example.microservice.CitizenService.services.CitizenService;

@RestController
@RequestMapping("/v5")
public class CitizenController {

	@Autowired
	private CitizenService services;

	@GetMapping("/text")
	public ResponseEntity<String> getString() {
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CitizenEntity>> findAll() {

		List<CitizenEntity> dd = services.getAll();
		return new ResponseEntity<List<CitizenEntity>>(dd, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<CitizenEntity> add(@RequestBody CitizenEntity citizenEntity) {

		CitizenEntity sav = services.save(citizenEntity);
		return new ResponseEntity<CitizenEntity>(sav, HttpStatus.OK);
	}

	@GetMapping("/citizens/{id}")
	public ResponseEntity<CitizenEntity> getById(@PathVariable Integer id) {
		CitizenEntity cc = services.getById(id);
		return new ResponseEntity<CitizenEntity>(cc, HttpStatus.OK);

	}

	@GetMapping("/one/{id}")

	public ResponseEntity<List<CitizenEntity>> getByVaccinationId(@PathVariable Integer id) {
		List<CitizenEntity> citizen = services.getByVaccinationCenterId(id);
		return new ResponseEntity<>(citizen, HttpStatus.OK);

	}

}
