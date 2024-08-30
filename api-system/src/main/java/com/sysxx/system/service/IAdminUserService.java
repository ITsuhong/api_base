package com.sysxx.system.service;

import com.sysxx.system.domain.AdminUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAdminUserService {
    public List<AdminUser> selectList();

}
