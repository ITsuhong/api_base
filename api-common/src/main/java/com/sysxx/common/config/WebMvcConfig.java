package com.sysxx.common.config;

import com.sysxx.common.aspects.LogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAspectJAutoProxy
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LogAspect logAspect;


}
