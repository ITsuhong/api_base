package com.sysxx.system.service.impl;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateInterface;
import com.sysxx.system.domain.Interface;
import com.sysxx.system.mapper.InterfaceMapper;
import com.sysxx.system.service.IInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IInterfaceServiceImpl implements IInterfaceService {
    @Autowired
    InterfaceMapper interfaceMapper;

    @Override
    public AjaxResult CreateInterface(CreateInterface createInterface) {
        Interface interfaces = new Interface();
        interfaces.setId(createInterface.getId());
        interfaces.setPid(createInterface.getPid());
        interfaces.setProjectId(createInterface.getProjectId());
        interfaces.setUserId(createInterface.getUserId());
        interfaces.setDirectoryId(createInterface.getDirectoryId());
        interfaces.setServiceId(createInterface.getServiceId());
        interfaces.setHeaderId(createInterface.getHeaderId());
        interfaces.setStatus(createInterface.getStatus());
        interfaces.setRestfulType(createInterface.getRestfulType());
        interfaces.setLabels(createInterface.getLabels());
        interfaces.setPath(createInterface.getPath());
        interfaces.setDes(createInterface.getDes());
        interfaces.setRequestHeader(createInterface.getRequestHeader());
        interfaces.setParams(createInterface.getParams());
        interfaces.setBody(createInterface.getBody());
        interfaces.setResponseBody(createInterface.getResponseBody());

        interfaceMapper.createInterface(interfaces);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectInterface() {
        List<Interface> interfaces = interfaceMapper.selectInterface();
        return AjaxResult.success(interfaces);
    }
}
