package com.nyf.test.mapper;

import com.nyf.test.model.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}