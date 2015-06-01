/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import db.UserMapper;
import java.sql.SQLException;
import logic.User;

/**
 *
 * @author Оксана
 */
public class UserService {
    
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
