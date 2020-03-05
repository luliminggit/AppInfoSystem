package com.team.appinfo.service.impl;

import com.team.appinfo.entity.AppCategory;
import com.team.appinfo.entity.AppCategoryExample;
import com.team.appinfo.mapper.AppCategoryMapper;
import com.team.appinfo.mapper.AppInfoMapper;
import com.team.appinfo.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateGoryServiceImpl implements CateGoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> getCategoryBeloginType(Long id) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        if (id == null) {
            //为空查询一级分类
            criteria.andParentidIsNull();
        } else {
            //不为空查询分类下的子分类
            criteria.andParentidEqualTo(id);
        }
        return appCategoryMapper.selectByExample(appCategoryExample);
    }

    @Override
    public List<AppCategory> getCategory2(Long id) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andParentidEqualTo(id);
        return appCategoryMapper.selectByExample(appCategoryExample);
    }

    @Override
    public List<AppCategory> getCategory3(Long id) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andParentidEqualTo(id);
        return appCategoryMapper.selectByExample(appCategoryExample);
    }
}
