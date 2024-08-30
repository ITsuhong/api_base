package com.sysxx.system.service.impl;

import com.sysxx.system.domain.AdminUser;
import com.sysxx.system.mapper.AdminUserMapper;
import com.sysxx.system.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements IAdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public List<AdminUser> selectList() {
        List<AdminUser> adminUserList = adminUserMapper.selectAdminUser();
        return adminUserList;
    }
}
