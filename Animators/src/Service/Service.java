/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import db.OrderMapper;
import db.UserMapper;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Order;
import logic.OrderTransaction;
import logic.User;
import logic.UserTransaction;

/**
 *
 * @author Оксана
 */
public class Service {

   /**
     * -------------------------Методы класса "USER"---------------------------
     */
    public static User login(String login, String password) throws SQLException {
	//UserMapper mapper = new UserMapper();
	//User user = mapper.findByParam(login, password);
        User user = null;
        if(login != null && !login.equals("")) 
                user = UserTransaction.login(login, password);
	if (user == null ) {
	    return null;
	}
	return user;
    }
    
    public static User register(Integer type, String name, String surname, String namePersonage, String adress, String email, String login, String password) 
	    throws SQLException, IllegalArgumentException {
        
        if(name==null || name.equals("") || surname==null || surname.equals("") || 
                namePersonage==null || namePersonage.equals("") || adress==null || adress.equals("") ||
                email==null || email.equals("") || login==null || login.equals("") || password==null || password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter at all the data");//Введены не все данные
            return null;//?????
        }
        else 
            return UserTransaction.register(type, name, surname, namePersonage, adress, email, login, password);
        
    }
    
    /*public boolean equals(Object obj) {
	if (obj instanceof User) {
	    User user = (User) obj;
	    if (user.getId() == this.id && user.getLogin().equals(this.login)
		    && user.getName().equals(this.name) && user.getSurname().equals(this.surname)
		    && user.getEmail().equals(this.email)) {
		return true;
	    }
	}
	return false;
    }*/
    
    public static int addUser(int type, String name, String surname, String namePersonage, String adress,
                    String email, String login, String password) throws SQLException {
        
        UserTransaction user = new UserTransaction();
        int count = 0;
	if(name==null || name.equals("") || surname==null || surname.equals("") || 
                namePersonage==null || namePersonage.equals("") || adress==null || adress.equals("") ||
                email==null || email.equals("") || login==null || login.equals("") || password==null || password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter at all the data");//Введены не все данные
            //return 0;
        }
        else {
            count = user.addUser(type, name, surname, namePersonage, adress, email, login, password);
            if (count == 1) JOptionPane.showMessageDialog(null, "User exist");//Пользователь существует
        }
        return count;
   }
    
    public static void removeUser(Long userId) throws SQLException {
        //System.out.println("КЛЮЧ = "+ userId);
        UserTransaction.removeUser(userId);
	JOptionPane.showMessageDialog(null, "User removed");
        //List<Order> orders = null;
        //orders = findOrder_idPer(userId);
        //for(int i=0;i<orders.size();i++){
        //    orders.get(i).setDel(Boolean.parseBoolean("True"));
        //    new OrderMapper().update(orders.get(i));
        //}
        
       // new UserMapper().delete(userId);
       // JOptionPane.showMessageDialog(null, "User removed");
    }
    
    public static void removeUserObject(User user) throws SQLException {
	new UserMapper().delete(user);
    }
    
    public static void updateUser(Long id,int type,String name, String surname, String namePersonage, String adress,
                    String email, String login, String password) throws SQLException {
	/*UserMapper mapper = new UserMapper();
	User getUser = mapper.findByParam(user.getLogin(), user.getPassword());
        //System.out.println("id выбранной записи"+getUser.getId());
	if (getUser.getId() != user.getId()) {
	    JOptionPane.showMessageDialog(null, "User exist");
	}
        else {
            new UserMapper().update(user);
            JOptionPane.showMessageDialog(null, "Record updated");
        }*/
        if(name==null || name.equals("") || surname==null || surname.equals("") || 
                namePersonage==null || namePersonage.equals("") || adress==null || adress.equals("") ||
                email==null || email.equals("") || login==null || login.equals("") || password==null || password.equals(""))
            JOptionPane.showMessageDialog(null, "Enter at all the data");//Введены не все данные
        else { 
            int count = UserTransaction.updateUser(id, type, name, surname, namePersonage, adress, email, login, password);
            if (count == 1) JOptionPane.showMessageDialog(null, "User exist");//Пользователь существует
            if (count == -2) JOptionPane.showMessageDialog(null, "Record updated");//Запись обнавлена
        }   
        }
    
    public static List<User> findNamePersonage(String namePersonage) throws SQLException {
        List<User> user = null;
        if (namePersonage != null && !namePersonage.equals(""))
            user = UserTransaction.findNamePersonage(namePersonage);
        return user;
        }
    
     public static List<User> findSurnameCustomer(String surnameCustomer) throws SQLException { 
        List<User> user = null;
        if (surnameCustomer != null && !surnameCustomer.equals(""))
            user = UserTransaction.findSurnameCustomer(surnameCustomer);
        return user;
     }
     
    public static User find(long id) {
        return UserTransaction.find(id);
    }
     
    public static  List<User> getAll(int type) throws SQLException {
        List<User> user = null;
        if (type > 0) user = UserTransaction.getAll(type);
        return user;
    } 
    
    /**
     * -------------------------Методы класса "ORDER"----------------------------
     */
    
    public static int addOrder(String namePersonage, String cust,
                    String adress, Date date, Time time, int minut, int summa,  String status, boolean del) throws SQLException {
    OrderTransaction order = new OrderTransaction();
    int count = 0;
    if(adress==null || adress.equals("") || date==null || date.equals("") || 
                time==null || time.equals("") || minut < 0 || summa < 0 )
        JOptionPane.showMessageDialog(null, "Enter at all the data, or the data is not correct");//Введены не все данные, либо данные не корректны
    else { 
        count = order.addOrder(namePersonage,cust, adress, date, time, minut, summa,  status, del);
        if (count == -3) JOptionPane.showMessageDialog(null, "Personage is busy");//Персонаж занят
        if (count != -3) JOptionPane.showMessageDialog(null, "Order added");//Заказ добавлен
    }
    return count;
    }
    
    public static void updateOrder(long id, String namePersonage, String cust,
                    String adress, Date date, Time time, int minut, int summa,  String status, boolean del) throws SQLException {
        if(adress==null || adress.equals("") || date==null || date.equals("") || 
                time==null || time.equals("") || minut < 0 || summa < 0 )
        JOptionPane.showMessageDialog(null, "Enter at all the data, or the data is not correct");//Введены не все данные, либо данные не корректны
    else {
        int count = OrderTransaction.updateOrder(id, namePersonage,cust, adress, date, time, minut, summa,  status, del);
        if (count == -3) JOptionPane.showMessageDialog(null, "Personage is busy");//Персонаж занят
        if (count == -2) JOptionPane.showMessageDialog(null, "Record updated");//Запись обнавлена
        }
    }
    
    public static void updateOrder2(Order order1) throws SQLException {
        new OrderMapper().update(order1);
    
    }
    
    public static void removeOrder(Long orderId) throws SQLException {
	new OrderMapper().delete(orderId);
        JOptionPane.showMessageDialog(null, "Record removed");
    }
    
    public static void removeOrder(Order order) throws SQLException {
	new OrderMapper().delete(order);
    }
    
    public static  List<Order> getAll(boolean bool) throws SQLException { 
     return new OrderMapper().getAllOrders(bool);
   }
        
    public static  List<Order> getAll(String name) throws SQLException { 
     return new OrderMapper().getAllOrders(name);
   }
    
    public static Order findOrder(long id) throws SQLException {
        Order order2 = null;
        order2 = new OrderMapper().find(id);
        return order2;
    }
    
    //public static List<Order> findOrder_idPer(long id) throws SQLException {
    //    return new OrderMapper().findIdPersonage(id);
    //}

    
}
