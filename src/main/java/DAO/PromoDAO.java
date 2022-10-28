package DAO;

import Services.JPA;
import entity.PromoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

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
//        for (int i = 0; i < lst.size(); i++) {
//
//            System.out.println(lst.get(i));
//        }
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
    public static boolean UpdatePromoStatusById(String newStatus, int id) {
            try {
                JPA.serv(em ->
                        em.createQuery("update PromoEntity  SET status = ?1 where id = ?2 ").setParameter(1, newStatus).setParameter(2, id).executeUpdate()
                );
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    public static void deletePromoById(int id) {
        PromoEntity promo = JPA.entityManager().find(PromoEntity.class,id);
        JPA.serv(em -> em.remove(promo));
    }

}
