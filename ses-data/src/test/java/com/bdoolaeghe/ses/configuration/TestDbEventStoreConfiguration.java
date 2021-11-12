package com.bdoolaeghe.ses.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(value = "com.bdoolaeghe.ses", includeFilters =  @ComponentScan.Filter(Repository.class))
public class TestDbEventStoreConfiguration {
}
