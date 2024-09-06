package com.sysxx.system.mapper;

import com.sysxx.system.domain.Environment;
import com.sysxx.common.core.domain.entity.EnvironmentResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvironmentMapper {
    public List<EnvironmentResult> selectAllEnvironment();

    public int createEnvironment(Environment environment);


    public void update(Environment environment);

    public void delete(Integer id);

}
