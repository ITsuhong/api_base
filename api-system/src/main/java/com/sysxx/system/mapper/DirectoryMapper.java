package com.sysxx.system.mapper;

import com.sysxx.system.domain.Directory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DirectoryMapper {
    public int createDirectory(Directory directory);

    public List<Directory> selectAll();
}
