package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.sysLocation;

public interface sysLocationMapper {
    int insert(sysLocation record);

    int insertSelective(sysLocation record);
}