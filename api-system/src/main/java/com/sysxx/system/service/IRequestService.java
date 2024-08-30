package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.RequestData;

public interface IRequestService {
    public AjaxResult GetaX(RequestData requestData);

    public AjaxResult PostaX(RequestData requestData);
}
