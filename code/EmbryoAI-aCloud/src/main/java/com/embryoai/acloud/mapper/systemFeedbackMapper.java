package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.systemFeedback;

public interface systemFeedbackMapper {
    int insert(systemFeedback record);

    int insertSelective(systemFeedback record);
}