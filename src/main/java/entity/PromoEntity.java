package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "promo", schema = "public", catalog = "marjane")
public class PromoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "value")
    private Integer value;
    @Basic
    @Column(name = "cat_id")
    private Integer catId;
    @Basic
    @Column(name = "store_id")
    private Integer storeId;
    @Basic
    @Column(name = "date_debut")
    private Date dateDebut;
    @Basic
    @Column(name = "date_fin")
    private Date dateFin;
    @Basic
    @Column(name = "sub_cat_id")
    private Integer subCatId;
    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategorieEntity categorieByCatId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", insertable = false, updatable = false)
    private StoreEntity storeByStoreId;
    @ManyToOne
    @JoinColumn(name = "sub_cat_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SubCategorieEntity subCategorieBySubCatId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }

    public enum statusVal {
        pending, accepted, rejected
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoEntity that = (PromoEntity) o;

        if (id != that.id) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;
        if (subCatId != null ? !subCatId.equals(that.subCatId) : that.subCatId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (subCatId != null ? subCatId.hashCode() : 0);
        return result;
    }

    public CategorieEntity getCategorieByCatId() {
        return categorieByCatId;
    }

    public void setCategorieByCatId(CategorieEntity categorieByCatId) {
        this.categorieByCatId = categorieByCatId;
    }

    public StoreEntity getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(StoreEntity storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    public SubCategorieEntity getSubCategorieBySubCatId() {
        return subCategorieBySubCatId;
    }

    public void setSubCategorieBySubCatId(SubCategorieEntity subCategorieBySubCatId) {
        this.subCategorieBySubCatId = subCategorieBySubCatId;
    }

    @Override
    public String toString() {
        return "PromoEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", value=" + value +
                ", catId=" + catId +
                ", storeId=" + storeId +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", subCatId=" + subCatId +
//                ", categorieByCatId=" + categorieByCatId +
//                ", storeByStoreId=" + storeByStoreId +
//                ", subCategorieBySubCatId=" + subCategorieBySubCatId +
                '}';
    }
}
