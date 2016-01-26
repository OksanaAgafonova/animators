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
public class EditPersonageBean implements Serializable{

    @EJB
    private UserFacade userFacade;
    private int id;
    private Users2 user = null;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Users2 getUser() {
        if (user == null) user = userFacade.findId(id);
        return user;
    }

    public void setUser(Users2 user) {
        this.user = user;
    }

    /**
     * Creates a new instance of EditPersonageBean
     */
    public EditPersonageBean() {
        
    }
 
    @Transactional
    public String save() {
        //user.setType(2);
        userFacade.save_(user);
        System.out.println(id);
        return "/personage/personages.xhtml?faces-redirect=true";
    }    
}
