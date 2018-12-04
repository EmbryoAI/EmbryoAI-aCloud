package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemUser;

public interface SystemUserMapper {
    int insert(SystemUser record);

    int insertSelective(SystemUser record);
}