package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemRule;

public interface SystemRuleMapper {
    int insert(SystemRule record);

    int insertSelective(SystemRule record);
}