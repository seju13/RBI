package RBI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;



public class MPView extends JFrame {
	
	
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public MPView() {
    	
    	
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Date");
        model.addColumn("Instrument Type");
        model.addColumn("Instrument Value");
        model.addColumn("Indicators affected");
        model.addColumn("Impact");
        
        
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM monetary_policy");
            ResultSet Rs = pstm.executeQuery();
            
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getInt(3),Rs.getString(4),Rs.getString(5) });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        getContentPane().setBackground(new Color(255, 255, 224));
        JLabel obj = new JLabel("*************");
        
        setVisible(true);
        
        
    }
    public static void main(String[] args) {
       
        JFrame frame = new MPView();
        frame.setTitle("Monetary Policy");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}