package com.sysxx.system.service.impl;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.core.domain.entity.EnvironmentResult;
import com.sysxx.common.dao.CreateEnvironmentData;
import com.sysxx.common.core.domain.entity.ServiceUrlData;
import com.sysxx.common.core.domain.entity.VariableData;
import com.sysxx.system.domain.Environment;
import com.sysxx.system.domain.ServiceUrl;
import com.sysxx.system.domain.Variable;
import com.sysxx.system.mapper.EnvironmentMapper;
import com.sysxx.system.mapper.ServiceUrlMapper;
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
    @Autowired
    VariableMapper variableMapper;

    @Autowired
    ServiceUrlMapper serviceUrlMapper;

    @Override
    public AjaxResult selectAll() {
        List<EnvironmentResult> environments = environmentMapper.selectAllEnvironment();
        return AjaxResult.success(environments);
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

        if (!createEnvironmentData.getServiceUrlDataList().isEmpty()) {
            List<ServiceUrl> serviceUrls = new LinkedList<>();
            for (ServiceUrlData serviceUrlData : createEnvironmentData.getServiceUrlDataList()) {
                ServiceUrl serviceUrl = new ServiceUrl();
                serviceUrl.setUrl(serviceUrlData.getUrl());
                serviceUrl.setName(serviceUrlData.getName());
                serviceUrl.setEnvironmentId(environment.getId());
                serviceUrls.add(serviceUrl);
            }
            serviceUrlMapper.create(serviceUrls);
        }
        if (!createEnvironmentData.getVariableDataList().isEmpty()) {
            List<Variable> variables = new LinkedList<>();
            for (VariableData variableData : createEnvironmentData.getVariableDataList()) {
                Variable variable = new Variable();
                variable.setName(variableData.getName());
                variable.setValue(variableData.getValue());
                variable.setDescription(variableData.getDescription());
                variable.setEnvironmentId(environment.getId());
                variables.add(variable);
            }

            variableMapper.createListVariable(variables);
        }
        return AjaxResult.success();
    }


    @Transactional
    @Override
    public AjaxResult update(CreateEnvironmentData createEnvironmentData) {

        variableMapper.delete(createEnvironmentData.getId());
        serviceUrlMapper.delete(createEnvironmentData.getId());

        List<Variable> variables = new LinkedList<>();
        List<ServiceUrl> serviceUrls = new LinkedList<>();
        for (VariableData variableData : createEnvironmentData.getVariableDataList()) {
            Variable variable = new Variable();
            variable.setName(variableData.getName());
            variable.setValue(variableData.getValue());
            variable.setDescription(variableData.getDescription());
            variable.setEnvironmentId(createEnvironmentData.getId());
            variables.add(variable);
        }
        for (ServiceUrlData serviceUrlData : createEnvironmentData.getServiceUrlDataList()) {
            ServiceUrl serviceUrl = new ServiceUrl();
            serviceUrl.setName(serviceUrlData.getName());
            serviceUrl.setUrl(serviceUrlData.getUrl());
            serviceUrl.setEnvironmentId(createEnvironmentData.getId());
            serviceUrls.add(serviceUrl);

        }
        serviceUrlMapper.create(serviceUrls);
        variableMapper.createListVariable(variables);

        Environment environment = new Environment();
        environment.setName(createEnvironmentData.getName());
        environment.setId(createEnvironmentData.getId());
        environmentMapper.update(environment);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult delete(Integer id) {
        environmentMapper.delete(id);
        return AjaxResult.success();
    }
}
