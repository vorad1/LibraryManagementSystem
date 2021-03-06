/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rudra Modh and Dev Vora
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);
    DefaultTableModel model;

    public HomePage() {
        initComponents();
        showPieChart();
        setBookDetails();
        setStudentDetailsToTable();
        setDataToCards();
    }

    public void showPieChart() {

//create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select book_name ,count(*) as issue_count from issue_book_details group by book_name";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
              barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Highest Issued Book", barDataset, true, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));
        
        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();


    }

    //to set the student details into the table
    public void setStudentDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()) {
                String StudentId = rs.getString("student_id");
                String StudentName = rs.getString("name");
                String department = rs.getString("department");

                Object[] obj = {StudentId, StudentName, department};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // to set the book details in the table
    public void setBookDetails() {
        try {
            Connection con = DBConnection.getConnection();

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
    
    
    public void setDataToCards(){
        
        Statement st = null;
        ResultSet rs = null;
        
        long l =System.currentTimeMillis();
        Date todaysDate = new Date(l);
        
        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
             rs = st.executeQuery("select * from book_details");
              rs.last();
              lbl_numBooks.setText(Integer.toString(rs.getRow()));
              
              rs = st.executeQuery("select * from student_details");
              rs.last();
              lbl_numStudent.setText(Integer.toString(rs.getRow()));
              
               String sql1 = "select * from issue_book_details where status = ?";
               PreparedStatement pt = con.prepareStatement(sql1);
              pt.setString(1, "issued");
              rs = pt.executeQuery();
              rs.last();
              lbl_issueBooks.setText(Integer.toString(rs.getRow()));
              
              String sql = "select * from issue_book_details where due_date < ? and status = ?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setDate(1, todaysDate);
              pst.setString(2, "issued");
              rs = pst.executeQuery();
              rs.last();
              lbl_defaulterList.setText(Integer.toString(rs.getRow()));
              
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnl_Logout = new javax.swing.JPanel();
        lbl_Logout = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        admnHomePage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        admnLMS_Dashboard = new javax.swing.JLabel();
        pnl_IssueBook = new javax.swing.JPanel();
        admnIssueBook = new javax.swing.JLabel();
        pnl_ReturnBook = new javax.swing.JPanel();
        admnReturnBook = new javax.swing.JLabel();
        pnl_ViewRecords = new javax.swing.JPanel();
        admnViewRecords = new javax.swing.JLabel();
        pnl_ViewIssuedBooks = new javax.swing.JPanel();
        admnViewIssuedBooks = new javax.swing.JLabel();
        pnl_ManageBooks = new javax.swing.JPanel();
        admnManageBooks = new javax.swing.JLabel();
        pnl_ManageStudents = new javax.swing.JPanel();
        admnManageStudents = new javax.swing.JLabel();
        pnl_DefaultersList = new javax.swing.JPanel();
        admnDefaultersList = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lbl_numBooks = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_numStudent = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_issueBooks = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel25 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 10, 30, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 300, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome, Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 10, 220, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Logout.setBackground(new java.awt.Color(102, 102, 255));
        pnl_Logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Logout.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        lbl_Logout.setText("   Logout");
        lbl_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_LogoutMouseClicked(evt);
            }
        });
        pnl_Logout.add(lbl_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(pnl_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 340, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnHomePage.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnHomePage.setForeground(new java.awt.Color(255, 255, 255));
        admnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        admnHomePage.setText("     Home Page");
        jPanel5.add(admnHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 180, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Features");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 200, 30));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnLMS_Dashboard.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnLMS_Dashboard.setForeground(new java.awt.Color(153, 153, 153));
        admnLMS_Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_32px.png"))); // NOI18N
        admnLMS_Dashboard.setText("   LMS Dashboard");
        jPanel6.add(admnLMS_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 340, 60));

        pnl_IssueBook.setBackground(new java.awt.Color(51, 51, 51));
        pnl_IssueBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnIssueBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnIssueBook.setForeground(new java.awt.Color(153, 153, 153));
        admnIssueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        admnIssueBook.setText("   Issue Book");
        admnIssueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnIssueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnIssueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnIssueBookMouseExited(evt);
            }
        });
        pnl_IssueBook.add(admnIssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 200, 30));

        jPanel3.add(pnl_IssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        pnl_ReturnBook.setBackground(new java.awt.Color(51, 51, 51));
        pnl_ReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ReturnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ReturnBookMouseExited(evt);
            }
        });
        pnl_ReturnBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnReturnBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnReturnBook.setForeground(new java.awt.Color(153, 153, 153));
        admnReturnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        admnReturnBook.setText("   Return Book");
        admnReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnReturnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnReturnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnReturnBookMouseExited(evt);
            }
        });
        pnl_ReturnBook.add(admnReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(pnl_ReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 340, 60));

        pnl_ViewRecords.setBackground(new java.awt.Color(51, 51, 51));
        pnl_ViewRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ViewRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ViewRecordsMouseExited(evt);
            }
        });
        pnl_ViewRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnViewRecords.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnViewRecords.setForeground(new java.awt.Color(153, 153, 153));
        admnViewRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        admnViewRecords.setText("   View Records");
        admnViewRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnViewRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnViewRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnViewRecordsMouseExited(evt);
            }
        });
        pnl_ViewRecords.add(admnViewRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(pnl_ViewRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 340, 60));

        pnl_ViewIssuedBooks.setBackground(new java.awt.Color(51, 51, 51));
        pnl_ViewIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ViewIssuedBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ViewIssuedBooksMouseExited(evt);
            }
        });
        pnl_ViewIssuedBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnViewIssuedBooks.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnViewIssuedBooks.setForeground(new java.awt.Color(153, 153, 153));
        admnViewIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        admnViewIssuedBooks.setText("   View Issued Books");
        admnViewIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnViewIssuedBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnViewIssuedBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnViewIssuedBooksMouseExited(evt);
            }
        });
        pnl_ViewIssuedBooks.add(admnViewIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 220, 30));

        jPanel3.add(pnl_ViewIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 340, 60));

        pnl_ManageBooks.setBackground(new java.awt.Color(51, 51, 51));
        pnl_ManageBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnManageBooks.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnManageBooks.setForeground(new java.awt.Color(153, 153, 153));
        admnManageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        admnManageBooks.setText("   Manage Books");
        admnManageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnManageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnManageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnManageBooksMouseExited(evt);
            }
        });
        pnl_ManageBooks.add(admnManageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(pnl_ManageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, 60));

        pnl_ManageStudents.setBackground(new java.awt.Color(51, 51, 51));
        pnl_ManageStudents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnManageStudents.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnManageStudents.setForeground(new java.awt.Color(153, 153, 153));
        admnManageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        admnManageStudents.setText("   Manage Students");
        admnManageStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnManageStudentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnManageStudentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnManageStudentsMouseExited(evt);
            }
        });
        pnl_ManageStudents.add(admnManageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 30));

        jPanel3.add(pnl_ManageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 340, 60));

        pnl_DefaultersList.setBackground(new java.awt.Color(51, 51, 51));
        pnl_DefaultersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_DefaultersListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_DefaultersListMouseExited(evt);
            }
        });
        pnl_DefaultersList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnDefaultersList.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        admnDefaultersList.setForeground(new java.awt.Color(153, 153, 153));
        admnDefaultersList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        admnDefaultersList.setText("   Defaulter List");
        admnDefaultersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admnDefaultersListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admnDefaultersListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admnDefaultersListMouseExited(evt);
            }
        });
        pnl_DefaultersList.add(admnDefaultersList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        jPanel3.add(pnl_DefaultersList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 340, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numBooks.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_numBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_numBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_numBooks.setText("10");
        jPanel15.add(lbl_numBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 92, 260, 140));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Student Details");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 294, -1, -1));

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numStudent.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_numStudent.setForeground(new java.awt.Color(102, 102, 102));
        lbl_numStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_numStudent.setText("10");
        jPanel16.add(lbl_numStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 92, 260, 140));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("No. Of Students");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 53, -1, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issueBooks.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_issueBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_issueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBooks.setText("10");
        jPanel17.add(lbl_issueBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 92, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Issued Books");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 53, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_defaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel18.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 92, 260, 140));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Defaulter List");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 53, -1, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID ", "Book Name", "Author ", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 628, 839, 208));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("No. Of Books");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 63, -1, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 333, 839, 208));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book Details");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 589, -1, -1));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel14.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 540, 450));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1560, 960));

        setSize(new java.awt.Dimension(1905, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void admnManageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageBooksMouseClicked
        ManageBooks books = new ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnManageBooksMouseClicked

    private void admnManageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageBooksMouseEntered
        // TODO add your handling code here:
        pnl_ManageBooks.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnManageBooksMouseEntered

    private void admnManageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageBooksMouseExited
        // TODO add your handling code here:
        pnl_ManageBooks.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnManageBooksMouseExited

    private void admnManageStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageStudentsMouseEntered
        // TODO add your handling code here:
        pnl_ManageStudents.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnManageStudentsMouseEntered

    private void admnManageStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageStudentsMouseExited
        // TODO add your handling code here:
        pnl_ManageStudents.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnManageStudentsMouseExited

    private void admnIssueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnIssueBookMouseClicked
        IssueBook issueBook = new IssueBook();
        issueBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnIssueBookMouseClicked

    private void admnIssueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnIssueBookMouseEntered
        pnl_IssueBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnIssueBookMouseEntered

    private void admnIssueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnIssueBookMouseExited
        pnl_IssueBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnIssueBookMouseExited

    private void admnReturnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnReturnBookMouseClicked
        ReturnBook book = new ReturnBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnReturnBookMouseClicked

    private void pnl_ReturnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ReturnBookMouseEntered

    }//GEN-LAST:event_pnl_ReturnBookMouseEntered

    private void pnl_ReturnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ReturnBookMouseExited

    }//GEN-LAST:event_pnl_ReturnBookMouseExited

    private void admnViewRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewRecordsMouseClicked
        ViewRecords records = new ViewRecords();
        records.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnViewRecordsMouseClicked

    private void pnl_ViewRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewRecordsMouseEntered

    }//GEN-LAST:event_pnl_ViewRecordsMouseEntered

    private void pnl_ViewRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewRecordsMouseExited

    }//GEN-LAST:event_pnl_ViewRecordsMouseExited

    private void pnl_ViewIssuedBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewIssuedBooksMouseEntered

    }//GEN-LAST:event_pnl_ViewIssuedBooksMouseEntered

    private void pnl_ViewIssuedBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewIssuedBooksMouseExited

    }//GEN-LAST:event_pnl_ViewIssuedBooksMouseExited

    private void pnl_DefaultersListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_DefaultersListMouseEntered

    }//GEN-LAST:event_pnl_DefaultersListMouseEntered

    private void pnl_DefaultersListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_DefaultersListMouseExited

    }//GEN-LAST:event_pnl_DefaultersListMouseExited

    private void admnReturnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnReturnBookMouseEntered
        pnl_ReturnBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnReturnBookMouseEntered

    private void admnReturnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnReturnBookMouseExited
        pnl_ReturnBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnReturnBookMouseExited

    private void admnViewRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewRecordsMouseEntered
        pnl_ViewRecords.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnViewRecordsMouseEntered

    private void admnViewRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewRecordsMouseExited
        pnl_ViewRecords.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnViewRecordsMouseExited

    private void admnViewIssuedBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewIssuedBooksMouseEntered
        pnl_ViewIssuedBooks.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnViewIssuedBooksMouseEntered

    private void admnViewIssuedBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewIssuedBooksMouseExited
        pnl_ViewIssuedBooks.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnViewIssuedBooksMouseExited

    private void admnDefaultersListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnDefaultersListMouseEntered
        pnl_DefaultersList.setBackground(mouseEnterColor);
    }//GEN-LAST:event_admnDefaultersListMouseEntered

    private void admnDefaultersListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnDefaultersListMouseExited
        pnl_DefaultersList.setBackground(mouseExitColor);
    }//GEN-LAST:event_admnDefaultersListMouseExited

    private void admnManageStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnManageStudentsMouseClicked
        ManageStudents students = new ManageStudents();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnManageStudentsMouseClicked

    private void admnDefaultersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnDefaultersListMouseClicked
        DefaulterList defaulterList = new DefaulterList();
        defaulterList.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnDefaultersListMouseClicked

    private void admnViewIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admnViewIssuedBooksMouseClicked
        IssuedBookDetails issuedBookDetails = new IssuedBookDetails();
        issuedBookDetails.setVisible(true);
        dispose();
    }//GEN-LAST:event_admnViewIssuedBooksMouseClicked

    private void lbl_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogoutMouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_LogoutMouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admnDefaultersList;
    private javax.swing.JLabel admnHomePage;
    private javax.swing.JLabel admnIssueBook;
    private javax.swing.JLabel admnLMS_Dashboard;
    private javax.swing.JLabel admnManageBooks;
    private javax.swing.JLabel admnManageStudents;
    private javax.swing.JLabel admnReturnBook;
    private javax.swing.JLabel admnViewIssuedBooks;
    private javax.swing.JLabel admnViewRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Logout;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issueBooks;
    private javax.swing.JLabel lbl_numBooks;
    private javax.swing.JLabel lbl_numStudent;
    private javax.swing.JPanel panelPieChart;
    private javax.swing.JPanel pnl_DefaultersList;
    private javax.swing.JPanel pnl_IssueBook;
    private javax.swing.JPanel pnl_Logout;
    private javax.swing.JPanel pnl_ManageBooks;
    private javax.swing.JPanel pnl_ManageStudents;
    private javax.swing.JPanel pnl_ReturnBook;
    private javax.swing.JPanel pnl_ViewIssuedBooks;
    private javax.swing.JPanel pnl_ViewRecords;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
