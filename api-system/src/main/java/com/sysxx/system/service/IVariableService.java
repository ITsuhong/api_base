package com.sysxx.system.service;

import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.system.domain.Variable;

import java.util.ArrayList;
import java.util.List;

public interface IVariableService {
    public AjaxResult createGlobal(List<Variable> variables);

    public  AjaxResult selectGlobal();


}
