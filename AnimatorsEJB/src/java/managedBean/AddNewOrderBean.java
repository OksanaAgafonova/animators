/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.facades.OrderFacade;
import entity.Orders2;
import entity.Users2;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

/**
 *
 * @author Оксана
 */
@ManagedBean
@ViewScoped
public class AddNewOrderBean {
    
    @EJB
    private OrderFacade orderFacade;
    
    Orders2 order = new Orders2();

    public Orders2 getOrder() {
        return order;
    }

    public void setOrder(Orders2 order) {
        this.order = order;
    }
    
    @Transactional
    public String create(Users2 user) {
        order.setDel(1);
        orderFacade.persist(order);
        return "/orders/orders.xhtml?faces-redirect=true";
    }

    /**
     * Creates a new instance of AddNewOrderBean
     */
    public AddNewOrderBean() {
    }
    
}
