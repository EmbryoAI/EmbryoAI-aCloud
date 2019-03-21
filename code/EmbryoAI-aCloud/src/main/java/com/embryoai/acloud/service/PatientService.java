package com.embryoai.acloud.service;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

	/**
	 * 保存用户信息,周期信息
	 * @param patientInfo
	 * @return
	 */
	public Object savePatientInfo(String patientInfo){
		log.info("请求方法:savePatientInfo<|>参数:" + patientInfo);
		
		SystemPatient patientBaseInfo = null;
		SystemProcedure patientCaseInfo = null;
		try {
			JSONObject dataObject = JSON.parseObject(patientInfo);
			patientBaseInfo = dataObject.getObject("patient", SystemPatient.class);
			patientCaseInfo = dataObject.getObject("procedure", SystemProcedure.class);
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
	
	/**
	 * 修改患者信息
	 * @param procedureInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object updatePatientInfo(@RequestBody String patientInfo) {
		log.info("请求方法:updatePatientInfo<|>参数:" + patientInfo);
		
		Map<String, Object> dataMap = null;
		try {
			dataMap = (Map<String, Object>)JSON.parse(patientInfo);
		} catch (Exception e) {
			log.error("数据解析异常:" + patientInfo);
			e.printStackTrace();
		}
		
		try {
			//修改病例备注
			procedureMapper.updateProcedure(dataMap);
			//修改患者信息
			patientMapper.updatePatient(dataMap);
		} catch (Exception e) {
			log.error("患者信息保存异常!" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("患者信息保存异常!", e.getMessage());
		}
		
		return Rsp.succ("OK", null);
	}
}
