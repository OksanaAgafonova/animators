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
public class Customer extends User{
    
    public Customer(long id, String name, String surname, String address, String email,
            String login, String password) throws IllegalArgumentException {
        super(id, name, surname, address, email, login, password);
    }
    }
