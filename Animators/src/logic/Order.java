/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Time;
import java.util.Date;
/**
 *
 * @author Оксана
 */
public class Order {
    protected long id;
    protected User Personage;
    protected User Customer;
    protected String adress;
    protected Date date;
    protected Time time;
    protected int minut;
    protected int summa;
    protected String status;
    protected boolean del;
    
    
    
    public Order (){}
    
    public Order(long id, User Personage, User Customer, String address, /*java.sql.Date date, Time time*/Date date, Time time, int minut, int sum, String status, boolean del) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.id = id;
    this.Personage = Personage;
    this.Customer = Customer;
    this.adress = address;
    this.date = date;
    this.time = time;
    this.minut = minut;
    this.summa = sum;
    this.status = status;
    this.del = del;
    }
    
    public Order(User Personage, User Customer, String address, /*java.sql.Date date, Time time*/Date date, Time time, int minut, int sum, String status, boolean del) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.id = id;
    this.Personage = Personage;
    this.Customer = Customer;
    this.adress = address;
    this.date = date;
    this.time = time;
    this.minut = minut;
    this.summa = sum;
    this.status = status;
    this.del = del;
    
    }

    public void setId(int id)                           {this.id = id;}
    public long getId()                                 {return id;}
    public User getPersonage()                          {return Personage;}
    public User getCustomer()                           {return Customer;}
    public void setPersonage(Personage personage)       {this.Personage = personage;}
    public void setCustomer(Customer customer)          {this.Customer = customer;}
    public String getAddress()                          {return adress;}
    public void setAddress(String address)              {this.adress = address;}
    public Date getDate()                               {return date;}
    public void setDate(Date date)                      {this.date = date;}
    public Time getTime()                               {return time;}
    void setTime(Time time)                             {this.time = time;}
    public int getMinut()                               {return minut;}
    public void setMinut(int minut)                     {this.minut = minut;}
    public int getSum()                                 {return summa;}
    public void setSum(int sum)                         {this.summa = sum;}
    public String getStatus()                           {return status;}
    public void setStatus(String status)                {this.status = status;}
    public void setDel(boolean del)                     {this.del = del;}
    public boolean getDel()                              {return del;}

}

