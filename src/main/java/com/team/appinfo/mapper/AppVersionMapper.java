package com.team.appinfo.mapper;

import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.entity.AppVersionExample;
import java.util.List;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    /* <!--查询App历史版本信息-->*/
    List<AppVersion> getAppVersion(Long appid);

   /* <!--最新版本app信息-->*/
   AppVersion newsAppVersion(Long appid);

    /*<!--删除app版本信息-->*/
     int deleteAppVersion(Long appid);


}