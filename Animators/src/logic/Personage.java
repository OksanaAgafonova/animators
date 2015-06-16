/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.PersonageMapper;
import java.sql.SQLException;

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
    
     public Personage(long id, String name, String surname, String address, String email,
            String login, String password) 
            throws IllegalArgumentException {
        super(id, name, surname, address, email, login, password);
            
    }
    
    public String getNamePersonage(){
        return namePersonage;
    }
    
    public void setNamePersonage(String namePersonage){
        this.namePersonage = namePersonage;    
    }

  public static long addPersonage(Personage personage) throws SQLException {
	PersonageMapper sm = new PersonageMapper();
	Personage gotPersonage = sm.findByParam(PersonageMapper.PersonageParams.name, personage.getName());
	if (gotPersonage != null) {
	    return gotPersonage.getId();
	}
	return sm.insert(personage);
    }
   
      public static void removePersonage(Personage personage) throws SQLException {
	new PersonageMapper().delete(personage);
    }
    
    public static void updateUser(Personage personage) throws SQLException {
	new PersonageMapper().update(personage);
    }
}
