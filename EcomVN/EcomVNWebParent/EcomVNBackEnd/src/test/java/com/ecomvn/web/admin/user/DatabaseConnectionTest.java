package com.ecomvn.web.admin.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

@DataJpaTest
public class DatabaseConnectionTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testDatabaseConnection() {
        assertNotNull(entityManager);
        // Additional assertions or tests related to the database connection
    }
}