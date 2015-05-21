package com.web.aops;

import com.web.vo.ApiResultData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Component
@Aspect
@Slf4j
public class ApiControllerAdvisor {

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    private void apiControllerAdvisor () {}

    @Around("apiControllerAdvisor()")
    public Object wrapResponseObject(ProceedingJoinPoint pjp) throws Throwable {

        try {

            if(log.isInfoEnabled()) {
                Method method = ((MethodSignature) pjp.getSignature()).getMethod();
                RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
                log.info("api result data : " + requestMapping.value()[0]);
            }
            Object ret = pjp.proceed();
            return new ApiResultData(ret);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ApiResultData(ex);
        }
    }
}
