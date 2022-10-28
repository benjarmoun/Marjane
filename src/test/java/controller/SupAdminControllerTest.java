package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupAdminControllerTest {

    @Test
    void login() throws Exception {
        assertTrue(SupAdminController.login("admin","admin"));

    }
}