package com.sysxx.common.dao;

import com.sysxx.common.dao.RequestData;
import lombok.Data;

@Data
public class ResponseData {
    private Object body;
    private Object headers;
    private Integer statusCodeValue;
    private long duration;
    private Object requestHeaders;
    private RequestData requestData;
}
