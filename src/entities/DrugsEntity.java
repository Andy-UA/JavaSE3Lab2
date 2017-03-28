package entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew on 20.03.2017.
 */
@Entity
@Table(name = "DRUGS", schema = "SYSTEM", catalog = "")
@NamedQuery(name = "DrugsEntity.getAll", query = "SELECT c from DrugsEntity c")
public class DrugsEntity implements Serializable{
    private long drugsid;
    private String name;
    private Long barcode;
    private Set<OrderdrugEntity> orderdrugEntities = new HashSet<OrderdrugEntity>(0);

    @Id
    @Column(name = "DRUGSID")
    public long getDrugsid() {
        return drugsid;
    }

    public void setDrugsid(long drugsid) {
        this.drugsid = drugsid;
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
    @Column(name = "BARCODE")
    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrugsEntity that = (DrugsEntity) o;

        if (drugsid != that.drugsid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (barcode != null ? !barcode.equals(that.barcode) : that.barcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (drugsid ^ (drugsid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "drugsEntity")
    public Set<OrderdrugEntity> getOrderdrugEntities() {
        return orderdrugEntities;
    }

    public void setOrderdrugEntities(Set<OrderdrugEntity> orderdrugEntities) {
        this.orderdrugEntities = orderdrugEntities;
    }
}
