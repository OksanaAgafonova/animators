/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.facades.OrderFacade;
import entity.Users2;
import entities.facades.UserFacade;
import entity.Orders2;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Оксана
 */
@ManagedBean
@Stateless
public class ServiceBean {

    @EJB
    private UserFacade userFacade;
    @EJB
    private OrderFacade orderFacade;
    
    
    public DataModel<Users2> getAllPersonage(String nameFilter) {
        if (nameFilter == null || nameFilter.isEmpty())
            return new ListDataModel(userFacade.getAll(2));
        return new ListDataModel(userFacade.findNamePersonage(nameFilter));
    }
    
    public DataModel<Orders2> getAllOrders() {
        return new ListDataModel(orderFacade.getAllOrders(1));
    }
    
    public String deleteOrder(Orders2 order) {
        orderFacade.del(order);
        return null;
    }

    public String deleteUser(Users2 user) {
        userFacade.del(user);
        return null;
    }
    
    public List<Users2> getAllPersonage()
    {
        return userFacade.getAll(2);
    }
    
    public List<Users2> getAllCustomer()
    {
        return userFacade.getAll(1);
    }
        
    public ServiceBean() {

    }

}
