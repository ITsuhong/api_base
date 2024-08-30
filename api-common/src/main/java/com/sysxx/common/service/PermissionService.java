package com.sysxx.common.service;


import org.springframework.stereotype.Service;

@Service("ss")
public class PermissionService {
    public boolean hasPermi(String permission) {
        System.out.println("这是权限");
        return true;
    }
}
