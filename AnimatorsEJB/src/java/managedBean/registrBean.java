/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.facades.UserFacade;
import entity.Users2;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;

/**
 *
 * @author Оксана
 */
@ManagedBean
@SessionScoped
public class registrBean {
    
    @EJB
    private UserFacade userFacade;
    
    Users2 user = new Users2();
    String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    public Users2 getUser() {return user;}
    public void setUser(Users2 user) {this.user = user;}

    /**
     * Creates a new instance of AddNewPersonageBean
     */
    public registrBean() {
           }
    
    @Transactional
    public String register() {
        Users2 user_ = userFacade.findLogin(user.getLogin(), user.getPassword());
        if (user_ != null) {
            user.setLogin("");
            user.setPassword("");
            return "/error/errorRegistr.xhtml?faces-redirect=true";
        }else{
            if (filter.equals("Администратор")) user.setType(0);
            if (filter.equals("Клиент")) user.setType(1);
            if (filter.equals("Персонаж")) user.setType(2);
        }
        userFacade.persist(user);
        user.setName(""); 
        user.setSurname("");
        user.setNamepersonage("");
        user.setAdress("");
        user.setEmail("");
        user.setLogin("");
        user.setPassword("");
        return "/personage/personages.xhtml?faces-redirect=true";
    }
    
        /**
     * Creates a new instance of registrBean
     */
    
    
}
