package com.embryoai.acloud.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationApi {
	
	@PostMapping("/api/v1.0/organization")
	public Object registOrganization() {
		return null;
	}
	
}
