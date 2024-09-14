package com.sysxx.system.domain;

import lombok.Data;

@Data
public class Directory {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer serviceId;
    private Integer projectId;
    private String des;
}
