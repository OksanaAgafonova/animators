/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import logic.*;

/**
 *
 * @author Оксана
 */
public class UserMapper extends AbstractMapper<User>{
    
    public enum UserParams {
	Email, Login;
    }
    
    public UserMapper() {
    }
    
    @Override
   public int insert(User user) throws SQLException {
	int userType;
	if (user instanceof Admin) {
	    userType = UserTypesEnum.Admin.getValue();
	} 
        else if (user instanceof Client) {
	    userType = UserTypesEnum.Client.getValue();
	}
        else if (user instanceof Personage) {
	    userType = UserTypesEnum.Personage.getValue();
	}
        else {
	    userType = UserTypesEnum.User.getValue();
	}
	
	try (Connection conn = getConnection(); PreparedStatement statement = getInsertStatement(user, userType, conn)) {
	    statement.executeUpdate();
	    try (ResultSet keys = statement.getGeneratedKeys()) {
		if (keys == null || !keys.next()) {
		    return -1;
		}
		return keys.getInt(1);
	    }
	}
    }
    
        private PreparedStatement getInsertStatement(User user, int type, Connection conn) throws SQLException {
	String query = "INSERT INTO Users(Type, Name, Surname, Email, Login, "
		+ "Password) VALUES (?, ?, ?, ?, ?, ?)";
	PreparedStatement statement = null;
	try {
	    statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    statement.setInt(1, type);
	    statement.setString(2, user.getName());
	    statement.setString(3, user.getSurname());
	    statement.setString(4, user.getEmail());
	    statement.setString(5, user.getLogin());
	    statement.setString(6, user.getPassword());
	    return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }

    @Override
    public void update(User user) throws SQLException {
	try (Connection conn = getConnection(); PreparedStatement statement = getUpdateStatement(user, conn)) {
	    statement.executeUpdate();
	}
    }
    
     private PreparedStatement getUpdateStatement(User user, Connection conn) throws SQLException {
	String query = "UPDATE Users SET Type = ?, Name = ?, Surname = ?, Email = ?, "
		+ "Login = ?, Password = ? WHERE Id = ?";
	
        UserTypesEnum userType;
	PreparedStatement statement = null;
        if (user instanceof Admin) {
	    userType = UserTypesEnum.Admin;
	} 
        else if (user instanceof Client) {
	    userType = UserTypesEnum.Client;
	}
        else if (user instanceof Personage) {
	    userType = UserTypesEnum.Personage;
	}
        else {
	    userType = UserTypesEnum.User;
	}
	
	try {
	    statement = conn.prepareStatement(query);
	    statement.setInt(1, userType.getValue());
	    statement.setString(2, user.getName());
	    statement.setString(3, user.getSurname());
	    statement.setString(4, user.getEmail());
	    statement.setString(5, user.getLogin());
	    statement.setString(6, user.getPassword());
	    statement.setLong(7, user.getId());
	    return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }

    @Override
    public void delete(User user) throws SQLException {
	delete(user.getId());
    }
    
    public void delete(Long userId) throws SQLException {
	String query = "DELETE FROM Users WHERE Id = ?";
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setLong(1, userId);
	    statement.executeUpdate();
	}
    }

    @Override
    public User find(long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
