package controller;

import DAO.CategorieDAO;
import DAO.PromoDAO;
import entity.CategorieEntity;
import entity.PromoEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorieController {

    public static List<CategorieEntity> getAllCategories() {
        List<CategorieEntity> cat = CategorieDAO.getAll();
        cat = new ArrayList<>(cat);

        return cat;
    }
}
