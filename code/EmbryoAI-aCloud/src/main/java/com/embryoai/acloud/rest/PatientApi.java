package com.embryoai.acloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embryoai.acloud.service.PatientService;

@RestController
public class PatientApi {

	@Autowired PatientService patientService;
	
	@PostMapping("/api/v1.0/receivePatientInfo")
	public Object receivePatientInfo(@RequestBody String data){
		return patientService.receivePatientInfo(data);
	}
}
