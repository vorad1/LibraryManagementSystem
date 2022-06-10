/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dev
 */
public class ManageBooks extends javax.swing.JFrame {

    String bookName, author, department;
    int bookID;
    DefaultTableModel model;

    /**
     * Creates new form ManageBooks
     */
    public ManageBooks() {
        initComponents();
        setBookDetails();
    }

    //validation
    public boolean validateFields() {
        String bName = txt_BookName.getText();
        String aName = txt_AuthorName.getText();
        String Id = txt_BookID.getText();

        if (Id.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID");
            return false;
        }
        if (bName.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Book Name");
            return false;
        }
        if (aName.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Author Name");
            return false;
        }

        return true;
    }

    // to set the book details in the table
    public void setBookDetails() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from book_details");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String department = rs.getString("department");

                Object[] obj = {bookId, bookName, author, department};                // using a model to set the values in the table
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                // using the array to add data in the table
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // to add books to the database table
    public boolean addBook() {

        boolean isAdded = false;

        bookID = Integer.parseInt(txt_BookID.getText());
        bookName = txt_BookName.getText();
        author = txt_AuthorName.getText();
        department = combo_department.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, bookID);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setString(4, department);
            pst.setInt(5, 1);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAdded;
    }

    // method to update book details
    public boolean updateBook() {

        boolean isUpdated = false;

        bookID = Integer.parseInt(txt_BookID.getText());
        bookName = txt_BookName.getText();
        author = txt_AuthorName.getText();
        department = combo_department.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set book_name = ?, author = ?, department = ? where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setString(3, department);
            pst.setInt(4, bookID);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // method to delete book
    public boolean deleteBook() {

        boolean isDeleted = false;

        bookID = Integer.parseInt(txt_BookID.getText());

        try {

            Connection con = DBConnection.getConnection();
            String sql = "delete from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookID);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    // method to clear table   
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
    }

    // method to clear textfields   
    public void clearTextfields() {
        txt_BookID.setText("");
        txt_BookName.setText("");
        txt_AuthorName.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_Back = new javax.swing.JPanel();
        lblBackManageBooks = new javax.swing.JLabel();
        lblBookIDLogo = new javax.swing.JLabel();
        lblBookID = new javax.swing.JLabel();
        txt_BookID = new app.bolivia.swing.JCTextField();
        lblBookNameLogo = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        txt_BookName = new app.bolivia.swing.JCTextField();
        lblAuthorNameLogo = new javax.swing.JLabel();
        lblAuthorName = new javax.swing.JLabel();
        txt_AuthorName = new app.bolivia.swing.JCTextField();
        lblQuantityLogo = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        btn_delete = new rojerusan.RSMaterialButtonCircle();
        btn_add = new rojerusan.RSMaterialButtonCircle();
        btn_update = new rojerusan.RSMaterialButtonCircle();
        btn_clear = new necesario.RSMaterialButtonCircle();
        combo_department = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        pnl_Close = new javax.swing.JPanel();
        lblCancelManageBooks = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Back.setBackground(new java.awt.Color(255, 51, 51));
        pnl_Back.setPreferredSize(new java.awt.Dimension(120, 60));

        lblBackManageBooks.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBackManageBooks.setForeground(new java.awt.Color(255, 255, 255));
        lblBackManageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        lblBackManageBooks.setText("Back");
        lblBackManageBooks.setPreferredSize(new java.awt.Dimension(100, 45));
        lblBackManageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackManageBooksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_BackLayout = new javax.swing.GroupLayout(pnl_Back);
        pnl_Back.setLayout(pnl_BackLayout);
        pnl_BackLayout.setHorizontalGroup(
            pnl_BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_BackLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblBackManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_BackLayout.setVerticalGroup(
            pnl_BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_BackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 70));

        lblBookIDLogo.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBookIDLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblBookIDLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(lblBookIDLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 50, 50));

        lblBookID.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBookID.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.setText("Enter Book Id: ");
        jPanel1.add(lblBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        txt_BookID.setBackground(new java.awt.Color(102, 102, 255));
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_BookID.setPlaceholder("Enter Book Id ...");
        txt_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusLost(evt);
            }
        });
        txt_BookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 320, -1));

        lblBookNameLogo.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBookNameLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblBookNameLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(lblBookNameLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 50, 50));

        lblBookName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblBookName.setForeground(new java.awt.Color(255, 255, 255));
        lblBookName.setText("Enter Book Name:");
        jPanel1.add(lblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        txt_BookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_BookName.setPlaceholder("Enter Book Name ...");
        txt_BookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_BookNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookNameFocusLost(evt);
            }
        });
        txt_BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 320, -1));

        lblAuthorNameLogo.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblAuthorNameLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthorNameLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(lblAuthorNameLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 50, 50));

        lblAuthorName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblAuthorName.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthorName.setText("Enter Author Name:");
        jPanel1.add(lblAuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        txt_AuthorName.setBackground(new java.awt.Color(102, 102, 255));
        txt_AuthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_AuthorName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_AuthorName.setPlaceholder("Enter Author Name ...");
        txt_AuthorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_AuthorNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_AuthorNameFocusLost(evt);
            }
        });
        txt_AuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AuthorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_AuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 320, -1));

        lblQuantityLogo.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblQuantityLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantityLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(lblQuantityLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 50, 50));

        lblQuantity.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Enter Department: ");
        jPanel1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, 130, 60));

        btn_add.setBackground(new java.awt.Color(255, 51, 51));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 130, 60));

        btn_update.setBackground(new java.awt.Color(255, 51, 51));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 130, 60));

        btn_clear.setBackground(new java.awt.Color(0, 0, 153));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 90, 60));

        combo_department.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "Construction", "Business", "English", "Other" }));
        combo_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_departmentActionPerformed(evt);
            }
        });
        jPanel1.add(combo_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 360, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Close.setBackground(new java.awt.Color(102, 102, 255));
        pnl_Close.setPreferredSize(new java.awt.Dimension(120, 60));

        lblCancelManageBooks.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lblCancelManageBooks.setForeground(new java.awt.Color(255, 255, 255));
        lblCancelManageBooks.setText("X");
        lblCancelManageBooks.setPreferredSize(new java.awt.Dimension(100, 45));
        lblCancelManageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelManageBooksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_CloseLayout = new javax.swing.GroupLayout(pnl_Close);
        pnl_Close.setLayout(pnl_CloseLayout);
        pnl_CloseLayout.setHorizontalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CloseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCancelManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnl_CloseLayout.setVerticalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CloseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCancelManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(pnl_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 80, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("  Manage Books");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 280, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 380, 5));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID ", "Book Name", "Author", "Department"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 970, 370));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 830));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackManageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackManageBooksMouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        // this will dispose of the current frame and open the homepage frame
        dispose();
    }//GEN-LAST:event_lblBackManageBooksMouseClicked

    private void txt_BookIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIDFocusGained

    private void txt_BookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookIDFocusLost
        // to check whether username is already in use

    }//GEN-LAST:event_txt_BookIDFocusLost

    private void txt_BookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIDActionPerformed

    private void txt_BookNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameFocusGained

    private void txt_BookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookNameFocusLost
        // to check whether username is already in use

    }//GEN-LAST:event_txt_BookNameFocusLost

    private void txt_BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameActionPerformed

    private void txt_AuthorNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_AuthorNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameFocusGained

    private void txt_AuthorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_AuthorNameFocusLost
        // to check whether username is already in use

    }//GEN-LAST:event_txt_AuthorNameFocusLost

    private void txt_AuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (validateFields()) {
            if (deleteBook() == true) {
                JOptionPane.showMessageDialog(this, "Book Deleted Succesfully");
                clearTable();
                clearTextfields();
                setBookDetails();
            } else {
                JOptionPane.showMessageDialog(this, "Error Deleting Book");
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (validateFields()) {
            if (updateBook() == true) {
                JOptionPane.showMessageDialog(this, "Book Updated Succesfully");
                clearTable();
                clearTextfields();
                setBookDetails();
            } else {
                JOptionPane.showMessageDialog(this, "Error Adding Book");
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (validateFields()) {
            if (addBook() == true) {
                JOptionPane.showMessageDialog(this, "Book Added Succesfully");
                clearTable();
                clearTextfields();
                setBookDetails();
            } else {
                JOptionPane.showMessageDialog(this, "Error Updating Book");
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void lblCancelManageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelManageBooksMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCancelManageBooksMouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

        int rowNo = tbl_bookDetails.getSelectedRow();

        TableModel model = tbl_bookDetails.getModel();

        //using the values from the model and setting it in the textfields
        txt_BookID.setText(model.getValueAt(rowNo, 0).toString());
        txt_BookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_AuthorName.setText(model.getValueAt(rowNo, 2).toString());
        combo_department.setSelectedItem(model.getValueAt(rowNo, 3).toString());

    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed

        clearTextfields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void combo_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_departmentActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_add;
    private necesario.RSMaterialButtonCircle btn_clear;
    private rojerusan.RSMaterialButtonCircle btn_delete;
    private rojerusan.RSMaterialButtonCircle btn_update;
    private javax.swing.JComboBox<String> combo_department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthorName;
    private javax.swing.JLabel lblAuthorNameLogo;
    private javax.swing.JLabel lblBackManageBooks;
    private javax.swing.JLabel lblBookID;
    private javax.swing.JLabel lblBookIDLogo;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblBookNameLogo;
    private javax.swing.JLabel lblCancelManageBooks;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantityLogo;
    private javax.swing.JPanel pnl_Back;
    private javax.swing.JPanel pnl_Close;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_AuthorName;
    private app.bolivia.swing.JCTextField txt_BookID;
    private app.bolivia.swing.JCTextField txt_BookName;
    // End of variables declaration//GEN-END:variables
}
