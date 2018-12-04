package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SysOrgApp;

public interface SysOrgAppMapper {
    int insert(SysOrgApp record);

    int insertSelective(SysOrgApp record);
}