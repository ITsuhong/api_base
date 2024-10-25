package com.sysxx.common.config;

import com.sysxx.common.aspects.LogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAspectJAutoProxy
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    @Autowired
    private LogAspect logAspect;

    // 当前跨域请求最大有效时长。这里默认1天
    private static final long MAX_AGE = 24 * 60 * 60;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://123.56.104.248")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(MAX_AGE);
    }


}
