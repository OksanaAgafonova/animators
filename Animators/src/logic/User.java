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
public class User {

    
    protected long id;
    protected int type;
    protected String name;
    protected String surname;
    protected String namePersonage;
    protected String adress;
    protected String email;
    protected String login;
    protected String password;
    
    /**
     * @param id
     * @param type
     * @param name
     * @param surname
     * @param namePersonage
     * @param adress
     * @param email
     * @param login
     * @param password
     * @throws IllegalArgumentException если имя или Логин является пустым или 
     * длиной менее 3 символа
     */
    
    public User() {}
    
    public User(int type, String name, String surname, String namePersonage, String adress, String email,
            String login, String password) {
        //if (name == null) {
        //    throw new IllegalArgumentException("Illegal name.");
        //} else 
                
	this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.namePersonage = namePersonage;
        this.adress = adress;
        this.email = email;
        this.login = login;
        this.password = password;
	}
       
    public User(long id, int type, String name, String surname, String namePersonage, String adress, String email,
            String login, String password) 
	    throws IllegalArgumentException {
        //if (name == null) {
        //    throw new IllegalArgumentException("Illegal name.");
        //} else if (login == null || login.length() < 3) {
        //    throw new IllegalArgumentException("Illegal login.");
        //}
        
	this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.namePersonage = namePersonage;
        this.adress = adress;
        this.email = email;
        this.login = login;
        this.password = password;
	}
    
    public void setId(int id)                           {this.id = id;}
    public long getId()                                 {return id;}
    public int getType()                                {return type;}
    public void setType(int type)                       {this.type = type;}
    public String getName()                             {return name;}
    public void setName(String name)                    {this.name = name;}
    public String getSurname()                          {return surname;}
    public void setSurname(String surname)              {this.surname = surname;}
    public String getNamePersonage()                    {return namePersonage;}
    public void setNamePersonage(String namePersonage)  {this.namePersonage = namePersonage;}
    public String getAddress()                          {return adress;}
    public void setAddress(String adress)               {this.adress = adress;}
    public String getEmail()                            {return email;}
    public void setEmail(String email)                  {this.email = email;}
    public String getLogin()                            {return login;}
    public void setLogin(String login)                  {this.login = login;}
    public String getPassword()                         {return password;}
    public void setPassword(String password)            {this.password = password;}

}