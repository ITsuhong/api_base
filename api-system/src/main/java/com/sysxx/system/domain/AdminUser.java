package com.sysxx.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private Integer administrator;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer version;
    private Integer roleId;

}
