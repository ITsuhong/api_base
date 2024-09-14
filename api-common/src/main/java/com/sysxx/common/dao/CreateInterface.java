package com.sysxx.common.dao;

import lombok.Data;

@Data
public class CreateInterface {
    private Integer id;
    private Integer pid;
    private Integer projectId;
    private Integer userId;
    private Integer directoryId;
    private Integer serviceId;
    private Integer headerId;
    private Integer status;
    private Integer restfulType;
    private String labels;
    private String path;
    private String des;
    private String requestHeader;
    private String params;
    private String body;
    private String responseBody;
    private  String  name;
}
