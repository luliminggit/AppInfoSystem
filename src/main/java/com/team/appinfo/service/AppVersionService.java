package com.team.appinfo.service;

import com.team.appinfo.entity.AppVersion;

import java.util.List;

public interface AppVersionService {
     //查询版本号
    public List<AppVersion> getAppVersion(Long appid);

    //添加
    public int addAppVersion(AppVersion appVersion);


    //修改回显

    public AppVersion getOneAppVersion(Long id);


    //修改信息
    public int updateAppVersion(AppVersion appVersion);

    //查看最新App版本信息
    public AppVersion newsAppVersion(Long id);








}
