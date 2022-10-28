package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categorie", schema = "public", catalog = "marjane")
public class CategorieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "categorieByCatId")
    private Collection<PromoEntity> promosById;
    @OneToMany(mappedBy = "categorieByCatId")
    private Collection<SubCategorieEntity> subCategoriesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorieEntity categorie = (CategorieEntity) o;

        if (id != categorie.id) return false;
        if (name != null ? !name.equals(categorie.name) : categorie.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<PromoEntity> getPromosById() {
        return promosById;
    }

    public void setPromosById(Collection<PromoEntity> promosById) {
        this.promosById = promosById;
    }

    public Collection<SubCategorieEntity> getSubCategoriesById() {
        return subCategoriesById;
    }

    public void setSubCategoriesById(Collection<SubCategorieEntity> subCategoriesById) {
        this.subCategoriesById = subCategoriesById;
    }

    @Override
    public String toString() {
        return "CategorieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", promosById=" + promosById +
//                ", subCategoriesById=" + subCategoriesById +
                '}';
    }
}
