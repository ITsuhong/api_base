package com.sysxx.system.mapper;

import com.sysxx.system.domain.Variable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VariableMapper {
    public void createListVariable(List<Variable> variableList);
}
