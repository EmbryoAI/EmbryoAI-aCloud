package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.acloudUser;

public interface acloudUserMapper {
    int insert(acloudUser record);

    int insertSelective(acloudUser record);
}