package com.sysxx.web.controller.directory;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateDirectory;
import com.sysxx.system.service.impl.IDirectoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directory")
public class DirectoryController {
    @Autowired
    IDirectoryServiceImpl directoryService;

    @GetMapping("/selectAll")
    public AjaxResult selectAll() {
        return directoryService.selectAll();
    }

    @PostMapping("/create")
    public AjaxResult create(@RequestBody CreateDirectory createDirectory) {
        return directoryService.createDirectory(createDirectory);
    }
}
