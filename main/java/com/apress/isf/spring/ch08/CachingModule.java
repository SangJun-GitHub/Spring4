package com.apress.isf.spring.ch08;

import com.apress.isf.spring.ch02.Type;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sang Jun Park on 11/15/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class CachingModule implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CachingModule.class);
    private static final Map<String, Object> cache = new HashMap<String, Object>();
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        Type documentType = null;

        log.debug("@@@(Caching) review if this call is cachable...");

        if("findByType".equals(invocation.getMethod().getName())
        && invocation.getArguments().length == 1
        && invocation.getArguments()[0] instanceof Type){
            documentType = (Type) invocation.getArguments()[0];
            log.debug("@@@(Caching) Is cachable!!");
            if(cache.containsKey(documentType.getName())){
                log.debug("@@@(Caching) Found in Cache!");
                return cache.get(documentType.getName());
            }
            log.debug("@@@(Caching) Not Found! but is cachable!");
            result = invocation.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }
        return invocation.proceed();
    }
}
