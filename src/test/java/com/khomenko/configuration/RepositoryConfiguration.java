package com.khomenko.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.khomenko.domain"})
@EnableJpaRepositories(basePackages = {"com.khomenko.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
