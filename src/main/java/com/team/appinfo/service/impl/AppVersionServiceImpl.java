package com.team.appinfo.service.impl;

import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.mapper.AppInfoMapper;
import com.team.appinfo.mapper.AppVersionMapper;
import com.team.appinfo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Autowired
    protected AppInfoMapper appInfoMapper;


    @Override
    public List<AppVersion> getAppVersion(Long appid) {
        return appVersionMapper.getAppVersion(appid);
    }

    /**
     * 添加App版本信息
     * @param appVersion
     * @return
     */
    @Override
    public int addAppVersion(AppVersion appVersion) {
        return appVersionMapper.insertSelective(appVersion);
    }

    @Override
    public AppVersion getOneAppVersion(Long id) {
        return appVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateAppVersion(AppVersion appVersion) {
        return appVersionMapper.updateByPrimaryKeySelective(appVersion);
    }

    /**
     * 查询最新版本app信息
     * @param id
     * @return
     */
    @Override
    public AppVersion newsAppVersion(Long id) {
        return appVersionMapper.newsAppVersion(id);
    }


}
