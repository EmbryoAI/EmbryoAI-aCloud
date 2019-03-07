package com.embryoai.acloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embryoai.acloud.service.OrganizationService;


@RestController
public class OrganizationApi {
	
	@Autowired
	private OrganizationService organizationService;
	
	
	@PostMapping("/api/v1.0/organization/register")
	public Object registOrganization(@RequestBody String data) {
		return organizationService.registeredToCloud(data);
	}
	
	@PostMapping("/api/v1.0/organization/key")
	public Object createOrganizationKey(@RequestBody String data) {
		return organizationService.createKey(data);
	}
}
