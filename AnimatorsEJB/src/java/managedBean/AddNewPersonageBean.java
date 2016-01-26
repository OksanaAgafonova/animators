/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.facades.UserFacade;
import entity.Users2;
import java.io.Serializable;
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
public class AddNewPersonageBean implements Serializable{
    
    @EJB
    private UserFacade userFacade;
    
    Users2 user = new Users2();

    public Users2 getUser() {return user;}
    public void setUser(Users2 user) {this.user = user;}

    /**
     * Creates a new instance of AddNewPersonageBean
     */
    public AddNewPersonageBean() {
    }
    
    @Transactional
    public String create(Users2 user_) {
        Users2 user2 = userFacade.findLogin(user.getLogin(), user.getPassword());
        if (user2 != null) {
            user.setLogin("");
            user.setPassword("");
            return "/error/errorCreate.xhtml?faces-redirect=true";
        }else{
        
        user.setType(2);
        userFacade.persist(user);
        return "/personage/personages.xhtml?faces-redirect=true";
    }
    }
}
