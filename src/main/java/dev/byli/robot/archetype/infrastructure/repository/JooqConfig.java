package dev.byli.robot.archetype.infrastructure.repository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Slf4j
@Configuration
public class JooqConfig {

    @Bean
    public DSLContext dslContext(@Value("${datasource.default.url}") String url,
                                 @Value("${datasource.default.username}") String username,
                                 @Value("${datasource.default.password}") String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return DSL.using(conn, SQLDialect.POSTGRES);
    }
}