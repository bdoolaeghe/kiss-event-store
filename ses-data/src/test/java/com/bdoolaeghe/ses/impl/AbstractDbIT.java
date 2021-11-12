package com.bdoolaeghe.ses.impl;


import com.bdoolaeghe.ses.configuration.TestDbEventStoreConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJdbcTest
@ContextConfiguration(
        classes = TestDbEventStoreConfiguration.class,
        initializers = DockerPostgresDatasourceInitializer.class
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableAutoConfiguration
@Testcontainers
public abstract class AbstractDbIT {
}
