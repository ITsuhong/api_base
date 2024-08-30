package com.sysxx.common.core.domain;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class TimedClientHttpResponse  implements ClientHttpResponse {
    private final ClientHttpResponse response;
    private final long duration;

    public TimedClientHttpResponse(ClientHttpResponse response, long duration) {
        this.response = response;
        this.duration = duration;
    }
    public long getDuration() {
        return duration;
    }

    @Override
    public InputStream getBody() throws IOException {
        return response.getBody();
    }

    @Override
    public HttpHeaders getHeaders() {
        return response.getHeaders();
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return response.getStatusCode();
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return response.getRawStatusCode();
    }

    @Override
    public String getStatusText() throws IOException {
        return response.getStatusText();
    }

    @Override
    public void close() {
        response.close();
    }
}
