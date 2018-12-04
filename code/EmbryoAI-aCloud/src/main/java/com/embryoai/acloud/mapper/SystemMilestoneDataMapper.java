package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemMilestoneData;

public interface SystemMilestoneDataMapper {
    int insert(SystemMilestoneData record);

    int insertSelective(SystemMilestoneData record);
}