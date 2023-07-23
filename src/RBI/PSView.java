package RBI;


import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;



public class PSView extends JFrame {
	
	
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public PSView() {
    	
    	
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("TransactionID"); 
        model.addColumn("Payment ID");
        model.addColumn("Date");
        model.addColumn("Availability");
        
        model.addColumn("Volume");
        model.addColumn("Value");
        model.addColumn("Time");

        
        
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM payment_t3 NATURAL JOIN payment_t5");
            ResultSet Rs = pstm.executeQuery();
//            
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getLong(1),Rs.getString(2), Rs.getString(3),Rs.getString(4),Rs.getInt(5),Rs.getInt(6),Rs.getString(7)		            
                });
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        
        JLabel obj = new JLabel("*************");
        
        
        setVisible(true);
        
    }
    public static void main(String[] args) {
       
        JFrame frame = new 	PSView();
        frame.setTitle("Payment Systems");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}