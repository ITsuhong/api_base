package com.sysxx.system.mapper;

import com.sysxx.system.domain.Interface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterfaceMapper {
    public void createInterface(Interface i);

    public List<Interface> selectInterface();
}
