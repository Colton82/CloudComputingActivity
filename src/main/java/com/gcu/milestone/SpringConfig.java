package com.gcu.milestone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import business.SecurityServiceInterface;
import business.ValidLogin;

@Configuration
public class SpringConfig {
    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService()
    {
        return new ValidLogin();
    }
}
