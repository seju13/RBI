package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FEUpdate extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfdate,tfcurr,tfexr,tfTtype,tftvalue,tfcp,tfpur,tfsdate;
    JRadioButton rmale,rfemale;
    JButton add,back,search;
    FEUpdate(int eid){
        setBounds(300,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        JLabel text=new JLabel("Update Foreign Exchange");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(30,50,150,25);
        add(lbldate);
       
        tfdate=new JTextField();
        tfdate.setBounds(220,50,150,25);
        add(tfdate);
       
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(70,100,100,25);
        search.addActionListener(this);
        add(search);

       
        JLabel lblcurr=new JLabel("Currencies");
        lblcurr.setBounds(30,140,150,25);
        add(lblcurr);
       
        tfcurr=new JTextField();
        tfcurr.setBounds(220,140,150,25);
        add(tfcurr);

        JLabel lblexr=new JLabel("Exchange rate");
        lblexr.setBounds(30,180,150,25);
        add(lblexr);
       
        tfexr=new JTextField();
        tfexr.setBounds(220,180,150,25);
        add(tfexr);
   
        JLabel lblTtype=new JLabel("Transaction Type");
        lblTtype.setBounds(30,210,150,25);
        add(lblTtype);

        tfTtype=new JTextField();
        tfTtype.setBounds(220,210,150,25);
        add(tfTtype);


        JLabel lblTvalue=new JLabel("Transaction Value");
        lblTvalue.setBounds(30,240,150,25);
        add(lblTvalue);
       
        tftvalue=new JTextField();
        tftvalue.setBounds(220,240,150,25);
        add(tftvalue);
       
        JLabel lblcp=new JLabel("Counter Party");
        lblcp.setBounds(30,270,150,25);
        add(lblcp);
       
        tfcp =new JTextField();
        tfcp.setBounds(220,270,150,25);
        add(tfcp);

        JLabel lblpur=new JLabel("Purpose");
        lblpur.setBounds(30,300,150,25);
        add(lblpur);

        tfpur =new JTextField();
        tfpur.setBounds(220,300,150,25);
        add(tfpur);

        JLabel lblsdate=new JLabel("Settlement Date");
        lblsdate.setBounds(30,330,150,25);
        add(lblsdate);

        tfsdate =new JTextField();
        tfsdate.setBounds(220,330,150,25);
        add(tfsdate);

        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

       
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
//        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(400,40,400,500);
//        add(image);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
        String date=tfdate.getText();
           
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from foreign_exchange1 where Date = '"+date+"'");
                while(rs.next()){
                   tfcurr.setText(rs.getString("Currencies"));
                    tfexr.setText(String.valueOf(rs.getInt("Exchange_Rate")));
                    tfTtype.setText(rs.getString("Transaction_type"));
                    tftvalue.setText(String.valueOf(rs.getInt("Transaction_Value")));
                    tfcp.setText(rs.getString("CounterParty"));
                    tfpur.setText(rs.getString("Purpose"));
                    tfsdate.setText(rs.getString("Settlement_Date"));

                   
                }
            }catch(Exception e){
            System.out.println(e);
            }
   
        }else if(ae.getSource() == add) {
            String date = tfdate.getText();
            String curr = tfcurr.getText();
            String exr_s = tfexr.getText();
            float exr=Float.parseFloat(exr_s);
            String type=tfTtype.getText();
            String val_s=tftvalue.getText();
            int val=Integer.parseInt(val_s);
            String cp=tfcp.getText();
            String pur=tfpur.getText();
            String sdate=tfsdate.getText();
            try{
                Conn c=new Conn();
                String query = "UPDATE foreign_exchange1 SET  Date = ?, Currencies = ?, Exchange_Rate = ?, Transaction_type = ?, Transaction_Value = ?, CounterParty= ?, Purpose= ?, Settlement_Date=? WHERE Date = '"+date+"'";
               
               
               
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                   
                    pstmt.setString(1, date);
                    pstmt.setString(2, curr);
                    pstmt.setFloat(3, exr);
                    pstmt.setString(4, type);
                    pstmt.setInt(5, val);
                    pstmt.setString(6, cp);
                    pstmt.setString(7, pur);
                    pstmt.setString(8, sdate);
                    int i = pstmt.executeUpdate();
                    System.out.println(i);
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Records updated Successfully");
                }
                } catch (SQLException e) {
                    // Handle exception
                    System.out.println(e);
                }

                setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
        }
    }
     public static void main(String[] args){
        new FEUpdate(0);
    }
}
