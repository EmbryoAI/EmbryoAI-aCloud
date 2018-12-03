package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.systemPatient;

public interface systemPatientMapper {
    int insert(systemPatient record);

    int insertSelective(systemPatient record);
}