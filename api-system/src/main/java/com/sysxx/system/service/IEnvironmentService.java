package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateEnvironmentData;
import com.sysxx.system.domain.Environment;

import java.util.List;

public interface IEnvironmentService {
    public List<Environment> selectAll();

    public AjaxResult create(CreateEnvironmentData createEnvironmentData);
}
