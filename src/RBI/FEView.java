package RBI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;



public class FEView extends JFrame {
	
	
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public FEView() {
    	
    	
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Date");
        model.addColumn("Currencies");
        model.addColumn("Exchange rate");
        model.addColumn("Trasaction type");
        model.addColumn("Transaction value");
        model.addColumn("CounterParty");
        model.addColumn("Purpose");
        model.addColumn("Settlement Date");
        model.addColumn("Bank involved");
        
        
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM foreign_exchange1");
            ResultSet Rs = pstm.executeQuery();
     
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getInt(3),Rs.getString(4), Rs.getInt(5),Rs.getString(6)
                ,Rs.getString(7),Rs.getString(8), Rs.getInt(9)});
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
       
        JFrame frame = new FEView();
        frame.setTitle("Foreign Exchange");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ;
    }
}