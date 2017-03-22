package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew on 20.03.2017.
 */
@Entity
@Table(name = "PATIENT", schema = "SYSTEM", catalog = "")
public class PatientEntity {
    private long patientid;
    private String name;
    private String address;
    private Set<OrderdrugEntity> orderdrugEntities = new HashSet<OrderdrugEntity>(0);

    @Id
    @Column(name = "PATIENTID")
    public long getPatientid() {
        return patientid;
    }

    public void setPatientid(long patientid) {
        this.patientid = patientid;
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
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (patientid != that.patientid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (patientid ^ (patientid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patientEntity")
    public Set<OrderdrugEntity> getOrderdrugEntities() {
        return orderdrugEntities;
    }

    public void setOrderdrugEntities(Set<OrderdrugEntity> orderdrugEntities) {
        this.orderdrugEntities = orderdrugEntities;
    }
}
