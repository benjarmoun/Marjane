package DAO;

import Services.JPA;
import entity.SubCategorieEntity;

public class SubCatDAO {
    public static SubCategorieEntity getSubCategorieById(int id) {
        SubCategorieEntity subCat = JPA.entityManager().find(SubCategorieEntity.class, id);
        System.out.println(subCat.getId());
        System.out.println(subCat.getName());
        System.out.println(subCat.getCatId());
        return subCat;
    }
}
