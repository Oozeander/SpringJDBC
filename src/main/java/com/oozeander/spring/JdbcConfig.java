/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander.spring;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
@Configuration
@ComponentScan(basePackages = "com.oozeander")
@PropertySource(value = "classpath:db.properties",
        ignoreResourceNotFound = false)
public class JdbcConfig {
    @Autowired
    ConfigurableEnvironment env;

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("driver"));
        dataSource.setUrl(env.getRequiredProperty("url"));
        dataSource.setUsername(env.getRequiredProperty("user"));
        dataSource.setPassword(env.getRequiredProperty("pass"));
        return dataSource;
    }
}
