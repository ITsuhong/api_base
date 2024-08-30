package com.sysxx.common.interceptor;

import com.sysxx.common.core.domain.TimedClientHttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final ThreadLocal<HttpHeaders> requestHeadersHolder = new ThreadLocal<>();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // 使用 ThreadLocal 来存储请求头
        long startTime = System.currentTimeMillis();

        ClientHttpResponse response = execution.execute(request, body);
        long endTime = System.currentTimeMillis();

        // 计算响应时间
        long duration = endTime - startTime;
        requestHeadersHolder.set(request.getHeaders());
//        // 获取响应体大小
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        InputStream is = response.getBody();
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = is.read(buffer)) != -1) {
//            baos.write(buffer, 0, bytesRead);
//        }
//        byte[] responseBody = baos.toByteArray();
//        int responseSize = responseBody.length;
//        System.out.println("响应体大小: " + responseSize + " bytes");

        // 返回响应
        return new TimedClientHttpResponse(response, duration);
    }

    // 提供方法获取 ThreadLocal 中的请求头信息
    public static HttpHeaders getRequestHeaders() {
        return requestHeadersHolder.get();
    }

    // 清理 ThreadLocal 中的数据
    public static void clear() {
        requestHeadersHolder.remove();
    }
}
