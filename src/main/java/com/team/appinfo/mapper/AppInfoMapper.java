package com.team.appinfo.mapper;

import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppInfoExample;
import com.team.appinfo.until.PageMeter;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
    /*<!--分页查询-->*/
    List<AppInfo>  getAppInfo(PageMeter pageMeter);

    /*<!--查看app信息-->*/
    public AppInfo getAppInfo1(Long id);

    /*<!--商品下架-->*/
    int soldOut(AppInfo appInfo);

   /* <!--修改回显-->*/
    AppInfo updateShow(Long id);

     /*<!--查询待审核app信息-->*/
    List<AppInfo> getNopassAppInfo(PageMeter pageMeter);
}