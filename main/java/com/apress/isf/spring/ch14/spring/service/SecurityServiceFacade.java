package com.apress.isf.spring.ch14.spring.service;

import com.apress.isf.spring.ch14.java.service.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sang Jun Park on 11/28/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class SecurityServiceFacade {
    private Logger log = LoggerFactory.getLogger(SecurityServiceFacade.class);

    private Login login;

    public void setLogin(Login login){
        this.login = login;
    }

    public boolean areCredentialsValid(String email, String pass){
        log.debug("Validating Credentials > email: " + email + ", pass: " + pass);
        return this.login.isAuthorized(email, pass);
    }
}
