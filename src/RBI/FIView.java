package RBI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;

public class FIView extends JFrame{


    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    
    
//    model.setRowHeight(30);
//    model.setRowHeight(3, 60);
    public FIView() {
   
   
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("BankID");
        model.addColumn("Institution Name");
        model.addColumn("Institution Type");
       
        model.addColumn("Location");
        model.addColumn("Contact-Info");
        model.addColumn("License");
        model.addColumn("Revenue");
        model.addColumn("Products");
        model.addColumn("Capital_Adequacy");
        model.addColumn("Regulatory_Compliance");
       
       
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM bank_t1 NATURAL JOIN bank_t2");
            ResultSet Rs = pstm.executeQuery();
      
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1),Rs.getString(2), Rs.getString(3),Rs.getString(4), Rs.getString(5),Rs.getString(6)
                        ,Rs.getInt(7),Rs.getString(8), Rs.getInt(9),Rs.getString(10)
                });
            }
       
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
       
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        getContentPane().setBackground(new Color(240, 248, 255));
        JLabel obj = new JLabel("*************");
        
       
      
        setVisible(true);
    }
  
    public static void main(String[] args) {
       
        JFrame frame = new FIView();
        frame.setTitle("Financial Institutions");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

        
        
        
      