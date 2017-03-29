package services;

import entities.OrderdrugEntity;

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
public class OrderdrugService {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public OrderdrugEntity add(OrderdrugEntity de){
        em.getTransaction().begin();
        OrderdrugEntity deFromDB = em.merge(de);
        em.getTransaction().commit();
        return deFromDB;
    }
    public OrderdrugEntity get(long id){
        return em.find(OrderdrugEntity.class, id);
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(OrderdrugEntity de){
        em.getTransaction().begin();
        em.merge(de);
        em.getTransaction().commit();
    }

    public List<OrderdrugEntity> getAll(){
        TypedQuery<OrderdrugEntity> namedQuery = em.createNamedQuery("OrderdrugEntity.getAll", OrderdrugEntity.class);
        return namedQuery.getResultList();
    }
}
