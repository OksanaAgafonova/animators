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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public User findByParam(String _login, String _password) {
	String query = "SELECT * FROM Users2 WHERE login='{login}' and password = '{password}'";
        query = query.replace("{login}", _login)
                     .replace("{password}", _password);
	List<User> users;
	Connection conn;
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rset = statement.executeQuery(query);
            users = getElementsFromResultSet(rset);	
        } catch (SQLException ex) {
            users = null;
        }
	    
	if (users == null || users.isEmpty()) {
	    return null;
	}

	User user = users.get(0);
	user.getId();

	return user;
    }
    
    @Override
    protected List<User> getElementsFromResultSet(ResultSet rset) throws SQLException {
	List<User> users = new ArrayList<>();
	while (rset.next()) {
	    int id = rset.getInt("ID");
	    int type = rset.getInt("type");  
	    String name = rset.getString("name");
	    String surname = rset.getString("surname");
            String namePersonage = rset.getString("namePersonage");
            String adress = rset.getString("adress");
	    String email = rset.getString("email");
	    String login = rset.getString("login");
	    String password = rset.getString("password");

	    User user;
            if (type == UserTypesEnum.Admin.getValue()) {
		user = new Admin(type, name, surname, adress, email, login, "");
	    } else if (type == UserTypesEnum.Customer.getValue()) {
		user = new Customer(type, name, surname, adress, email, login, "");
	    } else if (type == UserTypesEnum.Personage.getValue()) {
		user = new Personage(type, name, surname, namePersonage, adress, email, login, "");
	    } else {
		continue;
	    }
            user.setId(id); 
	    user.setPassword(password);
	    users.add(user);
	}
	return users;
    }
     
    @Override
    public int insert(User user) {
	int userType = 0;
        String userNamePersonage = "";
	if (user instanceof Admin) {
	    userType = UserTypesEnum.Admin.getValue();
	} 
        else if (user instanceof Customer) {
	    userType = UserTypesEnum.Customer.getValue();
	}
        else if (user instanceof Personage) {
	    userType = UserTypesEnum.Personage.getValue();
            userNamePersonage = ((Personage)user).getNamePersonage();
	}
       	
	try (Connection conn = getConnection(); PreparedStatement statement = getInsertStatement(user, userType,  userNamePersonage, conn)) {
	    statement.executeUpdate();
	    try (ResultSet keys = statement.getGeneratedKeys()) {
		if (keys == null || !keys.next()) {
		    return -1;
		}
		return keys.getInt(1);
	    }
	} catch (SQLException ex) {
            return -1;
        }
       
    }
    
    private static PreparedStatement getInsertStatement(User user, int type,String userNamePersonage, Connection conn) throws SQLException {
	String query = "INSERT INTO USERS2(TYPE, name, surname, namePersonage, adress, email, login,"
		+ "Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement statement = null;
	try {
	    statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    statement.setInt(1, type);
            System.out.println("IDD" + user.getId());
	    statement.setString(2, user.getName());
	    statement.setString(3, user.getSurname());
            if (type == UserTypesEnum.Personage.getValue()){
              statement.setString(4, user.getNamePersonage());}
            else statement.setString(4, "");
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getEmail());
	    statement.setString(7, user.getLogin());
	    statement.setString(8, user.getPassword());
	    return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }

    //@Override
    public void update(User user) {
	try {
            Connection conn = getConnection();
            PreparedStatement statement = getUpdateStatement(user,  conn);
            statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private PreparedStatement getUpdateStatement(User user, Connection conn) throws SQLException {
         String query = "UPDATE USERS2 SET Type = ?, Name = ?, Surname = ?, namePersonage = ?,adress = ?, Email = ?, "
		+ "Login = ?, Password = ? WHERE Id = ?";
        UserTypesEnum userType = null;
	PreparedStatement statement = null;
        
        if (user instanceof Admin) userType = UserTypesEnum.Admin;
	else if (user instanceof Customer) userType = UserTypesEnum.Customer;
        else if (user instanceof Personage) userType = UserTypesEnum.Personage;
	
        try {
	    statement = conn.prepareStatement(query);
            statement.setInt(1, userType.getValue());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getNamePersonage());
            statement.setString(5, user.getAddress());
	    statement.setString(6, user.getEmail());
	    statement.setString(7, user.getLogin());
	    statement.setString(8, user.getPassword());
	    statement.setLong(9, user.getId());
            //statement.setLong(9, id);
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
    
    public void delete(Long userId) {
	String query = "DELETE FROM USERS2 WHERE Id = ?";
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
	    statement.setLong(1, userId);
	    statement.executeUpdate();
	}catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Поиск по наименованию персонажа
    public List<User> find(String namePersonage) {
	String query = "SELECT * FROM USERS2 WHERE namePersonage = ?";
	List<User> users;
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
	    statement.setString(1, namePersonage);
	    ResultSet rset = statement.executeQuery();
            users = getElementsFromResultSet(rset);
        }catch (SQLException ex) {
            users = null;
        }
	if (users == null || users.isEmpty()) {
	    return null;
	}
        return users;
    }
    
    //Поиск по фамилии клиента
    public List<User> find2(String surnameCustomer) {
        String query = "SELECT * FROM USERS2 WHERE surname = ?";
	List<User> users;
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query); 
	    statement.setString(1, surnameCustomer);
	    ResultSet rset = statement.executeQuery();
            users = getElementsFromResultSet(rset);
        }catch (SQLException ex) {
            users = null;
        }
	if (users == null || users.isEmpty()) {
	    return null;
        }
	return users;
    }
     
   // @Override
    public User find(long id) {
	String query = "SELECT * FROM USERS2 WHERE Id = ?";
	List<User> users;
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, id);
	    ResultSet rset = statement.executeQuery();
            users = getElementsFromResultSet(rset);
        }catch (SQLException ex) {
            users = null;
        }
	if (users == null || users.isEmpty()) {
	    return null;
	}
        User user = users.get(0);
	return user;
    }
        
    public List<User> getAllUsers(int type) {
	String query = "SELECT * FROM USERS2 WHERE type = ?";
	List<User> users;
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
	    statement.setLong(1, type);
	    ResultSet rset = statement.executeQuery();
            users = getElementsFromResultSet(rset);
        }catch (SQLException ex) {
            users = null;
        }
	if (users == null || users.isEmpty()) {
	    return null;
        }
        return users;
    }
}

