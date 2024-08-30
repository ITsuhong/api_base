package com.sysxx.common.dao;

import com.sysxx.common.enumeration.RequestTypeEnum;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestData {
    private RequestTypeEnum requestType;
    private String path;
    private List<Map<String, Object>> params;
    private Map<String, Object> bodyData;
    private String headers;
}
