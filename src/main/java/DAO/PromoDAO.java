package DAO;

import Services.JPA;
import entity.PromoEntity;
import jakarta.persistence.Query;

import java.util.List;

import static entity.PromoEntity.statusVal.accepted;

public class PromoDAO {
    public static void addPromo(PromoEntity promo) {
        JPA.serv(em -> em.persist(promo));
    }
    public static void deletePromo(PromoEntity promo) {
        JPA.serv(em -> em.remove(promo));
    }
    public static PromoEntity getPromoById(int id) {
        PromoEntity promo = JPA.entityManager().find(PromoEntity.class,id);
        return promo;
    }
    public static List<PromoEntity> getAllPromos() {
        Query query = JPA.entityManager().createQuery("SELECT a from PromoEntity a");
        List<PromoEntity> lst = query.getResultList();
        for (int i = 0; i < lst.size(); i++) {

            System.out.println(lst.get(i));
        }
        return query.getResultList();
    }
//    public static List<PromoEntity> getPromosByStoreId() {
//        Query query = JPA.entityManager().createQuery("SELECT a from PromoEntity a");
//        List<PromoEntity> lst = query.getResultList();
//        for (int i = 0; i < lst.size(); i++) {
//
//            System.out.println(lst.get(i));
//        }
//        return query.getResultList();
//    }
//    public static List<PromoEntity> getPromosByCatId() {
//        Query query = JPA.entityManager().createQuery("SELECT a from PromoEntity a");
//        List<PromoEntity> lst = query.getResultList();
//        for (int i = 0; i < lst.size(); i++) {
//
//            System.out.println(lst.get(i));
//        }
//        return query.getResultList();
//    }
    public static void UpdatePromoStatusById(int id) {
        try {
            Query query = JPA.entityManager().createQuery("update PromoEntity  SET status = 'sts'  where id = 3");
//            query.setParameter("ID",ID);
//            query.setParameter("sts",sts);
            query.executeUpdate();
    //            return query.executeUpdate();
            }catch (Exception e){
            JPA.entityTransaction().rollback();
//            transaction.rollback();
            e.printStackTrace();
        }
        }
    public static void deletePromoById(int id) {
        PromoEntity promo = JPA.entityManager().find(PromoEntity.class,id);
        JPA.serv(em -> em.remove(promo));
    }

}
