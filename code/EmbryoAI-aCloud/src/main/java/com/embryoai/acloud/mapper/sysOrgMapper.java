package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.sysOrg;

public interface sysOrgMapper {
    int insert(sysOrg record);

    int insertSelective(sysOrg record);
}