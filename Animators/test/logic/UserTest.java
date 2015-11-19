/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Service.Service;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Оксана
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        
        System.out.println("getType");
        User instance = new User(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
            "55555", "55555");
        int expResult = 2;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   
    /**
     * Test of setType method, of class User.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        User user = new User(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
            "55555", "55555");
        user.setType(1);
        int type = 1;
        User instance = new User();
        instance.setType(type);
        assertEquals(instance.getType(), user.getType());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class User.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        //Personage person = new Personage(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
        //    "55555", "55555");
        User user = Service.login("55555", "55555");
        if (user != null)
            JOptionPane.showMessageDialog(null, "the user exist");//Пользователь существует
        else{
            int result = Service.addUser(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
            "55555", "55555");
            assertTrue(result > 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        }
    }

    /**
     * Test of removeUser method, of class User.
     */
    @Test
    public void testRemoveUser_Long() throws Exception {
        System.out.println("removeUser");
        Long userId = 100L;
        Service.removeUser(userId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class User.
     */
    @Test
    public void testRemoveUser_User() throws Exception {
        System.out.println("removeUser");
        User user = new User(2, "Николай", "Иванов", "Буратино", "ул.Гоголя 14", "ivanov@mail.ru",
            "55555", "55555");
        User user_ = Service.login(user.getLogin(), user.getPassword());
        if (user_ != null)
            Service.removeUserObject(user);
        else
            JOptionPane.showMessageDialog(null, "the user does not exist");//Пользователя не существует
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class User.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        List <User> user = Service.findNamePersonage("Буратино");
        String str2 = "Николай2";
        if (user != null){
            user.get(0).setName("Николай2");
            //Service.updateUser(user.get(0));
        }
        assertEquals(user.get(0).getName(), str2);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of find method, of class User.
     */
    @Test
    public void testFind_long() {
        System.out.println("find");
        long id = 88L;
        String str = "Винни-Пух";
        User result = Service.find(id);
        assertEquals(str, result.getNamePersonage());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findNamePersonage method, of class User.
     */
    @Test
    public void testFindNamePersonage() throws Exception {
        System.out.println("findNamePersonage");
        String namePersonage = "Буратино";
        List<User> result = Service.findNamePersonage(namePersonage);
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class User.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        int id = 2;
        List<User> result = Service.getAll(id);
        assertTrue(result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
