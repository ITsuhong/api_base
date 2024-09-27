package com.sysxx.web.controller.request;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateInterface;
import com.sysxx.common.enumeration.RequestTypeEnum;
import com.sysxx.common.dao.RequestData;
import com.sysxx.system.service.impl.IInterfaceServiceImpl;
import com.sysxx.system.service.impl.RequestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
@Slf4j
public class requestController {
    @Autowired
    RequestServiceImpl requestService;
    @Autowired
    IInterfaceServiceImpl iInterfaceService;


    @PostMapping
    public AjaxResult getRequest(@RequestBody RequestData requestData) {
        if (requestData.getRequestType().equals(RequestTypeEnum.POST)) {
            return requestService.PostaX(requestData);
        }
        return requestService.GetaX(requestData);

    }

    @PostMapping("/create_interface")
    public AjaxResult createInterface(@RequestBody CreateInterface createInterface) {
        return iInterfaceService.CreateInterface(createInterface);
    }

    @PostMapping("/update_interface")
    public AjaxResult updateInterface(@RequestBody CreateInterface requestData) {
        return iInterfaceService.updateInterface(requestData);
    }

    @GetMapping("/select_interface")
    public AjaxResult selectInterface() {
        return iInterfaceService.selectInterface();
    }

    @GetMapping("/detail_interface")
    public AjaxResult detailInterface(@RequestParam("id") Integer id) {
        return iInterfaceService.detailInterface(id);
    }

    @GetMapping("/delete_interface")
    public AjaxResult deleteInterface(@RequestParam("id") Integer id) {
        return iInterfaceService.deleteInterface(id);
    }
}
