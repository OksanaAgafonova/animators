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
    
    private String namePersonage;

    public Personage(){}
            
    public Personage(int type, String name, String surname, String namePersonage, String adress, String email,
             String login, String password) 
            throws IllegalArgumentException {
        super(type, name, surname, namePersonage, adress, email, login, password);
      
        this.namePersonage = namePersonage;
    }
   
    public Personage(long id, int type, String name, String surname, String namePersonage, String adress, String email,
             String login, String password) throws IllegalArgumentException {
        super(id, type, name, surname, namePersonage, adress, email, login, password);
        
        this.namePersonage = namePersonage;
    }
       
    public String getNamePersonage()                    {return this.namePersonage;}
    public void setNamePersonage(String namePersonage)  {this.namePersonage = namePersonage;}

}

