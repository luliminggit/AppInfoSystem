package com.team.appinfo.service;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.until.PageMeter;

import java.util.List;

public interface AppInfoService {
    //查询
    public PageInfo<AppInfo> getAppInfo(PageMeter pageMeter);

    //添加
    public int AddAppinfo(AppInfo appInfo);

    //修改回显查单条
    public AppInfo getOneAppinfo(long id);

    //修改单条信息
    public int  updateAppinfo(AppInfo appInfo);


    //查询单条app信息
    public AppInfo getAppinfo1(Long id);


    //下架
    public int soldOut(AppInfo appInfo);

    //删除app信息
    public int deleteAppInfo(Long id);

    ///查询所有待审核app信息
    public PageInfo<AppInfo> getNoPassAppinfo(PageMeter pageMeter);

    //修改App的状态
    public int updateAppInfoState(Long appid,Long status);


}
