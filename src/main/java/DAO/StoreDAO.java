package DAO;

import Services.JPA;
import entity.StoreEntity;
import entity.SubCategorieEntity;
import jakarta.persistence.Query;

import java.util.List;

public class StoreDAO {

    public static List<StoreEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT s FROM StoreEntity s");
        return query.getResultList();
    }

    public static StoreEntity getStoreById(int id) {
        StoreEntity store = JPA.entityManager().find(StoreEntity.class, id);
        System.out.println(store.getId());
        System.out.println(store.getStoreName());
        return store;
    }
}
