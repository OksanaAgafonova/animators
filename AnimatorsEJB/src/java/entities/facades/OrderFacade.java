/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.facades;

import entity.Orders2;
import entity.Users2;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Оксана
 */
@Stateless
public class OrderFacade {

    @PersistenceContext(unitName = "AnimatorsEJBPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void save_(Orders2 order) {

        em.merge(order);

    }

    public void del(Orders2 order) {

        em.remove(em.merge(order));
        //em.remove(user);

    }

    public List<Orders2> getAllOrders(int i) {
        Query query = em.createNamedQuery("Orders2.findByDel");
        query.setParameter("del", i);
        List<Orders2> listOrder = query.getResultList();
        if (listOrder.size() != 0) {
            return listOrder;
        } else {
            return null;
        }
    }

    public Orders2 findId(long id) {
        Query query = em.createNamedQuery("Orders2.findById");
        query.setParameter("id", id);
        List<Orders2> listOrder = query.getResultList();
        return listOrder.get(0);
    }

    public List<Orders2> findIdPersonage(Users2 id) {
        Query query = em.createNamedQuery("Orders2.findByIdPersonage");
        query.setParameter("idpersonage", id);
        List<Orders2> listOrder = query.getResultList();
        if (listOrder.size() != 0) {
            return listOrder;
        } else {
            return null;
        }
    }    
}
