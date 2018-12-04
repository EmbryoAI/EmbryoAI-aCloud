package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SysLocation;

public interface SysLocationMapper {
    int insert(SysLocation record);

    int insertSelective(SysLocation record);
}