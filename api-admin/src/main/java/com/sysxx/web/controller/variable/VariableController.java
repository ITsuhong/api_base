package com.sysxx.web.controller.variable;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.system.domain.Variable;
import com.sysxx.system.service.impl.VariableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/variable")
public class VariableController {
    @Autowired
    VariableServiceImpl variableService;

    @PostMapping("/creatGlobal")
    public AjaxResult creatGlobal(@RequestBody ArrayList<Variable> variables) {
        return variableService.createGlobal(variables);
    }

    @GetMapping("/selectGlobal")
    public AjaxResult select() {
        return variableService.selectGlobal();
    }
}
