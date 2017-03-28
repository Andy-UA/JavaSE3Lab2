package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew on 20.03.2017.
 */
@Entity
@Table(name = "PHARMACY", schema = "SYSTEM", catalog = "")
@NamedQuery(name = "PharmacyEntity.getAll", query = "SELECT c from PharmacyEntity c")
public class PharmacyEntity {
    private long pharmacyid;
    private String name;
    private String owner;
    private Set<OrderdrugEntity> orderdrugEntities = new HashSet<OrderdrugEntity>(0);

    @Id
    @Column(name = "PHARMACYID")
    public long getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(long pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "OWNER")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PharmacyEntity that = (PharmacyEntity) o;

        if (pharmacyid != that.pharmacyid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pharmacyid ^ (pharmacyid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacyEntity")
    public Set<OrderdrugEntity> getOrderdrugEntities() {
        return orderdrugEntities;
    }

    public void setOrderdrugEntities(Set<OrderdrugEntity> orderdrugEntities) {
        this.orderdrugEntities = orderdrugEntities;
    }
}
