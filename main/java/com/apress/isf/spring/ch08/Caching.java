package com.apress.isf.spring.ch08;

import com.apress.isf.spring.ch02.Type;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sang Jun Park on 11/15/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component
@Aspect
public class Caching {
    private static final Logger log = LoggerFactory.getLogger(Caching.class);
    private static final Map<String, Object> cache = new HashMap<String, Object>();

    @Around("execution(* com.apress.isf.spring.ch08.SearchEngine.*(..))")
    public Object caching(ProceedingJoinPoint pjp) throws Throwable{
        Object result = null;
        Type documentType = null;

        log.debug("@@@(Caching) review if this call is cachable...");
        if("findByType".equals(pjp.getSignature().getName())
        && pjp.getArgs().length == 1
        && pjp.getArgs()[0] instanceof Type){
            documentType = (Type) pjp.getArgs()[0];
            log.debug("@@@(Caching) Is cachable!!");
            if(cache.containsKey(documentType.getName())){
                log.debug("@@@(Caching) Found in Cache!");
                return cache.get(documentType.getName());
            }
            log.debug("@@@(Caching) Not Found! but is cachable!");
            result = pjp.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }
        return pjp.proceed();
    }
}
