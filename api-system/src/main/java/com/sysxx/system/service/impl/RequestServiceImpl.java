package com.sysxx.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sysxx.common.core.domain.AjaxResult;
import com.sysxx.common.dao.ResponseData;
import com.sysxx.common.enumeration.RequestTypeEnum;
import com.sysxx.common.utils.RestTemplateUtil;
import com.sysxx.common.dao.RequestData;
import com.sysxx.system.service.IRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RequestServiceImpl implements IRequestService {
    @Autowired
    RestTemplateUtil restTemplateUtil;

    @Override
    public AjaxResult GetaX(RequestData requestData) {
        System.out.println(requestData.getHeaders()+"请求头111");
        String path = requestData.getPath();
        RequestTypeEnum method = requestData.getRequestType();

//        Map<String, Object> params = new HashMap<>();
//        params.put("pageNum", "1");
//        params.put("pageSize", "1");
        ResponseData responseData = RestTemplateUtil.sendHttp(path, method, requestData.getParams(), null, "NONE", requestData.getHeaders());
        responseData.setRequestData(requestData);
        return AjaxResult.success(responseData);
    }

    @Override
    public AjaxResult PostaX(RequestData requestData) {
        String path = requestData.getPath();
        RequestTypeEnum method = requestData.getRequestType();
        String body = requestData.getBodyData() == null ? "" : JSONObject.toJSONString(requestData.getBodyData());

        ResponseData responseData = RestTemplateUtil.sendHttp(path, method, null, body, "JSON", requestData.getHeaders());
        responseData.setRequestData(requestData);
        return AjaxResult.success(responseData);
    }
}
