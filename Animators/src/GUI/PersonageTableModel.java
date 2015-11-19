/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logic.User;
/**
 *
 * @author Оксана
 */
public class PersonageTableModel extends AbstractTableModel{
    
    private String[] columnNames={"Id","Персонаж","Имя", "Фамилия", "E-mail"};
    String[][] data = null;
    ArrayList<User> personages;
        
    public PersonageTableModel(ArrayList<User> personages) throws SQLException {
        this.personages = personages;
        data = new String[personages.size()][5];
        if (personages.size()!= 0)
            for(int i=0; i < personages.size();i++){
                data[i][0]=Long.toString(personages.get(i).getId());
                data[i][1]=personages.get(i).getNamePersonage();
                data[i][2]=""+personages.get(i).getName();
                data[i][3]=""+personages.get(i).getSurname();
                data[i][4]=""+personages.get(i).getEmail();
            }
     //fireTableDataChanged();//обновляем данные
    }

    @Override
    public int getRowCount() {
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return data[rowIndex][columnIndex];
    }
    
    public void setValueAt(String value, int rowIndex, int columnIndex){
      data[rowIndex][columnIndex] = value;
    }
   
    public void removeRow(int rowIndex){
        for(int i=0; i < rowIndex;i++){
            for(int j=0; j < getColumnCount();j++){
                data[i][j] =data[i][j];
                System.out.println(data[i][j]);
            }          
        }
        for(int i=rowIndex; i < getRowCount()-1;i++){
            for(int j=0; j < getColumnCount();j++){
                data[i][j] =data[i+1][j];
            }
        }
        fireTableDataChanged();//обновляем данные 
    }
        
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
}
