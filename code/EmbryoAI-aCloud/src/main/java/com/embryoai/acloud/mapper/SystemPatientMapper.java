package com.embryoai.acloud.mapper;

import java.util.Map;

import com.embryoai.acloud.entity.SystemPatient;

public interface SystemPatientMapper {
    int insert(SystemPatient record);

    int insertSelective(SystemPatient record);
    
    void updatePatient(Map<String, Object> map);
}