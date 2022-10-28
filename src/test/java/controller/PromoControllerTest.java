package controller;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PromoControllerTest {

    @Test
    void getPromosByStoreId() {
        assertNotNull(PromoController.getPromosByStoreId(3));
    }

    @Test
    void createPromo() {
        assertTrue(PromoController.createPromo(2,25, LocalDate.of(2022,10,28),LocalDate.of(2022,11,12),1));
    }

    @Test
    void createPromoSubCat() {
        assertTrue(PromoController.createPromoSubCat(1,19, LocalDate.of(2022,10,28),LocalDate.of(2022,11,12),1));
    }

    @Test
    void createPromoCatMultimediaOver20Percent() {
        assertFalse(PromoController.createPromo(1,25, LocalDate.of(2022,10,28),LocalDate.of(2022,11,12),1));
    }
    @Test
    void createPromoOver50Percent() {
        assertFalse(PromoController.createPromo(1,50, LocalDate.of(2022,10,28),LocalDate.of(2022,11,12),1));
    }

    @Test
    void confirmPromo() {
        assertTrue(PromoController.confirmPromo(3));
    }

    @Test
    void rejectPromo() {
        assertTrue(PromoController.rejectPromo(3));

    }

}