package com.team.appinfo.service;

import com.team.appinfo.entity.AppCategory;

import java.util.List;

public interface CateGoryService {
    //查询一级分类  通过父类型查询子类型
    public List<AppCategory> getCategoryBeloginType(Long id);
    //查询二级类别
    public List<AppCategory> getCategory2(Long id);
    //查询三级类别
    public List<AppCategory> getCategory3(Long id);

}
