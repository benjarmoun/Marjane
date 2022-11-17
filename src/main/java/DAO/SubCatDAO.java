package DAO;

import Services.JPA;
import entity.CategorieEntity;
import entity.SubCategorieEntity;
import jakarta.persistence.Query;

import java.util.List;

public class SubCatDAO {
    public static List<SubCategorieEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT s FROM SubCategorieEntity s");
//
        return query.getResultList();
    }
    public static SubCategorieEntity getSubCategorieById(int id) {
        SubCategorieEntity subCat = JPA.entityManager().find(SubCategorieEntity.class, id);
        return subCat;
    }
}
