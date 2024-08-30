package com.sysxx.system.mapper;

import com.sysxx.system.domain.Environment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvironmentMapper {
    public List<Environment> selectAll();

    public int createEnvironment(Environment environment);
}
