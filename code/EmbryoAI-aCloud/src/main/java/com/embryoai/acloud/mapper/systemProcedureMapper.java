package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.systemProcedure;

public interface systemProcedureMapper {
    int insert(systemProcedure record);

    int insertSelective(systemProcedure record);
}