package DAO;

import Services.JPA;
import entity.AdminEntity;
import entity.SupAdminEntity;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SupAdminDAO {
    public static void getAdminById(int id)
    {
        SupAdminEntity supadmin = JPA.entityManager().find(SupAdminEntity.class, id);
        System.out.println(supadmin.getId());
        System.out.println(supadmin.getEmail());
        System.out.println(supadmin.getPassword());
    }

    public static void getAdminByMail(String email) {
//        Query query = (Query) JPA.entityManager().createQuery("SELECT a from SupAdminEntity a where a.email = :email");
//        query.setParameter("email",email);

        //get All
        Query query = (Query) JPA.entityManager().createQuery("SELECT a from SupAdminEntity a ");
        List<SupAdminEntity> supadmin = query.getResultList();



//        System.out.println(supadmin);


        List<SupAdminEntity> lst = supadmin.stream()
                .filter(supAdminEntity -> supAdminEntity.getEmail().equals("admin"))
                .collect(Collectors.toList());
        System.out.println(lst.get(0));
    }

    public static List<SupAdminEntity> getAllAdmins() {
        Query query = (Query) JPA.entityManager().createQuery("SELECT a from SupAdminEntity a ");
//        List<SupAdminEntity> supadmin = query.getResultList();
        return query.getResultList();
    }
}
