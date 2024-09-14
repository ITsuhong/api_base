package com.sysxx.system.service.impl;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateDirectory;
import com.sysxx.system.domain.Directory;
import com.sysxx.system.mapper.DirectoryMapper;
import com.sysxx.system.service.IDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDirectoryServiceImpl implements IDirectoryService {
    @Autowired
    DirectoryMapper directoryMapper;

    @Override
    public AjaxResult createDirectory(CreateDirectory createDirectory) {
        Directory directory = new Directory();
        directory.setDes(createDirectory.getDes());
        directory.setServiceId(createDirectory.getServiceId());
        directory.setPid(createDirectory.getPid());
        directory.setName(createDirectory.getName());
        directory.setProjectId(createDirectory.getProjectId());
        directoryMapper.createDirectory(directory);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectAll() {
        List<Directory> directories = directoryMapper.selectAll();
        return AjaxResult.success(directories);
    }
}
