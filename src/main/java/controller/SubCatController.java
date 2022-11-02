package controller;

import DAO.CategorieDAO;
import DAO.SubCatDAO;
import entity.CategorieEntity;
import entity.SubCategorieEntity;

import java.util.ArrayList;
import java.util.List;

public class SubCatController {
    public static List<SubCategorieEntity> getAllSubCategories() {
        List<SubCategorieEntity> subCat = SubCatDAO.getAll();
        subCat = new ArrayList<>(subCat);

        return subCat;
    }
}
