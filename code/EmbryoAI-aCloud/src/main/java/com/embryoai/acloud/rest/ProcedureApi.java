package com.embryoai.acloud.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.embryoai.acloud.dto.Rsp;
import com.embryoai.acloud.mapper.SystemPatientMapper;
import com.embryoai.acloud.mapper.SystemProcedureMapper;

@RestController
@Transactional
public class ProcedureApi {
	
	private Logger log = LoggerFactory.getLogger(ProcedureApi.class);
	
	@Autowired SystemProcedureMapper proMapper;
	@Autowired SystemPatientMapper patMapper;

	/**
	 * 修改病例信息
	 * @param procedureInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/api/v1.0/updateProcedure")
	public Object updateProcedure(@RequestBody String procedureInfo) {
		log.info("请求方法:receivePatientInfo<|>参数:" + procedureInfo);
		
		Map<String, Object> dataMap = null;
		try {
			dataMap = (Map<String, Object>)JSON.parse(procedureInfo);
		} catch (Exception e) {
			log.error("数据解析异常:" + procedureInfo);
			e.printStackTrace();
		}
		
		try {
			//修改病例备注
			proMapper.updateProcedure(dataMap);
			//修改患者信息
			patMapper.updatePatient(dataMap);
		} catch (Exception e) {
			log.error("患者信息保存异常!" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("患者信息保存异常!", e.getMessage());
		}
		
		return Rsp.succ("OK", null);
	}
}
