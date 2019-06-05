package com.example.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AchievementCounterConfiguration {

    private final DataSourceConfiguration dataSource;

    @Autowired
    public AchievementCounterConfiguration(DataSourceConfiguration dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db-changes-master.yaml");
        liquibase.setDataSource(dataSource.getDataSource());
        return liquibase;
    }
}

