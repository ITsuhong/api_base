package com.sysxx.web.controller.request;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.enumeration.RequestTypeEnum;
import com.sysxx.common.dao.RequestData;
import com.sysxx.system.service.impl.RequestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@Slf4j
public class requestController {
    @Autowired
    RequestServiceImpl requestService;


    @PostMapping
    public AjaxResult getRequest(@RequestBody RequestData requestData) {
        if (requestData.getRequestType().equals(RequestTypeEnum.POST)) {
            return requestService.PostaX(requestData);
        }
        return requestService.GetaX(requestData);

    }
}
