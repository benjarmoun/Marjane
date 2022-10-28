package DAO;

import Services.JPA;
import entity.AdminEntity;
import entity.CategorieEntity;
import jakarta.persistence.Query;

import java.util.List;

public class AdminDAo {
    public static void addAdmin(AdminEntity admin) {
        JPA.serv(em -> em.persist(admin));
    }

    public static void deleteAdmin(AdminEntity admin) {
        JPA.serv(em -> em.remove(admin));
    }

    public static AdminEntity getAdminById(int id) {
        AdminEntity admin = JPA.entityManager().find(AdminEntity.class, id);
        return admin;
    }

    public static List<AdminEntity> getAllAdmins() {
        Query query = JPA.entityManager().createQuery("SELECT a from AdminEntity a");
//        List<AdminEntity> lst = query.getResultList();
//        for (int i = 0; i < lst.size(); i++) {
//            System.out.println(lst.get(i));
//        }
        return query.getResultList();
    }

    public static void deleteAdminById(int id) {
        AdminEntity admin = JPA.entityManager().find(AdminEntity.class, id);
        JPA.serv(em -> em.remove(admin));
    }

}
