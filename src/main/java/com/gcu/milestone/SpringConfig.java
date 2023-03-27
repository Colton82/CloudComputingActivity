package com.gcu.milestone;

import javax.sql.DataSource;

import org.codehaus.groovy.runtime.m12n.PropertiesModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import business.SecurityServiceInterface;
import business.ValidLogin;
import data.PropertiesDataService;
import data.PropertiesDataServiceInterface;
import model.PropertyModel;

@Configuration
public class SpringConfig {
    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService()
    {
        return new ValidLogin();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="propertiesDAO")
    @RequestScope
    public PropertiesDataServiceInterface<PropertyModel> getDataService1()
    {
        return new PropertiesDataService(dataSource);
    }
}
