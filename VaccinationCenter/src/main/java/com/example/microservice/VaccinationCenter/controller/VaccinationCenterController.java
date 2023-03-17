package com.example.microservice.VaccinationCenter.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.VaccinationCenter.entity.VaccinationCenterEntity;
import com.example.microservice.VaccinationCenter.model.CitizenEntity;
import com.example.microservice.VaccinationCenter.model.RespoRequired;
import com.example.microservice.VaccinationCenter.services.VaccinationService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/v9")

public class VaccinationCenterController {
	
	private static final String MAIN_SERVICE = "mainService";
	private static final String FALLBACK_METHOD = "fallback";
	@Autowired
	private VaccinationService vaccinationService;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenterEntity> addCitizen(@RequestBody VaccinationCenterEntity vaccinationCenterEntity) {
		
		VaccinationCenterEntity pp = vaccinationService.save(vaccinationCenterEntity);
		return new ResponseEntity<VaccinationCenterEntity>(pp, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = MAIN_SERVICE, fallbackMethod= FALLBACK_METHOD)
	public ResponseEntity<RespoRequired> getAllDataBaseCenterId(@PathVariable Integer id){
	
		RespoRequired respoRequired = new RespoRequired();
		VaccinationCenterEntity vc = vaccinationService.getById(id);
		respoRequired.setCenter(vc);
		
		CitizenEntity dd =restTemplate.getForObject("http://Citizen-Service/v5/citizens/"+id, CitizenEntity.class);
		respoRequired.setCitizens(dd);
		return new ResponseEntity<RespoRequired>(respoRequired,HttpStatus.OK);}
		


		
	

	public ResponseEntity<RespoRequired> fallback(@PathVariable Integer id ,Throwable throwable){
		
	RespoRequired respoRequired = new RespoRequired();
	VaccinationCenterEntity vc = vaccinationService.getById(id);
	respoRequired.setCenter(vc);
	
	return new  ResponseEntity<RespoRequired>(respoRequired,HttpStatus.OK);
   
	

}
}
	

