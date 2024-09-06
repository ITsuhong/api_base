package com.sysxx.system.service.impl;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.system.domain.Variable;
import com.sysxx.system.mapper.VariableMapper;
import com.sysxx.system.service.IVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariableServiceImpl implements IVariableService {
    @Autowired
    VariableMapper variableMapper;

    @Transactional
    @Override
    public AjaxResult createGlobal(List<Variable> variables) {
        variableMapper.deleteAllGlo();
        variableMapper.createListVariable(variables);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult selectGlobal() {
        List<Variable> variables = variableMapper.selectGlobal();
        return AjaxResult.success(variables);
    }

}
