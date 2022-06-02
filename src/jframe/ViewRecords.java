/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class ViewRecords extends javax.swing.JFrame {

    
    DefaultTableModel model;
    
    
    /**
     * Creates new form ViewRecords
     */
    public ViewRecords() {
        initComponents();
        setRecordDetails();
    }
    
    // to set the book details in the table
    public void setRecordDetails(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            
            Statement st = con.createStatement();
            ResultSet rs =  st.executeQuery("Select * from issue_book_details");
            
            while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object [] obj = {id,bookName,studentName,issueDate,dueDate,status};                // using a model to set the values in the table
                model = (DefaultTableModel)tbl_recordDetails.getModel();
                // using the array to add data in the table
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }
    
    // method to clear table   
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_recordDetails.getModel();
        model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_heading = new javax.swing.JPanel();
        lbl_Heading = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        date_FromDate = new rojeru_san.componentes.RSDateChooser();
        lbl_IssueDate = new javax.swing.JLabel();
        lbl_DueDate = new javax.swing.JLabel();
        date_ToDate = new rojeru_san.componentes.RSDateChooser();
        btn_search = new necesario.RSMaterialButtonCircle();
        btnBack = new javax.swing.JPanel();
        lblBackManageBooks1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_recordDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_heading.setBackground(new java.awt.Color(102, 102, 255));
        panel_heading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Heading.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        lbl_Heading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Heading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        lbl_Heading.setText("  Issue Book Details");
        panel_heading.add(lbl_Heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 330, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_heading.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 360, 5));

        date_FromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_FromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_FromDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_FromDate.setPlaceholder("Select Issue Date");
        panel_heading.add(date_FromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 350, -1));

        lbl_IssueDate.setBackground(new java.awt.Color(255, 255, 255));
        lbl_IssueDate.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lbl_IssueDate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_IssueDate.setText("Issue Date :");
        panel_heading.add(lbl_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 110, 30));

        lbl_DueDate.setBackground(new java.awt.Color(255, 255, 255));
        lbl_DueDate.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lbl_DueDate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DueDate.setText("Due Date :");
        panel_heading.add(lbl_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 110, 30));

        date_ToDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_ToDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_ToDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_ToDate.setPlaceholder("Select Issue Date");
        panel_heading.add(date_ToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 350, -1));

        btn_search.setBackground(new java.awt.Color(255, 51, 51));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        panel_heading.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 200, 170, 60));

        btnBack.setBackground(new java.awt.Color(255, 51, 51));
        btnBack.setPreferredSize(new java.awt.Dimension(120, 60));

        lblBackManageBooks1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBackManageBooks1.setForeground(new java.awt.Color(255, 255, 255));
        lblBackManageBooks1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        lblBackManageBooks1.setText("Back");
        lblBackManageBooks1.setPreferredSize(new java.awt.Dimension(100, 45));
        lblBackManageBooks1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackManageBooks1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnBackLayout = new javax.swing.GroupLayout(btnBack);
        btnBack.setLayout(btnBackLayout);
        btnBackLayout.setHorizontalGroup(
            btnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBackManageBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnBackLayout.setVerticalGroup(
            btnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBackLayout.createSequentialGroup()
                .addComponent(lblBackManageBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        panel_heading.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnCloseLayout = new javax.swing.GroupLayout(btnClose);
        btnClose.setLayout(btnCloseLayout);
        btnCloseLayout.setHorizontalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCloseLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        btnCloseLayout.setVerticalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCloseLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_heading.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 0, 100, -1));

        getContentPane().add(panel_heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_recordDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_recordDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_recordDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_recordDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_recordDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_recordDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_recordDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_recordDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_recordDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_recordDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_recordDetails.setRowHeight(40);
        tbl_recordDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_recordDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_recordDetails);

        panel_table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 1300, 370));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 580));

        setSize(new java.awt.Dimension(1481, 857));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tbl_recordDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_recordDetailsMouseClicked

    }//GEN-LAST:event_tbl_recordDetailsMouseClicked

    private void lblBackManageBooks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackManageBooks1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBackManageBooks1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBack;
    private javax.swing.JPanel btnClose;
    private necesario.RSMaterialButtonCircle btn_search;
    private rojeru_san.componentes.RSDateChooser date_FromDate;
    private rojeru_san.componentes.RSDateChooser date_ToDate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackManageBooks1;
    private javax.swing.JLabel lbl_DueDate;
    private javax.swing.JLabel lbl_Heading;
    private javax.swing.JLabel lbl_IssueDate;
    private javax.swing.JPanel panel_heading;
    private javax.swing.JPanel panel_table;
    private rojeru_san.complementos.RSTableMetro tbl_recordDetails;
    // End of variables declaration//GEN-END:variables
}
