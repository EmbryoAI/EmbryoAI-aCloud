package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.systemUser;

public interface systemUserMapper {
    int insert(systemUser record);

    int insertSelective(systemUser record);
}