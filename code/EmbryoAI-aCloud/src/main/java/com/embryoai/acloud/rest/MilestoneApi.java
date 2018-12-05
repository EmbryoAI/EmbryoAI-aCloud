package com.embryoai.acloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embryoai.acloud.service.MilestoneService;

/**
 * 里程碑数据接收
 * @Company: 
 * @author LiuYZ
 * @date 2018-12-01
 * @version 1.0
 */
@RestController
public class MilestoneApi {
	@Autowired
	private MilestoneService milestoneService;
	
	/**
	 * 保存里程碑相关信息
	 * @param data
	 * @return
	 */
	@PostMapping("/api/v1.0/milestone")
	public Object saveMilestone(@RequestBody String data){
		return milestoneService.saveMilestone(data);
	}
	
	
}