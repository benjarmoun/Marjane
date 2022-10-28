package DAO;

import Services.JPA;
import entity.RespRayEntity;
import jakarta.persistence.Query;

import java.util.List;

public class RespRayDAO {
    public static void addRespRay(RespRayEntity RespRay) {
        JPA.serv(em -> em.persist(RespRay));
    }
    public static void deleteRespRay(RespRayEntity RespRay) {
        JPA.serv(em -> em.remove(RespRay));
    }
    public static RespRayEntity getRespRayById(int id) {
        RespRayEntity RespRay = JPA.entityManager().find(RespRayEntity.class,id);
        return RespRay;
    }
    public static List<RespRayEntity> getAllRespRay() {
        Query query = JPA.entityManager().createQuery("SELECT a from RespRayEntity a");
        List<RespRayEntity> lst = query.getResultList();
//        for (int i = 0; i < lst.size(); i++) {
//
//            System.out.println(lst.get(i));
//        }
        return lst;
    }
    public static void deleteRespRayById(int id) {
        RespRayEntity RespRay = JPA.entityManager().find(RespRayEntity.class,id);
        JPA.serv(em -> em.remove(RespRay));
    }
}
