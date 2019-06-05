package com.example.DBConnection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@Component
public class DataSourceBean {
    private static HikariDataSource ds;
    private HikariConfig config = new HikariConfig();

    @Bean
    @Primary
    public HikariDataSource getDataSource() {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/achievement_counter?serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw e;
        }
    }
}