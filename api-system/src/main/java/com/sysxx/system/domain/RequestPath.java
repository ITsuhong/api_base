package com.sysxx.system.domain;

import com.sysxx.common.enumeration.RequestTypeEnum;
import lombok.Data;

@Data
public class RequestPath {
    private RequestTypeEnum requestType;
    private String path;

}
