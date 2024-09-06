package com.sysxx.system.mapper;

import com.sysxx.system.domain.Variable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VariableMapper {
    public void createListVariable(List<Variable> variableList);

    public void createVariable(Variable variable);

    public List<Variable> selectGlobal();

    public void delete(Integer id);

    public void update(Variable variable);

    public void deleteAllGlo();
}
