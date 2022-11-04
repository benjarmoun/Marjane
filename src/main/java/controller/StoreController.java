package controller;

import DAO.StoreDAO;
import DAO.SubCatDAO;
import entity.StoreEntity;
import entity.SubCategorieEntity;

import java.util.ArrayList;
import java.util.List;

public class StoreController {
    public static List<StoreEntity> getAllStores() {
        List<StoreEntity> store = StoreDAO.getAll();
        store = new ArrayList<>(store);

        return store;
    }
}
