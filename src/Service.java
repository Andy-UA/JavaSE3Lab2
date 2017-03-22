import entities.DrugsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andrew on 21.03.2017.
 */
public class Service {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public DrugsEntity add(DrugsEntity de){
        em.getTransaction().begin();
        DrugsEntity deFromDB = em.merge(de);
        em.getTransaction().commit();
        return deFromDB;
    }
    public DrugsEntity get(long id){
        return em.find(DrugsEntity.class, id);
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(DrugsEntity car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<DrugsEntity> getAll(){
        TypedQuery<DrugsEntity> namedQuery = em.createNamedQuery("DrugsEntity.getAll", DrugsEntity.class);
        return namedQuery.getResultList();
    }
}
