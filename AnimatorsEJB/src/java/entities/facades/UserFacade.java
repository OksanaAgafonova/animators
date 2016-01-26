/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.facades;

import entity.Orders2;
import entity.Users2;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Оксана
 */
@Stateless
public class UserFacade {

    @PersistenceContext(unitName = "AnimatorsEJBPU")
    private EntityManager em;

    @EJB
    OrderFacade orderFacade;

    public void persist(Object object) {
        em.persist(object);
    }

    public void save_(Users2 user) {

        em.merge(user);

    }

    public void del(Users2 user) {
        List<Orders2> orders = orderFacade.findIdPersonage(user);
        if (orders != null)
            for (int i = 0; i < orders.size(); i++) {
                orders.get(i).setDel(0);
                em.merge(orders.get(i));
            }
        em.remove(em.merge(user));
    }

    public Users2 findLogin(String login, String password) {
        Query query = em.createNamedQuery("Users2.findByLoginPassword");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List user = query.getResultList();
        if (user.size() > 0) {
            return ((Users2) user.get(0));
        } else {
            return null;
        }

    }

    public Users2 register(String login, String password) {
        Query query = em.createNamedQuery("Users2.findByLoginPassword");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List user = query.getResultList();
        if (user.size() > 0) {
            return ((Users2) user.get(0));
        } else {
            return null;
        }
    }

    public List<Users2> getAll(int type) {
        Query query = em.createNamedQuery("Users2.findByType");
        query.setParameter("type", type);
        List<Users2> listUser = query.getResultList();
        if (listUser.size() != 0) {
            return listUser;
        } else {
            return null;
        }
    }

    public Users2 findId(long id) {
        Query query = em.createNamedQuery("Users2.findById");
        query.setParameter("id", id);
        List<Users2> listUser = query.getResultList();
        return listUser.get(0);
    }

    public List<Users2> findNamePersonage(String namePersonage) {
        Query query = em.createNamedQuery("Users2.findByNamepersonage");
        query.setParameter("namepersonage", namePersonage);
        List<Users2> listUser = query.getResultList();
        if (listUser.size() != 0) {
            return listUser;
        } else {
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
