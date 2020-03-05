package com.team.appinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.mapper.AppInfoMapper;
import com.team.appinfo.mapper.AppVersionMapper;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
 class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private AppVersionMapper appVersionMapper;

    /**
     * 分页查询
     * @param pageMeter
     * @return
     */
    @Override
    public PageInfo<AppInfo> getAppInfo(PageMeter pageMeter) {
        PageHelper.startPage(pageMeter.getPage(), pageMeter.getPageSize());
        List<AppInfo> list = appInfoMapper.getAppInfo(pageMeter);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 添加
     * @param appInfo
     * @return
     */
    @Override
    public int AddAppinfo(AppInfo appInfo) {
        return appInfoMapper.insertSelective(appInfo);
    }

    /**
     * 修改回显查单条
     * @param id
     * @return
     */
    @Override
    public AppInfo getOneAppinfo(long id) {
        return appInfoMapper.updateShow(id);
    }

    /**
     * 修改单条信息
     * @param appInfo
     * @return
     */
    @Override
    public int updateAppinfo(AppInfo appInfo) {
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

    /**
     *  查询单条app信息
     * @param id
     * @return
     */
    @Override
    public AppInfo getAppinfo1(Long id) {
        return appInfoMapper.getAppInfo1(id);
    }

    /**
     * 商品下架
     * @param appInfo
     * @return
     */
    @Override
    public int soldOut(AppInfo appInfo) {
        return appInfoMapper.soldOut(appInfo);
    }


    /**
     * 删除app信息
     * @param id
     * @return
     */
    @Transactional
    public int deleteAppInfo(Long id) {
        //思路:选删除外键表的信息，再删除主键表的信息

        //实现删除app对应的版本信息
        appVersionMapper.deleteAppVersion(id);

        //实现删除app信息
        appInfoMapper.deleteByPrimaryKey(id);
        return 1;
    }

    /**
     * 查询待审核app信息
     * @param pageMeter
     * @return
     */
    @Override
    public PageInfo<AppInfo> getNoPassAppinfo(PageMeter pageMeter) {
        PageHelper.startPage(pageMeter.getPage(), pageMeter.getPageSize());
        List<AppInfo> list = appInfoMapper.getNopassAppInfo(pageMeter);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 修改App状态
     * @param appid
     * @param status
     * @return
     */
    @Override
    public int updateAppInfoState(Long appid, Long status) {
        AppInfo appInfo=new AppInfo();
        appInfo.setId(appid);
        appInfo.setStatus(status);

        return  appInfoMapper.updateByPrimaryKeySelective(appInfo);

    }


}
