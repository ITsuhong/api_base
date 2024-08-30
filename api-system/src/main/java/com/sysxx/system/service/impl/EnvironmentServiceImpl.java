package com.sysxx.system.service.impl;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.CreateEnvironmentData;
import com.sysxx.common.dao.VariableData;
import com.sysxx.system.domain.Environment;
import com.sysxx.system.domain.Variable;
import com.sysxx.system.mapper.EnvironmentMapper;
import com.sysxx.system.mapper.VariableMapper;
import com.sysxx.system.service.IEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class EnvironmentServiceImpl implements IEnvironmentService {
    @Autowired
    EnvironmentMapper environmentMapper;
    VariableMapper variableMapper;

    @Override
    public List<Environment> selectAll() {
        return environmentMapper.selectAll();
    }

    @Transactional
    @Override
    public AjaxResult create(CreateEnvironmentData createEnvironmentData) {
//        System.out.println(createEnvironmentData.toString());
        Environment environment = new Environment();
        environment.setName(createEnvironmentData.getName());
        environment.setUserId(1);
        environment.setUserName("用户1");
        environment.setProjectId(createEnvironmentData.getProjectId());
        environmentMapper.createEnvironment(environment);
        System.out.println(createEnvironmentData.getVariableDataList() + "这是什么");
        List<Variable> variables = new LinkedList<>();
        for (VariableData variableData : createEnvironmentData.getVariableDataList()) {
            Variable variable = new Variable();
            variable.setName(variableData.getName());
            variable.setValue(variableData.getValue());
            variable.setDescription(variableData.getDescription());
//            variable.setEnvironmentId(variableData.getEnvironmentId());
            variable.setEnvironmentId(environment.getId());
            variables.add(variable);
        }
//        for (Variable variable:createEnvironmentData.getVariableList())
        System.out.println(variables + "这是什么");
        variableMapper.createListVariable(variables);
        return AjaxResult.success();
    }
}
