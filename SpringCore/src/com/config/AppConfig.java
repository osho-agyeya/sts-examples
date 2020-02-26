package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // whatever can be done using xml can be done using annotation
@ComponentScan({"com.beans", "com.aspects"})
@EnableAspectJAutoProxy // enables aop
// @EnableLoadTimeWeaving
public class AppConfig {

    @Bean
    public DataSource datasource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/TrainingDB");

        return dataSource;


    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
