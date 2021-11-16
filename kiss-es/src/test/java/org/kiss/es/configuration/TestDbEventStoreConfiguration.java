package org.kiss.es.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(value = "org.kiss.es", includeFilters =  @ComponentScan.Filter(Repository.class))
public class TestDbEventStoreConfiguration {
}
