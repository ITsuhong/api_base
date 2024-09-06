package com.sysxx.common.dao;

import com.sysxx.common.core.domain.entity.ServiceUrlData;
import com.sysxx.common.core.domain.entity.VariableData;
import lombok.Data;

import java.util.List;

@Data
public class CreateEnvironmentData {
    private Integer id;
    private String name;
    private List<VariableData> variableDataList;
    private List<ServiceUrlData> serviceUrlDataList;
    private Integer projectId;
}
