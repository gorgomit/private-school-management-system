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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kemal-PC-2
 */
public class addInstructor extends javax.swing.JFrame {

    /**
     * Creates new form addInstructor
     */
    int mainId = 0;
    int mainMode = 0;
    Connect cn = new Connect();
    Connection con=cn.ConnectDB();
    Statement statement = null;
    int mainAddress = 0;
    
    public addInstructor() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)allCourses.getModel();
        model.setRowCount(0);
        
        try {
            statement = con.createStatement();
            String showBooksQuery = "SELECT course_name FROM course;";
            ResultSet rs=statement.executeQuery(showBooksQuery);
            while(rs.next()){
                String name = rs.getString("course_name");
                Object[] adding = {name};
                model.addRow(adding);
                //System.out.println("Buradauoö");
            }
            
            System.out.println(model.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public addInstructor(int id) throws SQLException {
        initComponents();
        mainId=id;
        String mId=String.valueOf(id);
        System.out.println(mId);
        addButton.setText("UPDATE");
        mainMode = 1;
        con = cn.ConnectDB();
        statement = con.createStatement();
        //System.out.println("60 okke");
        ResultSet rs = statement.executeQuery("SELECT name,address_id,salary,surname,password,city,district,detail,phone_number FROM staff JOIN staff_address ON staff.staff_id = staff_address.staff_id JOIN staff_phone ON staff_address.staff_id = staff_phone.staff_id WHERE staff.staff_id = " + mId+";");
        //System.out.println("61 okke");
        if(rs.next()){
            //System.out.println("rs ye giriyor");
            insName.setText(rs.getString("name"));
            //System.out.println(insName);
            insSurname.setText(rs.getString("surname"));
            //System.out.println(insSurname);
            insPass.setText(rs.getString("password"));
            //System.out.println(insPass);
            insAddress.setText(rs.getString("detail"));
            //System.out.println(insAddress);
            insCity.setText(rs.getString("city"));
            //System.out.println(insCity);
            insDistrict.setText(rs.getString("district"));
            //System.out.println(insDistrict);
            insPhone.setText(rs.getString("phone_number"));
            //System.out.println(insPhone);
            insSalary.setText(rs.getString("salary"));
            //System.out.println(insSalary);
            mainAddress = rs.getInt("address_id");
        }
        
        rs.close();
        statement=null;
        DefaultTableModel model = (DefaultTableModel)allCourses.getModel();
        model.setRowCount(0);
        
        try {
            statement = con.createStatement();
            String showBooksQuery = "SELECT course_name FROM course;";
            rs=statement.executeQuery(showBooksQuery);
            while(rs.next()){
                String name = rs.getString("course_name");
                Object[] adding = {name};
                model.addRow(adding);
                //System.out.println("Buradauoö");
            }
            
            System.out.println(model.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement = null;
        DefaultTableModel newmodel = (DefaultTableModel)addingCourses.getModel();
        newmodel.setRowCount(0);
        
        statement = con.createStatement();
        String showCourseQuery = "SELECT course.course_name FROM giving_by JOIN course ON giving_by.course_id = course.course_id WHERE instructor_id IN ("+id+") ";
        rs=statement.executeQuery(showCourseQuery);
        while(rs.next()){
            String crName = rs.getString("course_name");
            Object[] adding = {crName};
            newmodel.addRow(adding);
            
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
        insAddress = new javax.swing.JTextArea();
        insPhone = new javax.swing.JTextField();
        insCity = new javax.swing.JTextField();
        insDistrict = new javax.swing.JTextField();
        insSurname = new javax.swing.JTextField();
        insName = new javax.swing.JTextField();
        insSalary = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        insPass = new javax.swing.JTextField();
        deleteCourse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        addingCourses = new javax.swing.JTable();
        addCourse = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        allCourses = new javax.swing.JTable();

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
        jLabel7.setText("Adress:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("City:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("District:");

        insAddress.setColumns(20);
        insAddress.setLineWrap(true);
        insAddress.setRows(5);
        jScrollPane1.setViewportView(insAddress);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteCourse.setText("Delete Selected Course");
        deleteCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCourseMouseClicked(evt);
            }
        });
        deleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });

        addingCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADDING COURSES"
            }
        ));
        jScrollPane2.setViewportView(addingCourses);

        addCourse.setText("Add Selected Course");
        addCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseMouseClicked(evt);
            }
        });
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        allCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ALL COURSES"
            }
        ));
        jScrollPane3.setViewportView(allCourses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insSurname)
                            .addComponent(insName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(insSalary)
                            .addComponent(insPass))
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(deleteCourse)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insDistrict, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(insCity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(insPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(insSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCourse)
                        .addGap(83, 83, 83)
                        .addComponent(deleteCourse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        con=cn.ConnectDB();
        statement=null;
        if(mainMode==1){
            if(insName.getText().equals("") || insSurname.getText().equals("") || insPass.getText().equals("") || insSalary.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Fill In All Important Fields!");
            }else{
                try {
                    statement = con.createStatement();
                    String query = "UPDATE staff SET name = '" + insName.getText() + "', surname = '"+ (String) insSurname.getText() +  "',  password='" + insPass.getText() + "', salary = '" + insSalary.getText() + "' WHERE staff_id = " + mainId;
                    statement.executeUpdate(query);
                    if(insCity.getText().equals("") && insDistrict.getText().equals("") && insAddress.getText().equals("")){
                        query="DELETE FROM staff_address WHERE staff_id = "+mainId;
                        statement.executeUpdate(query);
                    }else if(!insCity.getText().equals("") && !insDistrict.getText().equals("") && !insAddress.getText().equals("")){
                        query = "UPDATE staff_address SET city= '" + insCity.getText() + "', district= '" + insDistrict.getText() + "',  detail= '" + insAddress.getText() + "' WHERE address_id = " + mainAddress;
                        statement.executeUpdate(query);
                    }else{
                        JOptionPane.showMessageDialog(this, "ENTER ADDRESS' ALL COMPONENTS!");
                    }
                    if(!insPhone.getText().equals("")){
                        query = "UPDATE staff_phone SET staff_phone.phone_number = '" + insPhone.getText() + "' WHERE staff_phone.staff_id = " + mainId;
                        statement.executeUpdate(query);
                    }
                    
                    
                    cn.DisconnectDB(con);
                    statement=null;
                    this.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(addManager.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }


                /************/
                DefaultTableModel newmodel = (DefaultTableModel)addingCourses.getModel();
                int rows = addingCourses.getRowCount();
                int cRow=0;
                int[] rowsID = new int[rows];
                while(cRow<rows){
                    con = cn.ConnectDB();
                    String findCourseID = "SELECT course_id FROM course WHERE course_name='"+addingCourses.getValueAt(cRow,0)+"'";
                    try {
                        statement = con.createStatement();
                        ResultSet rs = statement.executeQuery(findCourseID);
                        while(rs.next()){
                            rowsID[cRow] = rs.getInt("course_id");
                        }
                        rs.close();
                        cn.DisconnectDB(con);
                        statement=null;
                    } catch (SQLException ex) {
                        Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cRow++;
                }
                String[] rowsIdString = new String[rows];
                while(cRow>0){
                    cRow--;
                    rowsIdString[cRow] = String.valueOf(rowsID[cRow]);
                }
                con = cn.ConnectDB();
                String deleteAllCourse="DELETE FROM giving_by WHERE giving_by.instructor_id IN("+mainId+")";
                try {
                    statement = con.createStatement();
                    statement.executeUpdate(deleteAllCourse);
                } catch (SQLException ex) {
                    Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                }
                statement=null;
                cn.DisconnectDB(con);
                while(cRow<rows){
                    con = cn.ConnectDB();
                    String AddCourseQuery="INSERT INTO giving_by (course_id, instructor_id) VALUES ("+rowsIdString[cRow]+", "+mainId+");";
                    try {
                        statement = con.createStatement();
                        statement.executeUpdate(AddCourseQuery);
                        cn.DisconnectDB(con);
                        statement=null;
                    } catch (SQLException ex) {
                        Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cRow++;
                }
                JOptionPane.showMessageDialog(this, "successful");
            }
            /************/
        }else{
            if(insName.getText().equals("") || insSurname.getText().equals("") || insPass.getText().equals("") || insSalary.getText().equals("") || insPhone.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Fill In All Important Fields!");
            }else{
                
                int cnt=1;
                if(!insAddress.getText().equals("") && !insDistrict.getText().equals("") && !insCity.getText().equals(""))
                    cnt=2;
                if(insAddress.getText().equals("") && insDistrict.getText().equals("") && insCity.getText().equals(""))
                    cnt=3;
                if(cnt==1){
                    JOptionPane.showMessageDialog(this, "Please Enter Address' All Contents!");
                }else{
                    String currentID = null;
                    String addInstructorQuery = "INSERT INTO staff (staff_id, name, surname, password, salary, role_id) VALUES (NULL, '"+insName.getText()+"', '"+insSurname.getText()+"', '"+insPass.getText()+"', "+insSalary.getText()+", 2);";
                    try {
                        statement = con.createStatement();
                        statement.executeUpdate(addInstructorQuery);
                        statement=null;
                        cn.DisconnectDB(con);
                    } catch (SQLException ex) {
                        Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /*************FIND CURRENT ID*******************/
                    //cn = new Connect();
                    con=cn.ConnectDB();
                    String findCurrentIDQuery="SELECT MAX(staff_id) FROM staff;";
                    System.out.println(findCurrentIDQuery);

                    try {
                        statement = con.createStatement();
                        ResultSet rs = statement.executeQuery(findCurrentIDQuery);
                        while(rs.next()){
                            int id = rs.getInt("MAX(staff_id)");
                            currentID=String.valueOf(id);
                            //System.out.println(currentID);
                        }
                        rs.close();
                        cn.DisconnectDB(con);
                        statement=null;
                    } catch (SQLException ex) {
                        //System.out.println("dsaklfja");
                        Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /***************************************/
                    /**************/
                    con=cn.ConnectDB();
                    String addInstoInsQuery = "INSERT INTO instructor (instructor_id) VALUES ("+currentID+")";
                    System.out.println(addInstoInsQuery);
                    
                    try {
                        statement = con.createStatement();
                        statement.executeUpdate(addInstoInsQuery);
                        cn.DisconnectDB(con);
                        statement=null;
                    } catch (SQLException ex) {
                        Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /**************/
                    /********/
                    con=cn.ConnectDB();
                    String addPhoneQuery="INSERT INTO staff_phone (phone_number, staff_id) VALUES ('"+insPhone.getText()+"', "+currentID+");";
                    System.out.println(addPhoneQuery);
                    try {
                        statement = con.createStatement();
                        statement.executeUpdate(addPhoneQuery);
                        cn.DisconnectDB(con);
                        statement=null;
                    } catch (SQLException ex) {
                        Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /********/
                    if(cnt==2){
                        String addAddressQuery = "INSERT INTO staff_address (address_id, city, district, detail, staff_id) VALUES (NULL, '"+insCity.getText()+"', '"+insDistrict.getText()+"', '"+insAddress.getText()+"', "+currentID+");";
                        con=cn.ConnectDB();
                        try {
                            statement = con.createStatement();
                            statement.executeUpdate(addAddressQuery);
                            statement = null;
                            cn.DisconnectDB(con);
                        } catch (SQLException ex) {
                            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        con=cn.ConnectDB();
                        try {
                            statement = con.createStatement();
                            statement.executeUpdate("DELETE FROM staff_address WHERE staff_id="+currentID);
                            statement=null;
                            cn.DisconnectDB(con);
                        } catch (SQLException ex) {
                            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    DefaultTableModel newmodel = (DefaultTableModel)addingCourses.getModel();
                    int rows = addingCourses.getRowCount();
                    int cRow=0;
                    int[] rowsID = new int[rows];
                    while(cRow<rows){
                        con = cn.ConnectDB();
                        String findCourseID = "SELECT course_id FROM course WHERE course_name='"+addingCourses.getValueAt(cRow,0)+"'";
                        try {
                            statement = con.createStatement();
                            ResultSet rs = statement.executeQuery(findCourseID);
                            while(rs.next()){
                                rowsID[cRow] = rs.getInt("course_id");
                            }
                            rs.close();
                            cn.DisconnectDB(con);
                            statement=null;
                        } catch (SQLException ex) {
                            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cRow++;
                    }
                    String[] rowsIdString = new String[rows];
                    while(cRow>0){
                        cRow--;
                        rowsIdString[cRow] = String.valueOf(rowsID[cRow]);
                    }
                    while(cRow<rows){
                        con = cn.ConnectDB();
                        String AddCourseQuery="INSERT INTO giving_by (course_id, instructor_id) VALUES ("+rowsIdString[cRow]+", "+currentID+");";
                        try {
                            statement = con.createStatement();
                            statement.executeUpdate(AddCourseQuery);
                            cn.DisconnectDB(con);
                            statement=null;
                        } catch (SQLException ex) {
                            Logger.getLogger(addInstructor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cRow++;
                    }
                }
                JOptionPane.showMessageDialog(this, "successful");
            }
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCourseMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)allCourses.getModel();
        DefaultTableModel newmodel = (DefaultTableModel)addingCourses.getModel();
        int selected_row = addingCourses.getSelectedRow();
        if(selected_row == -1)  JOptionPane.showMessageDialog(this, "Select a Row!");
        else{
            String nameC =  (String) newmodel.getValueAt(selected_row, 0);
            System.out.println(nameC);
            newmodel.removeRow(addingCourses.getSelectedRow());
        }
    }//GEN-LAST:event_deleteCourseMouseClicked

    private void deleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteCourseActionPerformed

    private void addCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCourseMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)allCourses.getModel();
        DefaultTableModel newmodel = (DefaultTableModel)addingCourses.getModel();
        int selected_row = allCourses.getSelectedRow(),cRow=0,rowCount=newmodel.getRowCount();
        boolean control=false;
        if(selected_row == -1)  JOptionPane.showMessageDialog(this, "Select a Row!");
        else{
            String nameC =  (String) model.getValueAt(selected_row, 0);
            //System.out.println(nameC);
            //String cName = String.valueOf(addingCourses.getValueAt(selected_row,0));
            while(cRow<rowCount){
                if(nameC.equals(String.valueOf(addingCourses.getValueAt(cRow, 0)))){
                    control = true;
                }
                cRow++;
            }
            if(!control){
                Object[] adding = {nameC};
                newmodel.addRow(adding);
            }else{
                JOptionPane.showMessageDialog(this, "you have already selected this course");
            }
        }
    }//GEN-LAST:event_addCourseMouseClicked

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCourseActionPerformed

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
                new addInstructor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addCourse;
    private javax.swing.JTable addingCourses;
    private javax.swing.JTable allCourses;
    private javax.swing.JButton deleteCourse;
    private javax.swing.JTextArea insAddress;
    private javax.swing.JTextField insCity;
    private javax.swing.JTextField insDistrict;
    private javax.swing.JTextField insName;
    private javax.swing.JTextField insPass;
    private javax.swing.JTextField insPhone;
    private javax.swing.JTextField insSalary;
    private javax.swing.JTextField insSurname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
