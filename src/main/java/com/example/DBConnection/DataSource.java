//package com.example.DBConnection;
//
//import com.example.AchievementCounterApplication;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class DataSource {
//
//    private static HikariConfig config = new HikariConfig();
//    private static HikariDataSource ds;
//    private static final Logger logger = LoggerFactory.getLogger(AchievementCounterApplication.class);
//
//    static {
//        logger.info("Setting configuration for database");
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/achievement_counter?serverTimezone=UTC");
//        config.setUsername("root");
//        config.setPassword("1234");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        ds = new HikariDataSource(config);
//    }
//
//    private DataSource() {
//    }
//
//    public static Connection getConnection() throws SQLException {
//        try {
//            return ds.getConnection();
//        }
//        catch (SQLException e) {
//            logger.error("could not get connection");
//            throw e;
//        }
//    }
//
//    public static HikariDataSource getDataSource() {
//        return ds;
//    }
//}
