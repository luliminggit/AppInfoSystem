package com.team.appinfo.mapper;

import com.team.appinfo.entity.BackendUser;
import com.team.appinfo.entity.BackendUserExample;
import com.team.appinfo.entity.DataDictionary;

import java.util.List;

public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectByExample(BackendUserExample example);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);

     BackendUser getBackendUser(BackendUser backendUser);


}