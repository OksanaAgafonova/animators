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
import java.util.ArrayList;
import java.util.List;
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
    
     public User findByParam(UserParams param, String value) throws SQLException {
	String query = "SELECT * FROM Users WHERE " + param.toString() + " = '" + value + "'";
	
	List<User> users;
	try (Connection conn = getConnection();
		Statement statement = conn.createStatement();
		ResultSet rset = statement.executeQuery(query)) {
	    users = getElementsFromResultSet(rset);
	}
	    
	if (users == null || users.isEmpty()) {
	    return null;
	}

	User user = users.get(0);
	//user.getId();

	return user;
    }
    
         @Override
      protected List<User> getElementsFromResultSet(ResultSet rset) throws SQLException {
	List<User> users = new ArrayList<>();
	while (rset.next()) {
	    long id = rset.getLong("Id");
	    int type = rset.getInt("Type");
	    String name = rset.getString("Name");
	    String surname = rset.getString("Surname");
	    String email = rset.getString("Email");
	    String login = rset.getString("Login");
	    String password = rset.getString("Password");

	    User user;
	    if (type == UserTypesEnum.User.getValue()) {
		user = new User(id, name, surname, email, login, "", null);
	    } else if (type == UserTypesEnum.Admin.getValue()) {
		user = new Admin(id, name, surname, email, login, "", null);
	    } else if (type == UserTypesEnum.Customer.getValue()) {
		user = new Customer(id, name, surname, email, login, "", null);
	    } else if (type == UserTypesEnum.Personage.getValue()) {
		user = new Personage(id, name, surname, email, login, "", null);
	    } else {
		continue;
	    }
	    user.setPassword(password);
	    users.add(user);
	}
	return users;
    }
     
    @Override
   public int insert(User user) throws SQLException {
	int userType;
	if (user instanceof Admin) {
	    userType = UserTypesEnum.Admin.getValue();
	} 
        else if (user instanceof Customer) {
	    userType = UserTypesEnum.Customer.getValue();
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
        else if (user instanceof Customer) {
	    userType = UserTypesEnum.Customer;
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
	String query = "SELECT * FROM Users WHERE Id = ?";
	
	List<User> users;
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setLong(1, id);
	    try (ResultSet rset = statement.executeQuery()) {
		users = getElementsFromResultSet(rset);
	    }
	}
	    
	if (users == null || users.isEmpty()) {
	    return null;
	}

	User user = users.get(0);
	return user;
    }
}
