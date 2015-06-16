/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.UserMapper;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Оксана
 */
public class User {
    protected long id;
    protected String name;
    protected String surname;
    protected String address;
    protected String email;
    protected String login;
    protected String password;
    
    /**
     * @param id
     * @param name
     * @param surname
     * @param address
     * @param email
     * @param login
     * @param password
     * @throws IllegalArgumentException если имя или Логин является пустым или 
     * длиной менее 3 символа
     */
    
    public User(long id, String name, String surname, String address, String email,
            String login, String password) 
	    throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Illegal name.");
        } else if (login == null || login.length() < 3) {
            throw new IllegalArgumentException("Illegal login.");
        }
        
	this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.login = login;
        this.password = password;
	}
       
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    
    @Override
    public boolean equals(Object obj) {
	if (obj instanceof User) {
	    User user = (User) obj;
	    if (user.getId() == this.id && user.getLogin().equals(this.login)
		    && user.getName().equals(this.name) && user.getSurname().equals(this.surname)
		    && user.getEmail().equals(this.email)) {
		return true;
	    }
	}
	return false;
    }
    
     public static User login(String login, String password) throws SQLException {
	UserMapper mapper = new UserMapper();
	User user = mapper.findByParam(UserMapper.UserParams.Login, login);
	if (user == null ) {
	    return null;
	}
	return user;
    }
     
    public static User register(String login, String name, String surname, String email, String password) 
	    throws SQLException, IllegalArgumentException {
	UserMapper mapper = new UserMapper();
	if (mapper.findByParam(UserMapper.UserParams.Login, login) != null) {
	    return null;
	}
	mapper.insert(new User(0, name, surname, email, login, password, null));
	return mapper.findByParam(UserMapper.UserParams.Login, login);
    }
    
    public static int addUser(User user) throws SQLException {
	return new UserMapper().insert(user);
    }
    
     public static void removeUser(Long userId) throws SQLException {
	new UserMapper().delete(userId);
    }
    
    public static void removeUser(User user) throws SQLException {
	new UserMapper().delete(user);
    }
    
    public static void updateUser(User user) throws SQLException {
	new UserMapper().update(user);
    }
}
