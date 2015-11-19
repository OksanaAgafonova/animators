/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logic.Order;

/**
 *
 * @author Оксана
 */

public class OrdersTableModel extends AbstractTableModel{
    
    private String[] columnNames={"Id","Personage","Customer","Adress","Date","Time","Minut","Summa","Status"};
    String[][] data2 = null;
    ArrayList<Order> orders;
    
    public OrdersTableModel(ArrayList<Order> orders) throws SQLException {
        this.orders = orders;
        data2 = new String[orders.size()][9];
        if (orders.size()!= 0)
            for(int i=0; i < orders.size();i++){
                data2[i][0]=Long.toString(orders.get(i).getId());
                data2[i][1]=orders.get(i).getPersonage().getNamePersonage();
                data2[i][2]=""+orders.get(i).getCustomer().getSurname();
                data2[i][3]=""+orders.get(i).getAddress();
                data2[i][4]=""+orders.get(i).getDate();
                data2[i][5]=""+orders.get(i).getTime();
                data2[i][6]=""+Integer.toString(orders.get(i).getMinut());
                data2[i][7]=""+Integer.toString(orders.get(i).getSum());
                data2[i][8]=""+orders.get(i).getStatus();
            }
     fireTableDataChanged();//обновляем данные
    }

    @Override
    public int getRowCount() {
        return this.data2.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data2[rowIndex][columnIndex];
    }
    
    public void setValueAt(String value, int rowIndex, int columnIndex){
      data2[rowIndex][columnIndex] = value;
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }
}
