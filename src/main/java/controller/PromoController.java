package controller;

import DAO.PromoDAO;
import DAO.StoreDAO;
import DAO.SubCatDAO;
import entity.PromoEntity;
import entity.SubCategorieEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class PromoController {
    public static List<PromoEntity> getPromosByStoreId(int id){

        if(LocalTime.now().isAfter(LocalTime.of(00,0,0)) && LocalTime.now().isBefore(LocalTime.of(23,59,0))){
            List<PromoEntity> promo=StoreDAO.getStoreById(id).getPromosById().stream().collect(Collectors.toList());

        return promo;
        }
        return  null;
    }

    public static List<PromoEntity> getPromosByStoreIdForAdmins(int id){

        List<PromoEntity> promo=StoreDAO.getStoreById(id).getPromosById().stream().collect(Collectors.toList());
        return promo;
    }

    public static List<PromoEntity> getAllCurrentPromos(){
        List<PromoEntity> promo = new PromoDAO().getAllPromos();

            promo = promo.stream()
                    .filter(prom -> prom.getDateDebut().toLocalDate().isBefore(LocalDate.now()))
                    .filter(prom -> prom.getDateFin().toLocalDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
        return promo;
    }

    public static int getAllCurrentPromosNumber(){
        List<PromoEntity> promo = new PromoDAO().getAllPromos();

        promo = promo.stream()
                .filter(prom -> prom.getDateDebut().toLocalDate().isBefore(LocalDate.now()))
                .filter(prom -> prom.getDateFin().toLocalDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
        return promo.size();
    }

    public static boolean createPromo(int catId, int value, LocalDate dateDeb, LocalDate dateFin,int storeId){
        PromoEntity promo = new PromoEntity();
        promo.setStatus(String.valueOf(PromoEntity.statusVal.pending));
        promo.setCatId(catId);
        promo.setValue(value);
        promo.setDateDebut(Date.valueOf(dateDeb));
        promo.setDateFin(Date.valueOf(dateFin));
        promo.setStoreId(storeId);

        if(promo.getValue() > 50)
            return false;
        if (promo.getCatId().equals(1) && promo.getValue() > 20){
            return false;
        }
        PromoDAO.addPromo(promo);
        return true;
    }
    public static boolean createPromoSubCat(int SubCatId, int value, LocalDate dateDeb, LocalDate dateFin,int storeId){
        PromoEntity promo = new PromoEntity();
        promo.setStatus(String.valueOf(PromoEntity.statusVal.pending));
        promo.setSubCatId(SubCatId);
        promo.setValue(value);
        promo.setDateDebut(Date.valueOf(dateDeb));
        promo.setDateFin(Date.valueOf(dateFin));
        promo.setStoreId(storeId);

        if(promo.getValue() > 50)
            return false;
        SubCategorieEntity subcat = SubCatDAO.getSubCategorieById(SubCatId);
        if (subcat.getCatId().equals(1) && promo.getValue() > 20){
            return false;
        }
        PromoDAO.addPromo(promo);
        return true;
    }
    public static boolean confirmPromo(int id){

        if(PromoDAO.UpdatePromoStatusById(PromoEntity.statusVal.accepted.toString() ,id))
            return true;

        return false;
    }
    public static boolean rejectPromo(int id){
        if (PromoDAO.UpdatePromoStatusById(PromoEntity.statusVal.rejected.toString() ,id))
            return true;

        return false;
    }
    public static void deletePromo(int id){
        PromoDAO.deletePromoById(id);
    }

}
