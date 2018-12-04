package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemFeedback;

public interface SystemFeedbackMapper {
    int insert(SystemFeedback record);

    int insertSelective(SystemFeedback record);
}