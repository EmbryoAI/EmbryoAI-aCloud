package com.embryoai.acloud.mapper;


import org.apache.ibatis.annotations.Param;

import com.embryoai.acloud.entity.SysOrg;

public interface SysOrgMapper {
    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    /**
     * 根据医疗机构名称查询医疗机构及医疗机构注册应用信息
     * @param orgName ： 医疗机构名称
     * @return
     */
	SysOrg selectOrgByName(@Param("orgName")String orgName);

	int updateOrgById(SysOrg org);
}