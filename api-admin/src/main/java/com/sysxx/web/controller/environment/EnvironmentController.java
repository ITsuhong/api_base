package com.sysxx.web.controller.environment;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateEnvironmentData;
import com.sysxx.system.service.impl.EnvironmentServiceImpl;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {
    @Autowired
    EnvironmentServiceImpl environmentService;

    @PostMapping("/create")
    public AjaxResult create(@RequestBody CreateEnvironmentData createEnvironmentData) {
        return environmentService.create(createEnvironmentData);
    }

    @GetMapping("/selectAll")
    public AjaxResult queryAll() {
        return environmentService.selectAll();
    }

    @PostMapping("/update")
    public AjaxResult update(@RequestBody CreateEnvironmentData createEnvironmentData) {
        return environmentService.update(createEnvironmentData);
    }

    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody CreateEnvironmentData createEnvironmentData) {
        return environmentService.delete(createEnvironmentData.getId());
    }
}
