package ru.product_developer.study.books.db;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.GenericContainer;

import javax.sql.DataSource;

@Configuration
public class TestDatabaseConfiguration {

    @Bean
    @Primary
    DataSource dataSource(final GenericContainer postgreSQLContainer) {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:"
                        + postgreSQLContainer.getMappedPort(5432)
                        + "/postgres?currentSchema=books_schema")
                .username("books_app")
                .password("apppassword")
                .build();
    }

    @Bean
    GenericContainer postgreSQLContainer() {
        GenericContainer container = new GenericContainer("books-db")
                .withExposedPorts(5432);

        container.start();
        return container;
    }

    @Bean
    @LiquibaseDataSource
    public DataSource liquibaseDataSource(final GenericContainer postgreSQLContainer) {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:"
                        + postgreSQLContainer.getMappedPort(5432)
                        + "/postgres?currentSchema=books_schema")
                .username("books_owner")
                .password("ownerpassword")
                .build();
    }
}
