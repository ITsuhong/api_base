package com.sysxx.system.mapper;

import com.sysxx.system.domain.Interface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterfaceMapper {
    public Integer createInterface(Interface i);

    public  void updateInterface(Interface i);

    public List<Interface> selectInterface();

    public Interface detailInterface(Integer id);

    public void  deleteInterface(Integer id);
}
