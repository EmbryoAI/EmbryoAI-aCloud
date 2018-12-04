package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.AcloudUser;

public interface AcloudUserMapper {
    int insert(AcloudUser record);

    int insertSelective(AcloudUser record);
}