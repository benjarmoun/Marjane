import DAO.AdminDAo;
import DAO.CategorieDAO;
import DAO.PromoDAO;
import DAO.SupAdminDAO;
import Services.Hash;
import Services.JPA;
import controller.*;
import entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

import static Services.Hash.MD5;


public class Main {
    public static void addSupAdmin(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            SupAdminEntity supAdmin = new SupAdminEntity();
            supAdmin.setEmail("admin3@admin.com");
            supAdmin.setPassword("admin3");
            entityManager.persist(supAdmin);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            transaction.rollback();
        }

        entityManager.close();
        factory.close();
    }
    public static void addCity (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        VilleEntity ville = new VilleEntity();

        ville.setName("rabat");

        entityManager.persist(ville);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
    public static void addStore (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        StoreEntity store = new StoreEntity();
        store.setVilleId(2);
        store.setStoreName("rabat");

        entityManager.persist(store);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
    public static void addCategorie (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CategorieEntity categorie = new CategorieEntity();
        categorie.setName("food");

        entityManager.persist(categorie);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
    public static void addAdmin (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        AdminEntity admin = new AdminEntity();
        admin.setEmail("adminrabat@admin.com");
        admin.setPassword("admin");
        admin.setStoreId(1);

        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
    public static void addAdmin2 (String[] args){


        AdminEntity admin = new AdminEntity();
        admin.setEmail("adminagadir@admin.com");
        admin.setPassword("admin");
        admin.setStoreId(1);

        JPA.serv(em -> em.persist(admin));

//        entityManager.close();
//        factory.close();

    }

    public static void main(String[] args) throws Exception {
//        SupAdminDAO.getAdminById(2);
//        SupAdminDAO.getAdminByMail("admin");
//        CategorieDAO.getAll();
//        AdminDAo.getAllAdmins();
//        PromoDAO.getAllPromos();
//        System.out.println(AdminController.login("admincasa@admin.com","admin"));
//        System.out.println(SupAdminController.login("admin","admin"));
//        System.out.println(MD5("respr3"));

//        PromoController.getPromosByStoreId(3);
//        PromoController.createPromo();
//        PromoDAO.UpdatePromoStatusById(PromoEntity.statusVal.pending.toString() ,3);
//        PromoController.confirmPromo(3);
//        SendMail.sendAccountInfos("benjarmoun123@gmail.com", "test");
//        RespRayController.ResgisterRespRay("email111", "Password",1);
//        RespRayController.login("email111","resp1");
        SupAdminController.login("admin","admin");
    }


    public static void updateAdmin(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        AdminEntity existingAdmin = new AdminEntity();
        existingAdmin.setId(4);
        existingAdmin.setEmail("adminrabat@admin.com");
        existingAdmin.setPassword("admin");
        existingAdmin.setStoreId(3);

        entityManager.merge(existingAdmin);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }


    public static void addPromo (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PromoEntity promo = new PromoEntity();
        promo.setCatId(1);
        promo.setSubCatId(null);
        promo.setStoreId(1);
        promo.setValue(20);
        promo.setStatus(String.valueOf(PromoEntity.statusVal.pending));
        promo.setDateDebut(Date.valueOf("2021-10-26"));
        promo.setDateFin(Date.valueOf("2021-10-29"));

        entityManager.persist(promo);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }

    public static void updatePromo(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        PromoEntity existingPromo = new PromoEntity();
        existingPromo.setId(3);
        existingPromo.setCatId(1);
        existingPromo.setSubCatId(null);
        existingPromo.setStoreId(1);
        existingPromo.setValue(15);
        existingPromo.setStatus(String.valueOf(PromoEntity.statusVal.pending));
        existingPromo.setDateDebut(Date.valueOf("2021-10-27"));
        existingPromo.setDateFin(Date.valueOf("2021-10-30"));

        entityManager.merge(existingPromo);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public static void getPromo(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Integer primaryKey = 4;
        PromoEntity promo = entityManager.find(PromoEntity.class,3);

        System.out.println(promo.getStatus());
        System.out.println(promo.getCatId());
        System.out.println(promo.getDateDebut());
        System.out.println(promo.getDateFin());

    }

    public static void deletePromo(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Integer primaryKey = 5;
        PromoEntity promo = entityManager.find(PromoEntity.class,primaryKey);

        entityManager.remove(promo);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

//    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = factory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        String sql = "SELECT p from PromoEntity p where p.status = 'pending'";
////        ArrayList<PromoEntity> sql = "SELECT p from PromoEntity p where p.status = 'pending'";
//        Query query = entityManager.createQuery(sql);
//        ArrayList<PromoEntity> promo = (ArrayList<PromoEntity>) query.getResultList();
//
//        System.out.println(promo.getStatus());
//        System.out.println(promo.getCatId());
//        System.out.println(promo.getDateDebut());
//        System.out.println(promo.getDateFin());
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        factory.close();
//    }
    public static void addSubCat (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        SubCategorieEntity subCategorie = new SubCategorieEntity();
        subCategorie.setCatId(1);
        subCategorie.setName("TVs");

        entityManager.persist(subCategorie);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
}
