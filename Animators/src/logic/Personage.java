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
public class Personage extends User {
    
    protected String namePersonage;

    public Personage(long id, String name, String surname, String address, String email,
            String namePersonage, String login, String password) 
            throws IllegalArgumentException {
        super(id, name, surname, address, email, login, password);
      
        this.namePersonage = namePersonage;
    }
    
    public String getNamePersonage(){
        return namePersonage;
    }
    
    public void setNamePersonage(String namePersonage){
        this.namePersonage = namePersonage;    
    }

   
}
