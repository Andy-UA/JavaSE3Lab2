package services;

import entities.PharmacyEntity;

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
public class PharmacyService {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public PharmacyEntity add(PharmacyEntity pe){
        em.getTransaction().begin();
        PharmacyEntity deFromDB = em.merge(pe);
        em.getTransaction().commit();
        return deFromDB;
    }
    public PharmacyEntity get(long id){
        return em.find(PharmacyEntity.class, id);
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(PharmacyEntity pe){
        em.getTransaction().begin();
        em.merge(pe);
        em.getTransaction().commit();
    }

    public List<PharmacyEntity> getAll(){
        TypedQuery<PharmacyEntity> namedQuery = em.createNamedQuery("PharmacyEntity.getAll", PharmacyEntity.class);
        return namedQuery.getResultList();
    }
}
