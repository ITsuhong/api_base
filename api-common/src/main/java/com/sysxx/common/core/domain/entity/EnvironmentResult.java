package com.sysxx.common.core.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EnvironmentResult {
    private Integer id;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String name;
    private Integer userId;
    private String userName;
    private Integer projectId;
    private List<VariableData> variableDataList;
    private List<ServiceUrlData> serviceUrlDataList;

}
