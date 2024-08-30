package com.sysxx.web.controller.adminUser;

import com.sysxx.common.annotations.PrintlnLog;
import com.sysxx.common.core.controller.BaseController;
import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.core.page.TableDataInfo;
import com.sysxx.system.domain.AdminUser;
import com.sysxx.system.domain.RequestPath;
import com.sysxx.system.service.impl.AdminUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class AdminUserController extends BaseController {
    @Autowired
    AdminUserServiceImpl adminUserService;

    //    @PreAuthorize("ss.hasPermi('字符串')")
    @PrintlnLog(description = "AdminUserController")
    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public TableDataInfo getList() {
        startPage();
        List<AdminUser> adminUserList = adminUserService.selectList();
        return getDataTable(adminUserList);
    }

    @PostMapping("/test")
    public AjaxResult test(@RequestBody RequestPath requestPath) {
        System.out.println(requestPath + "路径");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(requestPath.getPath(), String.class);
        System.out.println();
        return AjaxResult.success(forEntity);
    }

}
