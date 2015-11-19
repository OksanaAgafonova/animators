/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Service.Service;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.*;

/**
 *
 * @author Оксана
 */
public class OrderMapper extends AbstractMapper<Order> {
    
    SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formTime = new SimpleDateFormat("hh:mm a");
    
    @Override
    public int insert(Order order) {
        System.out.println("order.getDate 3"+order.getDate());
        System.out.println("order.getId3 "+order.getId());
        System.out.println("order.idtCustomer3 "+order.getCustomer().getId());
	try (Connection conn = getConnection(); PreparedStatement statement = getInsertStatement(order, conn)) {
            System.out.println("Проверка:   ");
            statement.executeUpdate();
	    try (ResultSet keys = statement.getGeneratedKeys()) {
		if (keys == null || !keys.next()) {
		    return -1;
		}
		return keys.getInt(1);
	    }
	}catch (SQLException ex) {
            return -1;
        }
    }
    private PreparedStatement getInsertStatement(Order order, Connection conn) throws SQLException {
        System.out.println("order.getDate 4"+order.getDate());
        System.out.println("order.getId4 "+order.getId());
        System.out.println("order.idtCustomer4 "+order.getCustomer().getId());
	String query = "INSERT INTO ORDERS2(idPersonage, idCustomer, adress, minut, summa, status, DATE_, TIME_, DEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println("order.getDate 5"+order.getDate());
        System.out.println("order.getId5 "+order.getId());
        System.out.println("order.idtCustomer 5 "+order.getCustomer().getId());
	PreparedStatement statement = null;
	try {
	    statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //System.out.println("ID:   "+ order.getId());
	    //statement.setLong(1, order.getId());
            statement.setObject(1, order.getPersonage().getId()); System.out.println("order.Personage "+order.getPersonage().getId());
            statement.setObject(2, order.getCustomer().getId());System.out.println("order.Customer "+order.getCustomer().getId());
            statement.setString(3, order.getAddress());System.out.println("order.Address "+order.getAddress());
            statement.setInt(4, order.getMinut());System.out.println("order.getMinut "+order.getMinut());
            statement.setInt(5, order.getSum());System.out.println("order.getSum "+order.getSum());
            statement.setString(6, order.getStatus());System.out.println("order.Status "+order.getStatus());
            statement.setString(7, formDate.format(order.getDate()));System.out.println("order.getDate "+order.getDate());
            statement.setString(8, formTime.format(order.getTime()));System.out.println("order.getTime "+order.getTime());
            statement.setBoolean(9, order.getDel());System.out.println("order.getTime "+order.getDel());
            
            return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }

    public void delete(Long orderId)throws SQLException {
       String query = "DELETE FROM ORDERS2 WHERE id = ?";
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setLong(1, orderId);
	    statement.executeUpdate();
	}
    }
    
    @Override
    public void delete(Order order) throws SQLException {
	delete(order.getId());
    }
    
