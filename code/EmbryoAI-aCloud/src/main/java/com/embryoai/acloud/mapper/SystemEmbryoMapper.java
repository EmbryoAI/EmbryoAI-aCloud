package com.embryoai.acloud.mapper;

import com.embryoai.acloud.entity.SystemEmbryo;

public interface SystemEmbryoMapper {
    int insert(SystemEmbryo record);

    int insertSelective(SystemEmbryo record);
}