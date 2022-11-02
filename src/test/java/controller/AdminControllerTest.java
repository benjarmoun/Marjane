package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @Test
    void login() throws Exception {
        assertNotNull(AdminController.login("adminsafi@admin.com","admin"));
    }

    @Test
    void resgisterAdmin() throws Exception {
        assertTrue(AdminController.ResgisterAdmin("admin@admin.com","admin",3));
    }
}