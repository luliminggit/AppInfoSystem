package com.team.appinfo.mapper;

import com.team.appinfo.entity.DevUser;
import com.team.appinfo.entity.DevUserExample;
import java.util.List;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}