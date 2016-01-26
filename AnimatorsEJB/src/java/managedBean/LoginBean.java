/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Users2;
import entities.facades.UserFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Оксана
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    @EJB
    private UserFacade userFacade;

    String login="";
    String password="";
    Users2 currentUser = null;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users2 getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users2 currentUser) {
        this.currentUser = currentUser;
    }
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public String login() {
    Users2 user_ = userFacade.findLogin(login, password);
    if (user_ != null) {
        currentUser = user_;
        return "/personage/personages.xhtml?faces-redirect=true";
    }
    return "/login.xhtml?faces-redirect=true";
}
    
}
