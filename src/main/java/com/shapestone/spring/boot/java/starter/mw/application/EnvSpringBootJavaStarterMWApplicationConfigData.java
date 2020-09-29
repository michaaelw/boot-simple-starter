package com.shapestone.spring.boot.java.starter.mw.application;

import org.springframework.core.env.Environment;

public class EnvSpringBootJavaStarterMWApplicationConfigData implements SpringBootJavaStarterMWApplicationConfigData {

    private Environment env;

    public EnvSpringBootJavaStarterMWApplicationConfigData(final Environment environment) {
        this.env = environment;
    }

    @Override
    public String getDriverClassName() {
        return env.getProperty("spring.boot.java.starter.mw.db.driverClassName", "");
    }

    @Override
    public String getDataSourceClassName() {
        return env.getProperty("spring.boot.java.starter.mw.db.dataSourceClassName", "");
    }

    @Override
    public String getConnectionTestQuery() {
        return env.getProperty("spring.boot.java.starter.mw.db.pool.connection.test.query", "");
    }

    @Override
    public String getDatabaseName() {
        return env.getProperty("spring.boot.java.starter.mw.db.databaseName", "");
    }

    @Override
    public String getJdbcUrl() {
        return env.getProperty("spring.boot.java.starter.mw.db.jdbc.url", "");
    }

    @Override
    public String getUsername() {
        return env.getProperty("spring.boot.java.starter.mw.db.username", "");
    }

    @Override
    public String getPassword() {
        return env.getProperty("spring.boot.java.starter.mw.db.password", "");
    }

    @Override
    public Integer getMaxPoolSize() {
        return java.lang.Integer.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.max.size", "0"));
    }

    @Override
    public Long getCheckoutTimeout() {
        return java.lang.Long.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.checkout.time", "0"));
    }

    @Override
    public Long getIdleTimeout() {
        return java.lang.Long.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.idle.timeout", "0"));
    }

    @Override
    public Integer getMinimumIdle() {
        return java.lang.Integer.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.minimum.idle", "0"));
    }

    @Override
    public Long getMaxLifetime() {
        return java.lang.Long.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.max.lifetime", "0"));
    }

    @Override
    public Long getLeakDetectionThreshold() {
        return java.lang.Long.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.leak.detection.threshold", "5000"));
    }

    @Override
    public String getServerName() {
        return env.getProperty("spring.boot.java.starter.mw.db.pool.server.name", "");
    }

    @Override
    public Long getPort() {
        return java.lang.Long.valueOf(env.getProperty("spring.boot.java.starter.mw.db.pool.port", "0"));
    }

    @Override
    public String getPoolName() {
        return env.getProperty("spring.boot.java.starter.mw.db.pool.pool.name", "");
    }

}
