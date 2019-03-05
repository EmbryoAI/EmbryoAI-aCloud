package com.embryoai.acloud.mapper;

import java.util.Map;

import com.embryoai.acloud.entity.SystemProcedure;

public interface SystemProcedureMapper {
    int insert(SystemProcedure record);

    int insertSelective(SystemProcedure record);
    
    void updateProcedure(Map<String, Object> map);
}