    //@Override
    public void update(Order order) {
	try {
            Connection conn = getConnection();
            PreparedStatement statement = getUpdateStatement(order, conn);
	    statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PreparedStatement getUpdateStatement(Order order, Connection conn) throws SQLException {
	String query = "UPDATE ORDERS2 SET idPersonage = ?, idCustomer = ?, adress = ?, minut = ?, summa = ?, status = ?, date_ = ?, time_ = ?, del = ? WHERE id = ?";
	PreparedStatement statement = null;
       	try {
	    statement = conn.prepareStatement(query);
	    statement.setObject(1, order.getPersonage().getId());
            statement.setObject(2, order.getCustomer().getId());
	    statement.setString(3, order.getAddress());
            //ResultSet statement.getResultSet();
            //System.out.println("order.getAddress() "+  statement.getResultSet().getString("adress"));
	    statement.setLong(4, order.getMinut());
	    statement.setLong(5, order.getSum());
	    statement.setString(6, order.getStatus());
            statement.setString(7, formDate.format(order.getDate()));
	    statement.setString(8, formTime.format(order.getTime()));
            statement.setBoolean(9, order.getDel());
            statement.setLong(10, order.getId());
            return statement;
	} catch (SQLException ex) {
	    statement.close();
	    throw ex;
	}
    }
   
    @Override
    protected List<Order> getElementsFromResultSet(ResultSet rset) throws SQLException {
	List<Order> orders = new ArrayList<>();
	while (rset.next()) {
	    long id = rset.getLong("id");
	    User _personage = Service.find(rset.getLong("IdPersonage"));
            User _customer = Service.find(rset.getLong("idCustomer"));
	    String address = rset.getString("adress");
	    Date date = rset.getDate("date_");
            Time time = rset.getTime("time_");
	    int minut = rset.getInt("minut");
            int sum = rset.getInt("summa");
	    String status = rset.getString("status");
            boolean del = rset.getBoolean("del");

	    Order order;
	    order = new Order(id, _personage, _customer, address, date, time, minut, sum, status, del);
              System.out.println("ПРОВЕРКА: "+order.getStatus());
	    orders.add(order);
	}
	return orders;
    }

    public List<Order> getAllOrders() throws SQLException {
	String query = "SELECT * FROM ORDERS2";
	List<Order> orders;
	try (Connection conn = getConnection();
		Statement statement = conn.createStatement();
		ResultSet rset = statement.executeQuery(query)) {
            orders = getElementsFromResultSet(rset);
        }
	if (orders == null || orders.isEmpty()) {
	    return null;
	}
        return orders;
    }
    
    public List<Order> getAllOrders(boolean bool) throws SQLException {
	String query = "SELECT * FROM ORDERS2 WHERE DEL = ?";
	List<Order> orders;
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setBoolean(1, bool);
	    try (ResultSet rset = statement.executeQuery()) {
		orders = getElementsFromResultSet(rset);
	    }
	}
	if (orders == null || orders.isEmpty()) {
	    return null;
	}
        return orders;
    }
    
    public List<Order> getAllOrders(String _name) throws SQLException {
	String query = "SELECT * FROM ORDERS2 WHERE idPersonage = ?";
	List<Order> orders;
        List<User> users;
        users = Service.findNamePersonage(_name);
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setLong(1, users.get(0).getId());
	    try (ResultSet rset = statement.executeQuery()) {
		orders = getElementsFromResultSet(rset);
	    }
	}
	return orders;
    }
     
    // @Override
    public Order find(long id) throws SQLException {
	String query = "SELECT * FROM ORDERS2 WHERE Id = ?";
	List<Order> orders;
	try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
	    statement.setLong(1, id);
	    try (ResultSet rset = statement.executeQuery()) {
		orders = getElementsFromResultSet(rset);
	    }
	}
	if (orders == null || orders.isEmpty()) {
	    return null;
	}
        Order order = orders.get(0);
	return order;
    }
    
    //Поиск по idPersonage в таблице ORDERS2
    public List<Order> findIdPersonage(long id) {
        String query = "SELECT * FROM ORDERS2 WHERE idPersonage = ?";
	List<Order> orders;
	try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
	    statement.setLong(1, id);
            ResultSet rset = statement.executeQuery(); 
            orders = getElementsFromResultSet(rset);
        }catch (SQLException ex) {
            return null;
        }
        return orders;
    }
    
    //выставить заявку в состояние Принята/Выполнено.
    public void OrderAccepted(User user){
        
        Order order = null;
        
        if (user instanceof Admin) {
	    //Если заказ на рассмотрении, мы можем перевести его в статус Принят.
            if(order.getStatus().equals("На рассмотрении")){
                order.setStatus("Принят");
            }
        } 
        //Если заказ принят, мы можем перевести его в статус Выполнен.
        else if (user instanceof Personage) {
            if (order.getStatus().equals("Принята")){
                order.setStatus("Выполнено");
            }
        }
    }
   
}

