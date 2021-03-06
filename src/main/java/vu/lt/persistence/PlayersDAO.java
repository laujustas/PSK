package vu.lt.persistence;

import vu.lt.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PlayersDAO {

    @Inject
    private EntityManager em;

    public void persist(Player player){
        this.em.persist(player);
    }

    public Player findOne(Integer id){
        return em.find(Player.class, id);
    }

    public Player update(Player player){
        return em.merge(player);
    }
}
