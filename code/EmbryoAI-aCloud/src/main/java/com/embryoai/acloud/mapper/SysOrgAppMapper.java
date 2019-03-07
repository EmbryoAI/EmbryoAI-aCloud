package com.embryoai.acloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.embryoai.acloud.entity.SysOrgApp;

public interface SysOrgAppMapper {
    int insert(SysOrgApp record);

    int insertSelective(SysOrgApp record);

    /**
     *  根据医疗机构 aCloud Id设置医疗机构aCloud Key
     * @param acloudId
     * @param acloudKey
     * @return
     */
	int updateKeyById(@Param("acloudId")String acloudId, @Param("acloudKey")String acloudKey);
	

	/**
	 * 根据医疗机构 aCloud Id、医疗机构aCloud Key查询医疗机构注册应用信息
	 * @param acloudId 
	 * @param acloudKey
	 * @return
	 */
	SysOrgApp selectByAcloudIdAndKey(@Param("acloudId")String acloudId, @Param("acloudKey")String acloudKey);

	/**
	 * 根据机构Id查询机构注册应用信息
	 * @param id
	 * @return
	 */
	SysOrgApp selectByOrgId(@Param("orgId")String id);

	int updateOrgApp(SysOrgApp orgApp);

}