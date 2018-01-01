package com.nyf.test.mapper;

import com.nyf.test.model.RoleResource;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
}