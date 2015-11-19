/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.Service;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Order;
import logic.User;

/**
 *
 * @author Оксана
 */
public class AddOrderFrame extends javax.swing.JFrame {
    ArrayList<User> personages;
    ArrayList<User> customer;
    public Personage personage = new Personage();
    Order order, order2;
    Object selectedItem1, selectedItem2, selectedItem3;
    List<User> users;
    List<User> users_;
    String[] statusZ = {"На рассмотрении", "Принят", "Выполнен", "Отказ"};
    
    SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formTime = new SimpleDateFormat("HH:mm");
    
    //Запонение выпадающего списка Personage
    public void getCBListPersonage() throws SQLException{
        personages =  (ArrayList<User>) Service.getAll(2);
        if (personages.size()!= 0)
            for(int i=0; i < personages.size();i++){
                cbPersonage.addItem(personages.get(i).getNamePersonage());
            }
    }
    //Запонение выпадающего списка Customer
    public void getCBListCustomer() throws SQLException{
        customer =  (ArrayList<User>) Service.getAll(1);
        if (customer.size()!= 0)
            for(int i=0; i < customer.size();i++){
                cbCustomer.addItem(customer.get(i).getSurname());
            }
    }

    public AddOrderFrame() throws SQLException {
        super("New order"); 
        initComponents();
        buttonOk.setText("OK");
        jLabel1.setVisible(false);
        editId.setVisible(false);
        this.getCBListPersonage();
        this.getCBListCustomer();
    }
    
