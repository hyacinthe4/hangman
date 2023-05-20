package hangmanexam;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muneza
 */
public class vscore extends javax.swing.JFrame {

  Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel tm;
    private JLabel hangmanLabel;
    public vscore() {
        
        initComponents();
        
        addconnection();
        try {
            st=con.createStatement();
            String select="Select * from users";
            rs=st.executeQuery(select);
            while(rs.next()){
            tm=(DefaultTableModel) tables.getModel();
            tables.setModel(tm);
            Object row[]={rs.getInt(1),rs.getString(2),rs.getBoolean(3),};
            tm.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Something Wrong! "+ex.getMessage());
        }
      
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
           public void addconnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hangman","root","");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Something Wrong! "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Something Wrong! "+ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tables = new javax.swing.JTable();
        searchf = new javax.swing.JTextField();
        Deleteb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "User_name", "Score"
            }
        ));
        jScrollPane1.setViewportView(tables);

        searchf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfActionPerformed(evt);
            }
        });

        Deleteb.setText("Delete");
        Deleteb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deleteb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Deleteb))
                .addGap(0, 132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void searchfActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void DeletebActionPerformed(java.awt.event.ActionEvent evt) {                                        
       String search=searchf.getText();
            try {
                String insert="delete from users where Id='"+search+"'";
                
                ps=con.prepareStatement(insert);
                ps.execute();
                tm.setRowCount(0);
                st=con.createStatement();
            String select="Select * from users";
            rs=st.executeQuery(select);
            while(rs.next()){
            tm=(DefaultTableModel) tables.getModel();
            tables.setModel(tm);
            Object row[]={rs.getInt(1),rs.getString(2),rs.getString(3)};
            tm.addRow(row);
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Something Wrong! "+ex.getMessage());
    }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vscore().setVisible(true);
            }
        });
    }                  
    private javax.swing.JButton Deleteb,updateb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchf;
    private javax.swing.JTable tables;              
}
