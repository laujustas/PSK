package vu.lt.persistence;

import vu.lt.entities.Purchase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class PurchaseDAO {
    @Inject
    private EntityManager em;

    public List<Purchase> loadAll() {
        return em.createNamedQuery("Purchase.findAll", Purchase.class).getResultList();
    }

    public void persist(Purchase purchase){
        this.em.persist(purchase);
    }
}
