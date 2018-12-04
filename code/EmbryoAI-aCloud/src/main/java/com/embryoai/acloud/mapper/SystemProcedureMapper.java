package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemProcedure;

public interface SystemProcedureMapper {
    int insert(SystemProcedure record);

    int insertSelective(SystemProcedure record);
}