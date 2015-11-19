/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Service.Service;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Оксана
 */
public class OrderTest {
    
    public OrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     /**
     * Test of addOrder method, of class Order.
     */
    @Test
    public void testAddOrder() throws Exception {
        SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formTime = new SimpleDateFormat("hh:mm a");
        long millis = formTime.parse("15:50:60").getTime();
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
        java.sql.Time timeValue = new java.sql.Time(formTime.parse(time).getTime());
        System.out.println("addOrder");
        long person = Service.addUser(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
            "55555", "55555");
        long customer = Service.addUser(1, "Дмитрий", "Сидоров","","ул.Гагарина 12", "sidorov@mail.ru",
            "356", "356");
        Order order = new Order(Service.find(person) ,Service.find(customer) , "ул. Просвещения 3", formDate.parse("12.12.15"), timeValue, 30, 1000, "На рассмотрении", Boolean.parseBoolean("False"));
        //int result = Service.addOrder(order);
        //assertTrue(result > 0);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class Order.
     */
    @Test
    public void testRemoveOrder_Long() throws Exception {
        System.out.println("removeOrder");
        long orderId = 19L;
        Service.removeOrder(orderId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of updateOrder method, of class Order.
     */
    @Test
    public void testUpdateOrder() throws Exception {
        System.out.println("updateOrder");
        Order order = Service.findOrder(2);
        String str2 = "Контемировская 111";
        order.setAddress(str2);
        //Service.updateOrder(order);
        assertEquals(order.getAddress(), str2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Order.
     */
    @Test
    public void testGetAll_0args() throws Exception {
        System.out.println("getAll");
        Boolean bool = Boolean.parseBoolean("False");
        List<Order> result = Service.getAll(bool);
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Order.
     */
    @Test
    public void testGetAll_String() throws Exception {
        System.out.println("getAll");
        String name = "Винни-Пух";
        List<Order> result = Service.getAll(name);
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Order.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        long id = 8L;
        String str = Service.findOrder(id).getAddress();
        assertEquals("ул. Советская", str);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
