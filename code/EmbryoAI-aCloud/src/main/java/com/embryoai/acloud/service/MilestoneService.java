package com.embryoai.acloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.embryoai.acloud.dto.BaseResult;
import com.embryoai.acloud.dto.Rsp;
import com.embryoai.acloud.entity.SystemMilestone;
import com.embryoai.acloud.entity.SystemMilestoneData;
import com.embryoai.acloud.mapper.SystemMilestoneDataMapper;
import com.embryoai.acloud.mapper.SystemMilestoneMapper;

@Service
@Transactional
public class MilestoneService {

	@Autowired
	private SystemMilestoneMapper milestoneMapper;
	
	@Autowired
	private SystemMilestoneDataMapper milestoneMapperData;
	private Logger log = LoggerFactory.getLogger(PatientService.class);
	
	/**
	 * 保存里程碑相关信息
	 * @param data
	 * @return
	 */
	public BaseResult saveMilestone(String data) { 
		try {
			JSONObject dataObject = JSON.parseObject(data);
			SystemMilestone milestone = dataObject.getObject("milestone", SystemMilestone.class);
			SystemMilestoneData milestoneData = dataObject.getObject("milestoneData", SystemMilestoneData.class);
			milestoneMapper.insert(milestone);
			milestoneMapperData.insert(milestoneData);
		} catch (Exception e) {
			log.error("保存里程碑相关信息异常:{}",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("保存里程碑相关信息异常!", e.getMessage());
		}
		return Rsp.succ("OK", null);
	}

}
