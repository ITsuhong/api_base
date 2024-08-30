package com.sysxx.web.controller.environment;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateEnvironmentData;
import com.sysxx.system.service.impl.EnvironmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {
    @Autowired
    EnvironmentServiceImpl environmentService;

    @PostMapping("/create")
    public AjaxResult create(@RequestBody CreateEnvironmentData createEnvironmentData) {
        return environmentService.create(createEnvironmentData);
    }
}
