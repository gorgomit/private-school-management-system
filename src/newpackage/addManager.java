/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author İzzet Yılmaz
 */
public class addManager extends javax.swing.JFrame {

    /**
     * Creates new form addInstructor
     */
    int mainId = 0;
    int mainMode = 0;
    Connect cn = new Connect();
    Connection con=cn.ConnectDB();
    Statement statement = null;
    int mainAddress = 0;
    
    public addManager() {
        initComponents();
    }
    public addManager(int id) throws SQLException
    {
        initComponents();
        mainId = id;
        addButton.setText("UPDATE");
        mainMode = 1;
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name,address_id,salary,surname,password,city,district,detail,phone_number FROM staff JOIN staff_address ON staff.staff_id = staff_address.staff_id JOIN staff_phone ON staff_address.staff_id = staff_phone.staff_id WHERE staff.staff_id = " + mainId);
        if(rs.next()){
            mngName.setText(rs.getString("name"));
            mngSurname.setText(rs.getString("surname"));
            mngPass.setText(rs.getString("password"));
            mngAdress.setText(rs.getString("detail"));
            mngCity.setText(rs.getString("city"));
            mngDistrict.setText(rs.getString("district"));
            mngPhone.setText(rs.getString("phone_number"));
            mngSalary.setText(rs.getString("salary"));
            mainAddress = rs.getInt("address_id");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mngAdress = new javax.swing.JTextArea();
        mngPhone = new javax.swing.JTextField();
        mngCity = new javax.swing.JTextField();
        mngDistrict = new javax.swing.JTextField();
        mngName = new javax.swing.JTextField();
        mngSurname = new javax.swing.JTextField();
        mngSalary = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        mngPass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Surname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Salary:");

        jLabel5.setText("Phone Number:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("City:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("District:");

        mngAdress.setColumns(20);
        mngAdress.setLineWrap(true);
        mngAdress.setRows(5);
        jScrollPane1.setViewportView(mngAdress);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mngName, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(mngPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mngSurname)
                                    .addComponent(mngSalary)
                                    .addComponent(mngPass))
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(mngCity, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(mngDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(mngPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mngName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mngSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(mngPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mngSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(mngCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mngDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if(mainMode==1){
            try {
                statement = con.createStatement();
                String query = "UPDATE staff SET staff.name = '" + (String) mngName.getText() + "', staff.surname = '" + mngSurname.getText() + "',  staff.password='" + mngPass.getText() + "', staff.salary = '" + mngSalary.getText() + "' WHERE staff.staff_id = " + mainId;
                statement.executeUpdate(query);
                query = "UPDATE staff_address SET staff_address.city= '" + mngCity.getText() + "', staff_address.district= '" + mngDistrict.getText() + "',  staff_address.detail= '" + mngAdress.getText() + "' WHERE staff_address.address_id = " + mainAddress;
                statement.executeUpdate(query);
                query = "UPDATE staff_phone SET staff_phone.phone_number = '" + mngPhone.getText() + "' WHERE staff_phone.staff_id = " + mainId;
                statement.executeUpdate(query);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(addManager.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }
            
        }else{
            if(mngName.getText().equals("") || mngSurname.getText().equals("") || mngPass.getText().equals("") || mngPhone.getText().equals("") || mngSalary.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Fill In All Important Fields!");
            }
            else{
                int cnt=1;
                if(!"".equals(mngCity.getText()) && !"".equals(mngDistrict.getText()) && !"".equals(mngAdress.getText()))
                    cnt=2;
                if("".equals(mngCity.getText()) && "".equals(mngDistrict.getText()) && "".equals(mngAdress.getText()))
                    cnt=3;
                if(cnt==1)
                    JOptionPane.showMessageDialog(this, "Please Enter Address' All Contents!");
                else{
                    String currentID=null;
                    try {
                        String addManagerQuery = "INSERT INTO staff (staff_id,name,surname,password,salary,role_id) VALUES (null, '"+mngName.getText()+"', '"+mngSurname.getText()+"', '"+mngPass.getText()+"',"+mngSalary.getText()+" , 1);";
                        System.out.println(addManagerQuery);
                        statement = con.createStatement();
                        int rs = statement.executeUpdate(addManagerQuery);
                        System.out.println(rs);
                        cn.DisconnectDB(con);
                        statement = null;
                        /*************FIND CURRENT ID*******************/
                        //cn = new Connect();
                        con=cn.ConnectDB();

                        String findCurrentIDQuery="SELECT MAX(staff_id) FROM staff;";
                        System.out.println(findCurrentIDQuery);

                        try {
                            statement = con.createStatement();
                            try (ResultSet res = statement.executeQuery(findCurrentIDQuery)) {
                                while(res.next()){
                                    int id = res.getInt("MAX(staff_id)");
                                    currentID=String.valueOf(id);
                                    //System.out.println(currentID);
                                }
                            }
                            cn.DisconnectDB(con);
                            statement=null;
                        } catch (SQLException ex) {
                            //System.out.println("dsaklfja");
                            Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex);
                        }
                        /***************************************/

                        /********/
                        con=cn.ConnectDB();
                        String addPhoneQuery="INSERT INTO staff_phone (phone_number, staff_id) VALUES ('"+mngPhone.getText()+"', "+currentID+");";
                        System.out.println(addPhoneQuery);
                        try {
                            statement = con.createStatement();
                            statement.executeUpdate(addPhoneQuery);
                            cn.DisconnectDB(con);
                            statement=null;
                        } catch (SQLException ex) {
                            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex);
                        }
                        /********/
                        if(cnt==2){
                            if(currentID!=null){
                                String addAddresQuery="INSERT INTO staff_address (city, district, detail, address_id, staff_id) VALUES ('"+mngCity.getText()+"', '"+mngDistrict.getText()+"', '"+mngAdress.getText()+"', NULL, "+currentID+");";
                                System.out.println(addAddresQuery);
                                con=cn.ConnectDB();
                                try {
                                    statement = con.createStatement();
                                    rs = statement.executeUpdate(addAddresQuery);
                                    cn.DisconnectDB(con);
                                    statement=null;
                                } catch (SQLException ex) {
                                    Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
                                    JOptionPane.showMessageDialog(this, ex);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "ERROR! ADDRESS ");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(addManager.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Successful!!");
        dispose();
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(addInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mngAdress;
    private javax.swing.JTextField mngCity;
    private javax.swing.JTextField mngDistrict;
    private javax.swing.JTextField mngName;
    private javax.swing.JTextField mngPass;
    private javax.swing.JTextField mngPhone;
    private javax.swing.JTextField mngSalary;
    private javax.swing.JTextField mngSurname;
    // End of variables declaration//GEN-END:variables
}
