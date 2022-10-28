package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "sub_categorie", schema = "public", catalog = "marjane")
public class SubCategorieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "cat_id")
    private Integer catId;
    @OneToMany(mappedBy = "subCategorieBySubCatId")
    private Collection<PromoEntity> promosById;
    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategorieEntity categorieByCatId;

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

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubCategorieEntity that = (SubCategorieEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        return result;
    }

    public Collection<PromoEntity> getPromosById() {
        return promosById;
    }

    public void setPromosById(Collection<PromoEntity> promosById) {
        this.promosById = promosById;
    }

    public CategorieEntity getCategorieByCatId() {
        return categorieByCatId;
    }

    public void setCategorieByCatId(CategorieEntity categorieByCatId) {
        this.categorieByCatId = categorieByCatId;
    }
}
