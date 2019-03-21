package com.embryoai.acloud.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.embryoai.acloud.common.config.ParamConfig;
import com.embryoai.acloud.common.util.MinioUtil;
import com.embryoai.acloud.dto.BaseResult;
import com.embryoai.acloud.dto.Rsp;
import com.embryoai.acloud.entity.SysOrg;
import com.embryoai.acloud.entity.SysOrgApp;
import com.embryoai.acloud.mapper.SysOrgAppMapper;
import com.embryoai.acloud.mapper.SysOrgMapper;

@Service
@Transactional
public class OrganizationService {

	private Logger log = LoggerFactory.getLogger(OrganizationService.class);

	@Autowired
	private SysOrgMapper orgMapper;

	@Autowired
	private SysOrgAppMapper orgAppMapper;

	@Resource
	private ParamConfig paramConfig;

	public BaseResult registeredToCloud(String data){
		log.info("请求方法:registeredToCloud<|>参数:" + data);
//		Map<String,Object> res = new HashMap<>();
		SysOrg org = null;
		SysOrgApp orgApp = null;
		try {
			org = JSON.parseObject(data, SysOrg.class);
			orgApp = JSON.parseObject(data, SysOrgApp.class);
			
//			if(StringUtils.isBlank(org.getOrgAddress())) {
//				log.info("机构地址不能为空");
//				return Rsp.fail("医院地址不能为空！", "");
//			}
//			if(StringUtils.isBlank(org.getOrgDepartment())) {
//				log.info("科室/医疗中心不能为空");
//				return Rsp.fail("科室/医疗中心不能为空！", "");
//			}
//			if(StringUtils.isBlank(org.getOrgName())) {
//				log.info("机构名称不能为空");
//				return Rsp.fail("机构名称不能为空！", "");
//			}
			if(StringUtils.isBlank(orgApp.getAcloudId()) || StringUtils.isBlank(orgApp.getAcloudKey())) {
				log.info("医疗机构aCloud ID、医疗机构aCloud Key不能为空！");
				return Rsp.fail("医疗机构aCloud ID、医疗机构aCloud Key不能为空！", "");
			}
			if(StringUtils.isBlank(orgApp.getS3Username()) || StringUtils.isBlank(orgApp.getS3Password())) {
				log.info("minio用户名、密钥不能为空！");
				return Rsp.fail("minio用户名、密钥不能为空！", "");
			}
			//验证acloudId及acloudKey
			SysOrgApp oApp = orgAppMapper.selectByAcloudIdAndKey(orgApp.getAcloudId(),orgApp.getAcloudKey());
			if(oApp == null) {
				log.info("医疗机构aCloud ID和医疗机构aCloud Key无效！");
				return Rsp.fail("医疗机构aCloud ID和医疗机构aCloud Key无效！", "");
			}
			if(StringUtils.isNotEmpty(oApp.getS3Username())) {
				log.info("此医疗机构已注册到云端，不能重复注册！");
				return Rsp.fail("此医疗机构已注册到云端，不能重复注册！", "");
			}
			
			boolean minioFlag = MinioUtil.createMinioUser(paramConfig, orgApp.getS3Username(), orgApp.getS3Password());
			if(!minioFlag) {
				log.info("在minio上创建用户失败，请联系管理员");
				return Rsp.fail("在minio上创建用户失败，请联系管理员。", "");
			}
			
			org.setId(oApp.getOrgId());
			org.setDelFlag("0");
			org.setUpdateTime(new Date());
			int i = orgMapper.updateOrgById(org);
			
			orgApp.setOrgId(oApp.getOrgId());
			int j = orgAppMapper.updateOrgApp(orgApp);
		
			if(i > 0 && j > 0) {
				log.info("机构注册到云端成功");
				return Rsp.succ("注册到云端成功！", JSON.toJSONString(orgApp));
			} else {
				log.info("机构注册到云端失败");
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return Rsp.fail("机构注册到云端失败，请重试。", "");
			}
		} catch (Exception e) {
			log.error("注册到云端异常!" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("注册到云端异常!", e.getMessage());
		}
		
		
		
	}

	@SuppressWarnings("null")
	public BaseResult createKey(String data) {
		log.info("请求方法:createKey<|>参数:" + data);
		Map<String, String> res = new HashMap<>();
		SysOrg org = null;
		try {
			org = JSON.parseObject(data, SysOrg.class);
			if (StringUtils.isBlank(org.getOrgName())) {
				log.info("机构名称不能为空");
				return Rsp.fail("机构名称不能为空！", "");
			}
			// if (StringUtils.isBlank(org.getOrgAddress())) {
			// log.info("机构地址不能为空");
			// return Rsp.fail("医院地址不能为空！", "");
			// }
			// if (StringUtils.isBlank(org.getOrgDepartment())) {
			// log.info("科室/医疗中心不能为空");
			// return Rsp.fail("科室/医疗中心不能为空！", "");
			// }
			SysOrg orgInfo = orgMapper.selectOrgByName(org.getOrgName());
			String orgId = UUID.randomUUID().toString().replaceAll("-", "");
			String key = UUID.randomUUID().toString().replaceAll("-", "");
			String aCloudId = UUID.randomUUID().toString().replaceAll("-", "");
			if (orgInfo == null) {
				org.setId(orgId);
				org.setDelFlag("1");
				orgMapper.insertSelective(org);

				SysOrgApp soa = new SysOrgApp();
				soa.setAcloudId(aCloudId);
				soa.setOrgId(org.getId());
				soa.setAcloudKey(key);
				orgAppMapper.insertSelective(soa);
				
				res.put("aCloudId", soa.getAcloudId());
				res.put("aCloudKey", soa.getAcloudKey());
				return Rsp.succ("成功生成云端有效的账号及密钥信息", res);

			}
			if ("0".equals(orgInfo.getDelFlag())) {
				log.info("此机构已注册到云端，无需再获取云端有效账号及密钥信息。");
				return Rsp.fail("此机构已注册到云端，无需再获取云端有效账号及密钥信息。", "");
			}
			SysOrgApp oa = orgAppMapper.selectByOrgId(orgInfo.getId());
			if (oa == null) {
				oa.setAcloudId(aCloudId);
				oa.setOrgId(org.getId());
				oa.setAcloudKey(key);
				orgAppMapper.insertSelective(oa);
			}
			res.put("aCloudId", oa.getAcloudId());
			res.put("aCloudKey", oa.getAcloudKey());
			return Rsp.succ("成功生成云端有效key值", res);
		} catch (Exception e) {
			log.error("获取云端医疗机构aCloud Key出现异常!" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Rsp.err("获取云端医疗机构aCloud Key出现异常!", e.getMessage());
		}
	}
}
