package com.sysxx.common.dao;

import lombok.Data;

@Data
public class CreateDirectory {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer serviceId;
    private Integer projectId;
    private String des;
}
