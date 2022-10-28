package controller;

import DAO.PromoDAO;
import entity.AdminEntity;
import entity.PromoEntity;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class PromoController {
    public static List<PromoEntity> getPromosByStoreId(int id){
            List<PromoEntity> promo = PromoDAO.getAllPromos();
        if(LocalTime.now().isAfter(LocalTime.of(8,0,0)) && LocalTime.now().isBefore(LocalTime.of(23,0,0))){

            promo = promo.stream()
                    .filter(prom -> prom.getStoreId().equals(id))
                    .collect(Collectors.toList());
            for (int i = 0; i < promo.size(); i++) {
                System.out.println(promo.get(i));
            }
        }
        return promo;
    }
    public static boolean createPromo(PromoEntity promo){
        if(promo.getValue() > 50)
            return false;
        if (promo.getCatId().equals(1) && promo.getValue() > 20){
            return false;
        }
        PromoDAO.addPromo(promo);
        return true;
    }
    public static void confirmPromo(int id){
        PromoDAO.UpdatePromoStatusById(id);

    }

}
