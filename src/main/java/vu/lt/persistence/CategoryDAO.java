package vu.lt.persistence;

import vu.lt.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class CategoryDAO {
    @Inject
    private EntityManager em;

    public List<Category> loadAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    public void persist(Category category){
        this.em.persist(category);
    }
    public void delete(Category category){ this.em.remove(category); }

    public Category findOne(Integer id) { return em.find(Category.class, id); }
}