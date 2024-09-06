package com.sysxx.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysxx.common.dao.HeaderData;
import com.sysxx.common.dao.ResponseData;
import com.sysxx.common.enumeration.RequestTypeEnum;
import com.sysxx.common.handler.MyRestErrorHandler;
import com.sysxx.common.interceptor.LoggingInterceptor;
import lombok.extern.slf4j.Slf4j;
//import org.apache.http.ssl.SSLContexts;
//import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Andon
 * 2023/3/9
 */
@Slf4j
@Component
public class RestTemplateUtil {

    private static final RestTemplate restTemplate;
    private static final int CONNECT_TIMEOUT = 60 * 1000;
    private static final int READ_TIMEOUT = 60 * 1000;

    static {
        ClientHttpRequestFactory requestFactory = simpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
//        requestFactory.setReadTimeout(READ_TIMEOUT);
        restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(requestFactory);
        restTemplate.getInterceptors().add(new LoggingInterceptor());
        restTemplate.setErrorHandler(new MyRestErrorHandler());
    }


    static public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(15000);
        // 设置代理
        //factory.setProxy(null);
        return factory;
    }

    public static ResponseData sendHttp(String path, RequestTypeEnum method, Map<String, ?> params, String body, String bodyType, String headers) {
        // url拼接params参数
//        path = buildUrlParams(path, params);
        // 请求方式
        HttpMethod httpMethod = HttpMethod.valueOf(String.valueOf(method));
        System.out.println(httpMethod + "请求方式");

        // 构建请求头
        HttpHeaders httpHeaders = buildHttpHeaders(headers, bodyType);
        // 构建请求体
        HttpEntity<?> httpEntity = buildHttpEntity(httpHeaders, body);
        // 发送请求返回响应
        log.info("url:{} httpMethod:{} httpHeaders:{} httpEntity:{}", path, httpMethod, JSONObject.toJSONString(httpHeaders), JSONObject.toJSONString(httpEntity));
        ResponseData responseData = new ResponseData();
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        if (method.equals(RequestTypeEnum.POST)) {
            try {
                ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(path, httpEntity, String.class);

                System.out.println(stringResponseEntity + "haha");
                responseData.setBody(stringResponseEntity.getBody());
                responseData.setHeaders(stringResponseEntity.getHeaders());
                responseData.setStatusCodeValue(stringResponseEntity.getStatusCodeValue());

            } catch (Exception e) {
                System.out.println("进来了");
//                System.out.println(e + "错误");
                throw e;

            }
        }
        if (method.equals(RequestTypeEnum.GET)) {
            try {
                ResponseEntity<String> stringResponseEntity = restTemplate.exchange(path, HttpMethod.GET, httpEntity, String.class);
                responseData.setBody(stringResponseEntity.getBody());
                responseData.setHeaders(stringResponseEntity.getHeaders());
                responseData.setStatusCodeValue(stringResponseEntity.getStatusCodeValue());

            } catch (Exception e) {
                System.out.println(e + "错误");

            }
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 计算响应时间
        long duration = endTime - startTime;
        System.out.println("响应时间2: " + duration + " ms");
        HttpHeaders requestHeaders = LoggingInterceptor.getRequestHeaders();
        System.out.println("请求头: " + requestHeaders);
        responseData.setRequestHeaders(requestHeaders);
        responseData.setDuration(duration);

        LoggingInterceptor.clear();
        return responseData;
    }

    /**
     * url拼接params参数
     */
    private static String buildUrlParams(String url, Map<String, ?> params) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        url = url.replace(" ", "");
        url = url.split("\\?")[0];
        if (ObjectUtils.isEmpty(params)) {
            return url;
        }
        StringBuilder paramsBuilder = new StringBuilder(url);
        paramsBuilder.append("?");
        for (Map.Entry<String, ?> entry : params.entrySet()) {
            paramsBuilder.append(entry.getKey());
            paramsBuilder.append("=");
            paramsBuilder.append(entry.getValue());
            paramsBuilder.append("&");
        }
        paramsBuilder.deleteCharAt(paramsBuilder.length() - 1);
        return paramsBuilder.toString();
    }

    /**
     * 构建请求头
     */
    private static HttpHeaders buildHttpHeaders(String stringHeader, String bodyType) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            ObjectMapper objectMapper = new ObjectMapper();
            // 将 JSON 字符串转换为 List<Map<String, Object>>
            List<HeaderData> list = objectMapper.readValue(stringHeader, new TypeReference<>() {
            });

            for (HeaderData headers : list) {
                if (ObjectUtils.nullSafeEquals(bodyType, BodyTypeEnum.FORM_DATA.toString())) {
                    httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
                } else if (ObjectUtils.nullSafeEquals(bodyType, BodyTypeEnum.JSON.toString())) {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                }
                if (!ObjectUtils.isEmpty(headers)) {
                    httpHeaders.set(headers.getName(), String.valueOf(headers.getValue()));
                }
            }
            return httpHeaders;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 构建请求体
     */
    private static HttpEntity<?> buildHttpEntity(HttpHeaders httpHeaders, String body) {
        if (ObjectUtils.isEmpty(body)) {
            body = "{}";
        }
        if (!ObjectUtils.isEmpty(httpHeaders) && !ObjectUtils.isEmpty(httpHeaders.getContentType())) {
            if (ObjectUtils.nullSafeEquals(httpHeaders.getContentType(), MediaType.MULTIPART_FORM_DATA)) {
                MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
                for (Map.Entry<String, Object> entry : JSONObject.parseObject(body).entrySet()) {
                    formData.add(entry.getKey(), entry.getValue());
                }
                return new HttpEntity<>(formData, httpHeaders);
            } else if (ObjectUtils.nullSafeEquals(httpHeaders.getContentType(), MediaType.APPLICATION_JSON)) {
                return new HttpEntity<>(body, httpHeaders);
            }
        }
        return new HttpEntity<>(body, httpHeaders);
    }

    enum BodyTypeEnum {
        NONE,
        FORM_DATA,
        JSON
    }


}
