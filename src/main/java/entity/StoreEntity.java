package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "store", schema = "public", catalog = "marjane")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ville_id")
    private Integer villeId;
    @Basic
    @Column(name = "store_name")
    private String storeName;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<AdminEntity> adminsById;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<PromoEntity> promosById;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<RespRayEntity> respRaysById;
    @ManyToOne
    @JoinColumn(name = "ville_id", referencedColumnName = "id", insertable = false, updatable = false)
    private VilleEntity villeByVilleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVilleId() {
        return villeId;
    }

    public void setVilleId(Integer villeId) {
        this.villeId = villeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (id != that.id) return false;
        if (villeId != null ? !villeId.equals(that.villeId) : that.villeId != null) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (villeId != null ? villeId.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        return result;
    }

    public Collection<AdminEntity> getAdminsById() {
        return adminsById;
    }

    public void setAdminsById(Collection<AdminEntity> adminsById) {
        this.adminsById = adminsById;
    }

    public Collection<PromoEntity> getPromosById() {
        return promosById;
    }

    public void setPromosById(Collection<PromoEntity> promosById) {
        this.promosById = promosById;
    }

    public Collection<RespRayEntity> getRespRaysById() {
        return respRaysById;
    }

    public void setRespRaysById(Collection<RespRayEntity> respRaysById) {
        this.respRaysById = respRaysById;
    }

    public VilleEntity getVilleByVilleId() {
        return villeByVilleId;
    }

    public void setVilleByVilleId(VilleEntity villeByVilleId) {
        this.villeByVilleId = villeByVilleId;
    }

    @Override
    public String toString() {
        return "StoreEntity{" +
                "id=" + id +
                ", villeId=" + villeId +
                ", storeName='" + storeName + '\'' +
//                ", adminsById=" + adminsById +
//                ", promosById=" + promosById +
//                ", respRaysById=" + respRaysById +
//                ", villeByVilleId=" + villeByVilleId +
                '}';
    }
}
