package entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew on 20.03.2017.
 */
@ManagedBean
@SessionScoped
@Entity
@Table(name = "MEDIC", schema = "SYSTEM", catalog = "")
@NamedQuery(name = "MedicEntity.getAll", query = "SELECT c from MedicEntity c")
public class MedicEntity {
    private long medicid;
    private String name;
    private Long licensenumber;
    private Set<OrderdrugEntity> orderdrugEntities = new HashSet<OrderdrugEntity>(0);

    @Id
    @Column(name = "MEDICID")
    public long getMedicid() {
        return medicid;
    }

    public void setMedicid(long medicid) {
        this.medicid = medicid;
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
    @Column(name = "LICENSENUMBER")
    public Long getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(Long licensenumber) {
        this.licensenumber = licensenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicEntity that = (MedicEntity) o;

        if (medicid != that.medicid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (licensenumber != null ? !licensenumber.equals(that.licensenumber) : that.licensenumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (medicid ^ (medicid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (licensenumber != null ? licensenumber.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicEntity")
    public Set<OrderdrugEntity> getOrderdrugEntities() {
        return orderdrugEntities;
    }

    public void setOrderdrugEntities(Set<OrderdrugEntity> orderdrugEntities) {
        this.orderdrugEntities = orderdrugEntities;
    }
}
