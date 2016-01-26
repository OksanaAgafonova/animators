/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.facades.OrderFacade;
import entity.Orders2;
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
public class EditOrderBean {
    
    @EJB
    private OrderFacade orderFacade;
    private int id;
    private Orders2 order = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders2 getOrder() {
        if (order == null) order = orderFacade.findId(id);
        return order;
    }

    public void setOrder(Orders2 order) {
        this.order = order;
    }
    
    @Transactional
    public String save() {
        //user.setType(2);
        orderFacade.save_(order);
        System.out.println(id);
        return "/orders/orders.xhtml?faces-redirect=true";
    }

    /**
     * Creates a new instance of EditOrderBean
     */
    public EditOrderBean() {
    }
    
}
