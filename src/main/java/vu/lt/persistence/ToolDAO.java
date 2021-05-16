package vu.lt.persistence;

import vu.lt.entities.Tool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class ToolDAO {
    @Inject
    private EntityManager em;

    public List<Tool> loadAll() {
        return em.createNamedQuery("Tool.findAll", Tool.class).getResultList();
    }

    public void persist(Tool tool){
        this.em.persist(tool);
    }
    public void delete(Tool tool) {this.em.remove(tool);}

    public Tool findOne(Integer id) { return em.find(Tool.class, id); }
}
