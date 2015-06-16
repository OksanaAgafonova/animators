/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logic.*;

/**
 *
 * @author Оксана
 */
public class OrderMapper extends AbstractMapper<Order> {

    public int insert(Order order) throws SQLException {
	try (Connection conn = getConnection(); PreparedStatement statement = getInsertStatement(order, conn)) {
	    statement.executeUpdate();
	    try (ResultSet keys = statement.getGeneratedKeys()) {
		if (keys == null || !keys.next()) {
		    return -1;
		}
		return keys.getInt(1);
	    }
	}
    }
    private PreparedStatement getInsertStatement(Order order, Connection conn) throws SQLException {
	String query = "INSERT INTO Users(Type, Address, Date, Time, Minut, "
		+ "Sum, Status) VALUES (?, ?, ?, ?, ?, ?)";
	PreparedStatement statement = null;
	try {
	    statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	  //  statement.setInt(1, type);
	    statement.setString(2, order.getAddress());
	    statement.setDate(3, (Date) order.getDate());
	    statement.setTime(4,  order.getTime());
	    statement.setLong(5, order.getMinut());
	    statement.setLong(6, order.getSum());
            statement.setString(7, order.getStatus());
	    return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }

    public void delete(Long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order find(long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Order> getElementsFromResultSet(ResultSet rset) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
