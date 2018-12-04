package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SysOrg;

public interface SysOrgMapper {
    int insert(SysOrg record);

    int insertSelective(SysOrg record);
}