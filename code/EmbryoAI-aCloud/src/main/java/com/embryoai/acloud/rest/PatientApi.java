package com.embryoai.acloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embryoai.acloud.service.PatientService;

@RestController
public class PatientApi {

	@Autowired PatientService patientService;
	
	/**
	 * 保存用户信息,周期信息
	 * @param data
	 * @return
	 */
	@PostMapping("/api/v1.0/savePatientInfo")
	public Object savePatientInfo(@RequestBody String data){
		return patientService.savePatientInfo(data);
	}
	
	/**
	 * 修改用户信息,周期信息
	 * @param data
	 * @return
	 */
	@PostMapping("/api/v1.0/updatePatientInfo")
	public Object updatePatientInfo(@RequestBody String data){
		return patientService.updatePatientInfo(data);
	}
}
