/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Оксана
 */
public class Admin extends User {

    public Admin(){}
    
    public Admin(int type, String name, String surname, String adress, String email, 
            String login, String password) throws IllegalArgumentException {
        super(type, name, surname, "", adress, email, login, password);
    }
}

