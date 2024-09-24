package com.sysxx.common.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

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
    private String name;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date updateTime;
}
