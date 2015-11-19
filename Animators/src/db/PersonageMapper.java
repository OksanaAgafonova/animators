/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import logic.*;

/**
 *
 * @author Оксана
 */

public class PersonageMapper extends AbstractMapper<Personage>{
    public enum PersonageParams {
	
        name("Name");
		
	private String value;
	
	private PersonageParams(String value) {
	    this.value = value;
	}
	
	public String getValue() {
	    return value;
	}
    }
   
    public Personage findByParam(PersonageParams param, String value) throws SQLException {
	/*String query = "SELECT * FROM Stores WHERE " + param.getValue() + " = '" + value + "'";
	
	try (Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(query.toString());
		ResultSet rset = statement.executeQuery()) {
	    List<Personage> stores = getElementsFromResultSet(rset);
	    if (stores != null && !stores.isEmpty()) {
		return stores.get(0);
	    }
	    return null;
	}*/
    return null;
    }
    
    public int insert(Personage personage){
        return 1;}

   /* @Override
      public int insert(Personage personage) throws SQLException {
	try (Connection conn = getConnection(); PreparedStatement statement = getInsertStatement(personage, conn)) {
	    statement.executeUpdate();
	    try (ResultSet keys = statement.getGeneratedKeys()) {
		if (keys == null || !keys.next()) {
		    return -1;
		}
		return keys.getInt(1);
	    }
	}
    }
      
       private PreparedStatement getInsertStatement(Personage personage, Connection conn) throws SQLException {
	String query = "INSERT INTO Personage(Type, Name, Surname, Email, NamePersonage, Login, "
		+ "Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement statement = null;
	try {
	    statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    statement.setInt(1, UserTypesEnum.Personage.getValue());
	    statement.setString(2, personage.getName());
	    statement.setString(3, personage.getSurname());
	    statement.setString(4, personage.getEmail());
            statement.setString(5, personage.getNamePersonage());
	    statement.setString(6, personage.getLogin());
	    statement.setString(7, personage.getPassword());
	    return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }*/

   // @Override
    public void update(Personage object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Personage object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public Personage find(long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Personage> getElementsFromResultSet(ResultSet rset) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

