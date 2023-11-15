package com.apress.isf.spring.ch08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Sang Jun Park on 11/14/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class BeforeLoggingModule implements MethodBeforeAdvice {
    private static final Logger log = LoggerFactory.getLogger(BeforeLoggingModule.class);
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(log.isDebugEnabled()){
            log.debug("@@@@(BEFORE) Method called: " + method.getName());
            if(args.length == 0)
                log.debug("@@@@(BEFORE) No arguments passed.");
            for(Object arg : args)
                log.debug("@@@@@(BEFORE) Argument passed: " + arg);
        }
    }
}
