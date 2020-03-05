package com.team.appinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.entity.DevUserExample;
import com.team.appinfo.mapper.DevUserMapper;
import com.team.appinfo.service.DevUserService;
import com.team.appinfo.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser getUser(String userName, String userPassword) {
        DevUserExample devUserExample=new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        criteria.andDevcodeEqualTo(userName);
        criteria.andDevpasswordEqualTo(userPassword);
        List<DevUser> list = devUserMapper.selectByExample(devUserExample);
        if(list!=null&&list.size()==0){
           return null;
        }else {
            return list.get(0); //返回当前用户信息
        }
    }
}
