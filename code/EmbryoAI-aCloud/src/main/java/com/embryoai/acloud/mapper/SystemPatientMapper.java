package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemPatient;

public interface SystemPatientMapper {
    int insert(SystemPatient record);

    int insertSelective(SystemPatient record);
}