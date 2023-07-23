package RBI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;



public class EIView extends JFrame {


    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public EIView() {
   
   
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Current Value");
        model.addColumn("Previous Value");
        model.addColumn("Changes");
        model.addColumn("EID");      
        model.addColumn("Date");      
        model.addColumn("Indicator Type");
        
       
       
       
        try {
           Conn c=new Conn();
            PreparedStatement pstm = c.c.prepareStatement("SELECT * FROM economic_indicator");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getInt(2),Rs.getInt(3),Rs.getInt(4), Rs.getString(5),Rs.getString(6) });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
       
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        getContentPane().setBackground(new Color(240, 255, 255));
        JLabel obj = new JLabel("*************");
       
       
        setVisible(true);
       
    }
    public static void main(String[] args) {
       
        JFrame frame = new EIView();
        frame.setTitle("Economic Indicators");
        frame.setBounds(100, 50, 500, 400);
        //frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        

    }
}