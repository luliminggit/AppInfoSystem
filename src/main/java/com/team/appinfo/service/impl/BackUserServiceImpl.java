package com.team.appinfo.service.impl;

import com.team.appinfo.entity.BackendUser;
import com.team.appinfo.mapper.BackendUserMapper;
import com.team.appinfo.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BackUserServiceImpl implements BackUserService {

    @Autowired
    private BackendUserMapper backendUserMapper;


    /**
     * 后台用户登录
     * @param backendUser
     * @return
     */
    @Override
    public BackendUser getBackendUser(BackendUser backendUser) {
        return backendUserMapper.getBackendUser(backendUser);
    }
}
