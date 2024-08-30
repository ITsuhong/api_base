package com.sysxx.system.mapper;

import com.sysxx.system.domain.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminUserMapper {
    public List<AdminUser> selectAdminUser();
}
