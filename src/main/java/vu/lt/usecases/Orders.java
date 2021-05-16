package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Purchase;
import vu.lt.persistence.PurchaseDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Orders {

    @Inject
    private PurchaseDAO purchaseDAO;

    @Getter @Setter
    private Purchase purchaseToCreate = new Purchase();

    @Getter
    private List<Purchase> allPurchases;

    @PostConstruct
    public void init(){
        loadAllOrders();
    }

    @Transactional
    public String createCategory(){
        this.purchaseDAO.persist(purchaseToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllOrders(){
        this.allPurchases = purchaseDAO.loadAll();
    }
}
