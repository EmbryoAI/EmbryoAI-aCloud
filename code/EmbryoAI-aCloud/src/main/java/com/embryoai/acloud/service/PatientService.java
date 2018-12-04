package com.embryoai.acloud.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.embryoai.acloud.dto.Rsp;
import com.embryoai.acloud.entity.SystemPatient;
import com.embryoai.acloud.entity.SystemProcedure;
import com.embryoai.acloud.mapper.SystemPatientMapper;
import com.embryoai.acloud.mapper.SystemProcedureMapper;

@Service
@Transactional
public class PatientService {
	
	private Logger log = LoggerFactory.getLogger(PatientService.class);
	
	@Autowired SystemPatientMapper patientMapper;
	@Autowired SystemProcedureMapper procedureMapper;

	public Object receivePatientInfo(String patientInfo){
		log.info("请求方法:receivePatientInfo<|>参数:" + patientInfo);
		
		SystemPatient patientBaseInfo = null;
		SystemProcedure patientCaseInfo = null;
		try {
			JSONObject dataObject = JSON.parseObject(patientInfo);
			patientBaseInfo = JSON.parseObject(dataObject.getString("patient"), 
					new TypeReference<SystemPatient>() {});
			patientCaseInfo = JSON.parseObject(dataObject.getString("procedure"), 
					new TypeReference<SystemProcedure>() {});
		} catch (Exception e) {
			log.error("数据解析异常:" + patientInfo);
			e.printStackTrace();
		}
		
		try {
			//保存患者基本信息
			patientMapper.insert(patientBaseInfo);
			//保存患者病例信息
			procedureMapper.insert(patientCaseInfo);
		} catch (Exception e) {
			log.error("患者信息保存异常!" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("患者信息保存异常!", e.getMessage());
		}
		
		return Rsp.succ("OK", null);
	}
}
