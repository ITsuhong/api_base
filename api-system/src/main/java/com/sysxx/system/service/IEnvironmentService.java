package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateEnvironmentData;

public interface IEnvironmentService {
    public AjaxResult selectAll();

    public AjaxResult create(CreateEnvironmentData createEnvironmentData);

    public AjaxResult update(CreateEnvironmentData createEnvironmentData);
    public  AjaxResult delete(Integer id);
}
