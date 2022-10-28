package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RespRayControllerTest {

    @Test
    void login() throws Exception {
        assertTrue(RespRayController.login("resp1@admin.com","resp1"));
    }

    @Test
    void resgisterRespRay() throws Exception {
        assertTrue(RespRayController.ResgisterRespRay("resp1@admin.com","resp1",3));

    }
}