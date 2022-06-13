package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired//自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * 数据库连接池
     * 1.DBCP
     * 2.C3P0
     * 3.Hikari SpringBoot默认整合的连接池：管理数据库连接对象
     * HikariProxyConnection@1417203230 wrapping com.mysql.cj.jdbc.ConnectionImpl@5edc70ed
     * @throws SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
