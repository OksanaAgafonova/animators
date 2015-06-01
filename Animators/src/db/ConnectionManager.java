/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Оксана
 */
public class ConnectionManager {
    private static final String url = "";
    private static final String user = "";
    private static final String password = "";

    public void closeConnection(Connection connection) throws SQLException {
	if (connection != null) {
	    connection.close();
	}
    }

    Connection getConnection()throws SQLException {
	Connection conn = DriverManager.getConnection(url /*+ ";create=true"*/, user, password);
	conn.setAutoCommit(true);
	return conn;
    }
    
}
