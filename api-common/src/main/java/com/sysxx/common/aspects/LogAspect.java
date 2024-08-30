package com.sysxx.common.aspects;

import com.alibaba.fastjson.JSON;
import com.sysxx.common.annotations.PrintlnLog;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LogAspect {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Pointcut(value = "@annotation(com.sysxx.common.annotations.PrintlnLog) || @within(com.sysxx.common.annotations.PrintlnLog)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String methodDetailDescription = this.getAspectMethodLogDescJP(joinPoint);

        log.info("------------------------------- start --------------------------");
        /**
         * 打印自定义方法描述
         */
        log.info("Method detail Description: {}", methodDetailDescription);
        /**
         * 打印请求入参
         */
        log.info("Request Args: {}", JSON.toJSONString(joinPoint.getArgs()));
        /**
         * 打印请求方式
         */
        log.info("Request method: {}", request.getMethod());
        /**
         * 打印请求 url
         */
        log.info("Request URL: {}", request.getRequestURL().toString());

        /**
         * 打印调用方法全路径以及执行方法
         */
        log.info("Request Class and Method: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    public String getAspectMethodLogDescJP(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * @param proceedingJoinPoint
     * @author xiaofu
     * @description @PrintlnLog 注解作用的切面方法详细细信息
     * @date 2020/7/15 10:34
     */
    public String getAspectMethodLogDescPJ(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        String targetName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * @param targetName
     * @param methodName
     * @param arguments
     * @author xiaofu
     * @description 自定义注解参数
     * @date 2020/7/15 11:51
     */
    public String getAspectMethodLogDesc(String targetName, String methodName, Object[] arguments) throws Exception {
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(PrintlnLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}
