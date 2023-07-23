package RBI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;



public class RFView extends JFrame {
	
	
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public RFView() {
    	
    	
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Category");
        model.addColumn("Regulation title");
        model.addColumn("Implemetation date");
        model.addColumn("Insitutions Involved");
        model.addColumn("Compliance date");
        model.addColumn("Regulatory Authority");
        model.addColumn("Banks affected");
        model.addColumn("RID");
        
        
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM rf1");
            ResultSet Rs = pstm.executeQuery();
            
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4), Rs.getString(5),Rs.getString(6)
                ,Rs.getInt(7),Rs.getInt(8)  });
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
    	
        JFrame frame = new RFView();
        frame.setTitle("Regulation Frameworks");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}