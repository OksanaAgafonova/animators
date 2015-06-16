/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Оксана
 */
public class PersonageTest {
    
    public PersonageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNamePersonage method, of class Personage.
     */
    @Test
    public void testGetNamePersonage() {
        System.out.println("getNamePersonage");
        Personage instance = null;
        String expResult = "";
        String result = instance.getNamePersonage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNamePersonage method, of class Personage.
     */
    @Test
    public void testSetNamePersonage() {
        System.out.println("setNamePersonage");
        String namePersonage = "";
        Personage instance = null;
        instance.setNamePersonage(namePersonage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPersonage method, of class Personage.
     */
    @Test
    public void testAddPersonage() throws Exception {
        System.out.println("addPersonage");
        Personage personage = null;
        long expResult = 0L;
        long result = Personage.addPersonage(personage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePersonage method, of class Personage.
     */
    @Test
    public void testRemovePersonage() throws Exception {
        System.out.println("removePersonage");
        Personage personage = null;
        Personage.removePersonage(personage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class Personage.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        Personage personage = null;
        Personage.updateUser(personage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
