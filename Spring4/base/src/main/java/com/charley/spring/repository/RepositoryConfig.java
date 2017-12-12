package com.charley.spring.repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class RepositoryConfig {

    @Profile("dev")
    @Bean
    public DataSource dataSourceMs() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setUser("controller");
        dataSource.setPassword("controller");
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);
        dataSource.setMaxIdleTime(1000);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplateMs() {
        return new JdbcTemplate(dataSourceMs());
    }

}
