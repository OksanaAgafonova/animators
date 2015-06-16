/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.OrderMapper;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Оксана
 */
public class Order {
    protected long idOrder;
    protected long idPersonaja;
    protected String address;
    protected Date date;
    protected Time time;
    protected long minut;
    protected long sum;
    protected String status;
    
public Order (long idOrder, String address,Date date, Time time, long minut,
        long sum, String status){
   
    this.idOrder = idOrder;
    this.address = address;
    this.date = date;
    this.time = time;
    this.minut = minut;
    this.sum = sum;
    this.status = status;
}    

 public static int addOrder(Order order) throws SQLException {
	return new OrderMapper().insert(order);
    }
    
     public static void removeOrder(Long orderId) throws SQLException {
	new OrderMapper().delete(orderId);
    }
    
    public static void removeOrder(Order order) throws SQLException {
	new OrderMapper().delete(order);
    }
    
    public static void updateUser(Order order) throws SQLException {
	new OrderMapper().update(order);
    }

public long getIdOrder() {
        return idOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public Long getMinut(){
        return minut;
    }
    
    public void setMinut(long minut){
        this.minut = minut;    
    }

    public long getSum() {
        return sum;
    }
    
    public void setSum(long sum) {
        this.sum = sum;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getTime() {
         return time;
    }
   
    
}
