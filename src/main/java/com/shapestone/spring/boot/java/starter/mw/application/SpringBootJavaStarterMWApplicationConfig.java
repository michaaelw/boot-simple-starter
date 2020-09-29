package com.shapestone.spring.boot.java.starter.mw.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shapestone.spring.boot.java.starter.mw.application.service.HelloGoodByeApplicationService;
import com.shapestone.spring.boot.java.starter.mw.domain.service.GoodByeService;
import com.shapestone.spring.boot.java.starter.mw.domain.service.HelloService;
import com.shapestone.spring.boot.java.starter.mw.infrastructure.SpringBootJavaStarterMWRepositoryConfig;
import com.shapestone.spring.boot.java.starter.mw.presentation.HelloGoodByeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Properties;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.util.Collections.emptyList;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Configuration
@Import({SpringBootJavaStarterMWRepositoryConfig.class})
public class SpringBootJavaStarterMWApplicationConfig {

    private Properties properties;
    private Environment env;
    private SpringBootJavaStarterMWRepositoryConfig repositoryConfig;

    @Autowired
    public SpringBootJavaStarterMWApplicationConfig(final Environment env, final SpringBootJavaStarterMWRepositoryConfig repositoryConfig) {
        this.env = env;
        this.repositoryConfig = repositoryConfig;
    }

    public SpringBootJavaStarterMWApplicationConfig(final Properties properties) {
        this.properties = properties;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        final MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    /*-------------------------------------------------
    Properties
    -------------------------------------------------*/
    /*
    @Bean
    public SpringBootJavaStarterMWApplicationConfigData springBootJavaStarterMWApplicationConfig() {
        if (nonNull(properties)) {
            return new PropSpringBootJavaStarterMWApplicationConfigData(properties);
        } else {
            return new EnvSpringBootJavaStarterMWApplicationConfigData(env);
        }
    }
    */
    /*-------------------------------------------------
    Data Source
    -------------------------------------------------*/
    /*
    @Bean
    public DataSource springBootJavaStarterMWApplicationDataSource() {
        final HikariConfig hikariConfig = new HikariConfig();

        final SpringBootJavaStarterMWApplicationConfigData mespoConfig = springBootJavaStarterMWApplicationConfig();
        final String hikariDriverClassName = mespoConfig.getDriverClassName();
        hikariConfig.setDriverClassName(hikariDriverClassName);
        final String hikariConnectionTestQuery = mespoConfig.getConnectionTestQuery();
        hikariConfig.setConnectionTestQuery(hikariConnectionTestQuery);
        final String hikariJdbcUrl = mespoConfig.getJdbcUrl();
        hikariConfig.setJdbcUrl(hikariJdbcUrl);
        final String hikariUsername = mespoConfig.getUsername();
        hikariConfig.setUsername(hikariUsername);
        final String hikariPassword = mespoConfig.getPassword();
        hikariConfig.setPassword(hikariPassword);
        final Integer hikariMaxPoolSize = mespoConfig.getMaxPoolSize();
        hikariConfig.setMaximumPoolSize(hikariMaxPoolSize);
        final Long hikariIdleTimeout = mespoConfig.getIdleTimeout();
        hikariConfig.setIdleTimeout(hikariIdleTimeout);
        final Integer hikariMinimumIdle = mespoConfig.getMinimumIdle();
        hikariConfig.setMinimumIdle(hikariMinimumIdle);
        final Long hikariMaxLifetime = mespoConfig.getMaxLifetime();
        hikariConfig.setMaxLifetime(hikariMaxLifetime);
        final Long hikariLeakDetectionThreshold = mespoConfig.getLeakDetectionThreshold();
        hikariConfig.setLeakDetectionThreshold(hikariLeakDetectionThreshold);
        final String hikariPoolName = mespoConfig.getPoolName();
        hikariConfig.setPoolName(hikariPoolName);

        return new HikariDataSource(hikariConfig);
    }
    */

    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.shapestone.spring.boot.java.starter.mw.presentation"))
                //.apis(RequestHandlerSelectors.any)
                //.paths(PathSelectors.any)
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "TITLE",
                "DESCIPRION",
                "VERSION",
                "TERMS OF SERVICE URL",
                new Contact("NAME", "URL", "EMAIL"),
                "LICENSE",
                "LICENSE URL",
                emptyList()
        );
    }

    /*-------------------------------------------------
    Domain Services
    -------------------------------------------------*/

    @Bean
    public HelloService helloService() {
        return new HelloService(repositoryConfig.helloRepository());
    }

    @Bean
    public GoodByeService goodByeService() {
        return new GoodByeService(repositoryConfig.goodByeRepository());
    }

    /*-------------------------------------------------
    Application Services
    -------------------------------------------------*/

    @Bean
    public HelloGoodByeApplicationService helloGoodByeApplicationService() {
        return new HelloGoodByeApplicationService(goodByeService(), helloService());
    }

    /*-------------------------------------------------
    Controllers
    -------------------------------------------------*/

    @Bean
    public HelloGoodByeController helloGoodByeController() {
        return new HelloGoodByeController(helloGoodByeApplicationService());
    }

}
