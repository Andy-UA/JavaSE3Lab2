package services;

import entities.MedicEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andrew on 27.03.2017.
 */
public class MedicService {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public MedicEntity add(MedicEntity me){
        em.getTransaction().begin();
        MedicEntity deFromDB = em.merge(me);
        em.getTransaction().commit();
        return deFromDB;
    }
    public MedicEntity get(long id){
        return em.find(MedicEntity.class, id);
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(MedicEntity me){
        em.getTransaction().begin();
        em.merge(me);
        em.getTransaction().commit();
    }

    public List<MedicEntity> getAll(){
        TypedQuery<MedicEntity> namedQuery = em.createNamedQuery("MedicEntity.getAll", MedicEntity.class);
        return namedQuery.getResultList();
    }
}
