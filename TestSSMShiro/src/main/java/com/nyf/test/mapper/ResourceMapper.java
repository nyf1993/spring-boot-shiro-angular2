package com.nyf.test.mapper;

import com.nyf.test.model.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> findResouceByUserId(int userId);
}