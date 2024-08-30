package com.sysxx.common.dao;

import lombok.Data;

import java.util.List;

@Data
public class CreateEnvironmentData {
    private String name;
    private List<VariableData> variableDataList;
    private Integer projectId;
}
