package com.sysxx.common.core.domain.entity;

import lombok.Data;

@Data
public class ServiceUrlData {
    private Integer id;
    private String name;
    private String url;
    private Integer environmentId;
}
