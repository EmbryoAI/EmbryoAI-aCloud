package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemMilestone;

public interface SystemMilestoneMapper {
    int insert(SystemMilestone record);

    int insertSelective(SystemMilestone record);
}