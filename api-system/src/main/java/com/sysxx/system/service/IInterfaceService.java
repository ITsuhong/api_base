package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateInterface;
import com.sysxx.system.domain.Interface;

public interface IInterfaceService {
    public AjaxResult CreateInterface(CreateInterface createInterface);

    public AjaxResult selectInterface();

    public AjaxResult detailInterface(Integer id);

    public AjaxResult deleteInterface(Integer id);

    public AjaxResult updateInterface(CreateInterface interfaces);
}
