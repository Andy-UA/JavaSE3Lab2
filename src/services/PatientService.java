package services;

import entities.PatientEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andrew on 27.03.2017.
 */
@ManagedBean
@SessionScoped
public class PatientService {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public PatientEntity add(PatientEntity pe){
        em.getTransaction().begin();
        PatientEntity deFromDB = em.merge(pe);
        em.getTransaction().commit();
        return deFromDB;
    }
    public PatientEntity get(long id){
        return em.find(PatientEntity.class, id);
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(PatientEntity pe){
        em.getTransaction().begin();
        em.merge(pe);
        em.getTransaction().commit();
    }

    public List<PatientEntity> getAll(){
        TypedQuery<PatientEntity> namedQuery = em.createNamedQuery("PatientEntity.getAll", PatientEntity.class);
        return namedQuery.getResultList();
    }
}
