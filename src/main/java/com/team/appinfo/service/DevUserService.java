package com.team.appinfo.service;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.until.PageMeter;

import java.util.List;

public interface DevUserService {

    //登录
    public DevUser getUser(String userName,String userPassword);


}
