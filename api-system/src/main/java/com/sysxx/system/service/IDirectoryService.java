package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateDirectory;
import com.sysxx.system.domain.Directory;

public interface IDirectoryService {
    public AjaxResult createDirectory(CreateDirectory directory);

    public AjaxResult selectAll();
}
