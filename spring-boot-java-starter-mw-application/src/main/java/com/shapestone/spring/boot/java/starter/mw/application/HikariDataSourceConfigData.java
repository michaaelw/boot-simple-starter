package com.shapestone.spring.boot.java.starter.mw.application;

public interface HikariDataSourceConfigData {
    String getDriverClassName();

    String getDataSourceClassName();

    String getConnectionTestQuery();

    String getDatabaseName();

    String getJdbcUrl();

    String getUsername();

    String getPassword();

    Integer getMaxPoolSize();

    Long getCheckoutTimeout();

    Long getIdleTimeout();

    Integer getMinimumIdle();

    Long getMaxLifetime();

    Long getLeakDetectionThreshold();

    String getServerName();

    Long getPort();

    String getPoolName();
}
