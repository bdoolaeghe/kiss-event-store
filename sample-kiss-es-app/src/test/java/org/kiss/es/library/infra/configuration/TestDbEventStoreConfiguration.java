package org.kiss.es.library.infra.configuration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
@ComponentScan(value = "org.kiss.es", includeFilters =  @ComponentScan.Filter(Repository.class))
public class TestDbEventStoreConfiguration {

    public static class DockerPostgresDatasourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:11.1")
                .withDatabaseName("integration-tests-db")
                .withUsername("postgres")
                .withPassword("");

        static {
            postgreSQLContainer.start();
        }

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }

    }


}