    public AddOrderFrame(Order order) throws SQLException {
        super("Edit Order"); 
        initComponents();
        this.order2 = order;
        jLabel1.setVisible(true);
        editId.setEnabled(false);
        editId.setText(Long.toString(order.getId()));
        cbCustomer.addItem(order.getCustomer().getSurname());
        cbPersonage.addItem(order.getPersonage().getNamePersonage());
        cbStatus.addItem(order.getStatus());
        //cbCustomer.setSelectedItem((User.findSurnameCustomer(order.getCustomer().getSurname())).toString());
        //cbPersonage.setSelectedItem((User.findNamePersonage(order.getPersonage().getNamePersonage())).toString());
        editAdress.setText(order.getAddress());
        editDate.setText(formDate.format(order.getDate()));
        editTime.setText(formTime.format(order.getTime()));
        editMinut.setText(Integer.toString(order.getMinut()));
        editSumma.setText(Integer.toString(order.getSum()));
        buttonOk.setText("Save");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editAdress = new javax.swing.JTextField();
        editSumma = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editMinut = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton();
        cbStatus = new javax.swing.JComboBox();
        cbCustomer = new javax.swing.JComboBox();
        cbPersonage = new javax.swing.JComboBox();
        editDate = new javax.swing.JFormattedTextField();
        editTime = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Order");

        jLabel2.setText("Customer");

        jLabel3.setText("Personage");

        jLabel4.setText("Date");

        jLabel5.setText("Time");

        jLabel9.setText("Adress");

        jLabel6.setText("the number of minutes");

        jLabel7.setText("Summa");

        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        buttonOk.setText("OK");
        buttonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOkMouseClicked(evt);
            }
        });
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        cbStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbStatusMouseClicked(evt);
            }
        });
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(buttonOk))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        cbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbCustomerMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbCustomerMousePressed(evt);
            }
        });
        cbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCustomerItemStateChanged(evt);
            }
        });
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        cbPersonage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPersonageMouseClicked(evt);
            }
        });
        cbPersonage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPersonageItemStateChanged(evt);
            }
        });
        cbPersonage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonageActionPerformed(evt);
            }
        });

        try {
            editDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            editTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCustomer, 0, 143, Short.MAX_VALUE)
                            .addComponent(cbPersonage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editId)
                            .addComponent(editAdress)
                            .addComponent(editMinut)
                            .addComponent(editSumma)
                            .addComponent(editDate)
                            .addComponent(editTime))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPersonage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(editAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(editTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editMinut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editSumma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void buttonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkMouseClicked
        try {
            
            long millis = (formTime.parse(editTime.getText())).getTime();
            long second = (millis / 1000) % 60;
            long minute = (millis / (1000 * 60)) % 60;
            long hour = (millis / (1000 * 60 * 60)) % 24;
            String time = String.format("%02d:%02d:%02d:%d", hour+3, minute, second, millis);
            java.sql.Time timeValue = new java.sql.Time(formTime.parse(time).getTime());
            
            //users  = Service.findNamePersonage(selectedItem2.toString());
            //users_ = Service.findSurnameCustomer(selectedItem1.toString());
            if (buttonOk.getText() != "Save"){ 
                //Order order = new Order(Service.find(users.get(0).getId()),Service.find(users_.get(0).getId()),
                //    editAdress.getText(), (Date) formDate.parse(editDate.getText()), timeValue,
                //    Integer.valueOf(editMinut.getText()),Integer.valueOf(editSumma.getText()),  selectedItem3.toString(), Boolean.parseBoolean("False"));
              //  System.out.println("order.getDate1 "+order.getDate());
              //  System.out.println("order.getId1 "+order.getId());
              //  System.out.println("order.idtCustomer1 "+order.getCustomer().getId());
                Service.addOrder(selectedItem2.toString(),selectedItem1.toString(),
                    editAdress.getText(), (Date) formDate.parse(editDate.getText()), timeValue,
                    Integer.valueOf(editMinut.getText()),Integer.valueOf(editSumma.getText()),  selectedItem3.toString(), Boolean.parseBoolean("False"));
              
                this.setVisible(false);
            }
            else {
                
                //Order order3 = new Order(order2.getId(), Service.find(users.get(0).getId()),Service.find(users_.get(0).getId()),
                //    editAdress.getText(), (Date) formDate.parse(editDate.getText()),  timeValue,
                //    Integer.valueOf(editMinut.getText()),Integer.valueOf(editSumma.getText()),  selectedItem3.toString(), Boolean.parseBoolean("False"));
                Service.updateOrder(Long.valueOf(editId.getText()), selectedItem2.toString(),selectedItem1.toString(),
                    editAdress.getText(), (Date) formDate.parse(editDate.getText()),  timeValue,
                    Integer.valueOf(editMinut.getText()),Integer.valueOf(editSumma.getText()),  selectedItem3.toString(), Boolean.parseBoolean("False"));
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddPersonageFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AddOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonOkMouseClicked

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
       selectedItem1 = cbCustomer.getSelectedItem();
        
    }//GEN-LAST:event_cbCustomerActionPerformed

    private void cbPersonageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonageActionPerformed
       selectedItem2 = cbPersonage.getSelectedItem();
         
    }//GEN-LAST:event_cbPersonageActionPerformed

    private void cbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCustomerMouseClicked
        try {
            cbCustomer. removeAllItems();
            this.getCBListCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(AddOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbCustomerMouseClicked

    private void cbPersonageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPersonageMouseClicked
        try {
            cbPersonage.removeAllItems();
            this.getCBListPersonage();
        } catch (SQLException ex) {
            Logger.getLogger(AddOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbPersonageMouseClicked

    private void cbCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCustomerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCustomerMouseEntered

    private void cbCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCustomerMousePressed
        
    }//GEN-LAST:event_cbCustomerMousePressed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        selectedItem3 = cbStatus.getSelectedItem();
    }//GEN-LAST:event_cbStatusActionPerformed

    private void cbStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbStatusMouseClicked
        cbStatus.removeAllItems();
        for(int i=0; i < statusZ.length;i++){
            cbStatus.addItem(statusZ[i]);
        }
        //сbStatus.setSelectedItem(customer.get(i).getSurname());
    }//GEN-LAST:event_cbStatusMouseClicked

    private void cbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCustomerItemStateChanged
      
    }//GEN-LAST:event_cbCustomerItemStateChanged

    private void cbPersonageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPersonageItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPersonageItemStateChanged

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddOrderFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOk;
    private javax.swing.JComboBox cbCustomer;
    private javax.swing.JComboBox cbPersonage;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JTextField editAdress;
    private javax.swing.JFormattedTextField editDate;
    private javax.swing.JTextField editId;
    private javax.swing.JTextField editMinut;
    private javax.swing.JTextField editSumma;
    private javax.swing.JFormattedTextField editTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
