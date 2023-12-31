package com.apress.isf.spring.ch08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Sang Jun Park on 11/14/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class AfterLoggingModule implements AfterReturningAdvice {
    private static final Logger log = LoggerFactory.getLogger(AfterLoggingModule.class);
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if(log.isDebugEnabled()){
            log.debug("@@@@(AFTER) Method called: " + method.getName());
            if(args.length == 0)
                log.debug("@@@@(AFTER) No arguments passed.");
            for(Object arg : args)
                log.debug("@@@@(AFTER) Argument passed: " + arg);
            log.debug("@@@@(AFTER) Result: " + returnValue);
        }
    }
}
