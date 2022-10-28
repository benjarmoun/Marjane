package DAO;

import Services.JPA;
import entity.CategorieEntity;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

public class CategorieDAO {
    public static CategorieEntity getCategorieById(int id)
    {
        CategorieEntity cat = JPA.entityManager().find(CategorieEntity.class, id);
        System.out.println(cat.getId());
        System.out.println(cat.getName());
        return cat;
    }

    public static List<CategorieEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM CategorieEntity c");
//        List<CategorieEntity> cat = query.getResultList();

//        List<CategorieEntity> lst = cat.stream()
//                .collect(Collectors.toList());

//        for (int i = 0; i < lst.size(); i++) {
//
//        System.out.println(lst.get(i));
//        }
        return query.getResultList();
    }

    public static void addCat(CategorieEntity category) {
        JPA.serv(em -> em.persist(category));
    }
}
