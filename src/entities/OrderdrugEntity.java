package entities;

import javax.persistence.*;
/**
 * Created by Andrew on 20.03.2017.
 */
@Entity
@Table(name = "ORDERDRUG", schema = "SYSTEM", catalog = "")
@NamedQuery(name = "OrderdrugEntity.getAll", query = "SELECT c from OrderdrugEntity c")
public class OrderdrugEntity {
    private long orderdrugid;
    private int totalcost;
    private DrugsEntity drugsEntity;
    private MedicEntity medicEntity;
    private PatientEntity patientEntity;
    private PharmacyEntity pharmacyEntity;

    @Id
    @Column(name = "ORDERDRUGID")
    public long getOrderdrugid() {
        return orderdrugid;
    }

    public void setOrderdrugid(long orderdrugid) {
        this.orderdrugid = orderdrugid;
    }

    @Basic
    @Column(name = "TOTALCOST")
    public int getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(int totalcost) {
        this.totalcost = totalcost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdrugEntity that = (OrderdrugEntity) o;

        if (orderdrugid != that.orderdrugid) return false;
        if (totalcost != that.totalcost) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderdrugid ^ (orderdrugid >>> 32));
        result = 31 * result + totalcost;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DRUGSID", nullable = false)
    public DrugsEntity getDrugsEntity() {
        return drugsEntity;
    }

    public void setDrugsEntity(DrugsEntity drugsEntity) {
        this.drugsEntity = drugsEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDICID", nullable = false)
    public MedicEntity getMedicEntity() {
        return medicEntity;
    }

    public void setMedicEntity(MedicEntity medicEntity) {
        this.medicEntity = medicEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENTID", nullable = false)
    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PHARMACYID", nullable = false)
    public PharmacyEntity getPharmacyEntity() {
        return pharmacyEntity;
    }

    public void setPharmacyEntity(PharmacyEntity pharmacyEntity) {
        this.pharmacyEntity = pharmacyEntity;
    }
}
