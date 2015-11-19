/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Service.Service;
import db.OrderMapper;
import db.UserMapper;
import java.util.List;


/**
 *
 * @author Оксана
 */
public class UserTransaction {
    
    public static User login(String login, String password)  {
	UserMapper mapper = new UserMapper();
	User user = mapper.findByParam(login, password);
	if (user == null ) {
	    return null;
	}
	return user;
    }
    
    public static User register(Integer type, String name, String surname, String namePersonage, String adress, String email, String login, String password) 
	    throws IllegalArgumentException {
        //System.out.println("Type2 = "+ type);
	UserMapper mapper = new UserMapper();
	if (mapper.findByParam(login, password) != null) {
	    return null;
            }
        //System.out.println("Type3 = "+ type);
        if (type == 1) mapper.insert(new Customer(type, name, surname, adress, email, login, password));
        if (type == 2) mapper.insert(new Personage(type, name, surname,namePersonage, adress, email, login, password));
       
	return mapper.findByParam(login, password);
    }
    
    public static int addUser(int type, String name, String surname, String namePersonage, String adress,
                    String email, String login, String password)  {
        UserMapper mapper = new UserMapper();
        User user = new Personage(2, name, surname, namePersonage, adress, email, login, password);
	User getUser = mapper.findByParam(user.getLogin(), user.getPassword());
	if (getUser != null) {
	    return 1;//Пользователь существует
	}
        else 
            return mapper.insert(user);
    }
    
    public static void removeUser(Long userId)throws IllegalArgumentException  {
	
        List<Order> orders = null;
        orders = new OrderMapper().findIdPersonage(userId);
        for(int i=0;i<orders.size();i++){
            orders.get(i).setDel(Boolean.parseBoolean("True"));
            new OrderMapper().update(orders.get(i));
        }
        
        new UserMapper().delete(userId);
        
    }
    
    public static int updateUser(long id, int type, String name, String surname, String namePersonage, String adress,
                    String email, String login, String password)throws IllegalArgumentException {
	UserMapper mapper = new UserMapper();
        User user = new Personage(id,2, name, surname, namePersonage, adress, email, login, password);
	User getUser = mapper.findByParam(user.getLogin(), user.getPassword());
        //System.out.println("id выбранной записи"+getUser.getId());
	if (getUser.getId() != user.getId()) {
	    return 1;//Пользователь существует
	}
        else {
            new UserMapper().update(user);
            return -2; //Запись обнавлена
        }
        //return 0;
        }
     
    public static List<User> findNamePersonage(String namePersonage) throws IllegalArgumentException {
        UserMapper user = new UserMapper();
        List<User> listUser = user.find(namePersonage);
        if (listUser.size()!=0){
            return listUser;
        }
        else
            return   listUser = null; 
    }
    
    public static List<User> findSurnameCustomer(String surnameCustomer)throws IllegalArgumentException {
       UserMapper user = new UserMapper();
        List<User> listUser = user.find2(surnameCustomer);
        if (listUser.size()!=0){
            return listUser;
        }
        else
            return   listUser = null; 
     
    }
    
    public static User find(long id)throws IllegalArgumentException {
        User user2 = null;
        user2 = new UserMapper().find(id);
        return user2;
    }
    
    public static  List<User> getAll(int type)throws IllegalArgumentException { 
        return new UserMapper().getAllUsers(type);
    }
    
}
