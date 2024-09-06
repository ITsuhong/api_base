package com.sysxx.system.mapper;

import com.sysxx.system.domain.ServiceUrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceUrlMapper {
    public int create(List<ServiceUrl> serviceUrls);

    public void delete(Integer id);

    public void update(ServiceUrl serviceUrl);
}
