package com.sysxx.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Environment {
    private Integer id;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String name;
    private Integer userId;
    private String  userName;
    private Integer projectId;
}
