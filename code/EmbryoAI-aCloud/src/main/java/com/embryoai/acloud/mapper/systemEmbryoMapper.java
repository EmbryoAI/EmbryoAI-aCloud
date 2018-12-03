package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.systemEmbryo;

public interface systemEmbryoMapper {
    int insert(systemEmbryo record);

    int insertSelective(systemEmbryo record);
}