package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FIUpdate extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfbid,tfname,tftype,tfloc,tfcon,tflic,tfrev,tfpro,tfca,tfrc;
    JRadioButton rmale,rfemale;
    JButton add,back,search;
    FIUpdate(int eid){
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
       
        JLabel text=new JLabel("Update Financial Institutions");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblbid=new JLabel("BankID");
        lblbid.setBounds(30,50,150,25);
        add(lblbid);
       
        tfbid=new JTextField();
        tfbid.setBounds(220,50,150,25);
        add(tfbid);
       
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(70,100,100,25);
        search.addActionListener(this);
        add(search);

       
        JLabel lblname=new JLabel("Institution Name");
        lblname.setBounds(30,140,150,25);
        add(lblname);
       
        tfname=new JTextField();
        tfname.setBounds(220,140,150,25);
        add(tfname);

        JLabel lbltype=new JLabel("Institution type");
        lbltype.setBounds(30,180,150,25);
        add(lbltype);
       
        tftype=new JTextField();
        tftype.setBounds(220,180,150,25);
        add(tftype);
   
        JLabel lblloc=new JLabel("Location");
        lblloc.setBounds(30,210,150,25);
        add(lblloc);

        tfloc=new JTextField();
        tfloc.setBounds(220,210,150,25);
        add(tfloc);


        JLabel lblcon=new JLabel("Contact_info");
        lblcon.setBounds(30,240,150,25);
        add(lblcon);
       
        tfcon=new JTextField();
        tfcon.setBounds(220,240,150,25);
        add(tfcon);
       
        JLabel lbllic=new JLabel("Licence");
        lbllic.setBounds(30,270,150,25);
        add(lbllic);
       
        tflic =new JTextField();
        tflic.setBounds(220,270,150,25);
        add(tflic);

        JLabel lblrev=new JLabel("Revenue");
        lblrev.setBounds(30,300,150,25);
        add(lblrev);

        tfrev =new JTextField();
        tfrev.setBounds(220,300,150,25);
        add(tfrev);

        JLabel lblpro=new JLabel("Products");
        lblpro.setBounds(30,330,150,25);
        add(lblpro);

        tfpro =new JTextField();
        tfpro.setBounds(220,330,150,25);
        add(tfpro);

        JLabel lblca=new JLabel("Capital Adequecy");
        lblca.setBounds(30,360,150,25);
        add(lblca);

        tfca =new JTextField();
        tfca.setBounds(220,360,150,25);
        add(tfca);

        JLabel lblrc=new JLabel("Regulatory Compliance");
        lblrc.setBounds(30,390,150,25);
        add(lblrc);

        tfrc =new JTextField();
        tfrc.setBounds(220,390,150,25);
        add(tfrc);

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
        String bid_s=tfbid.getText();
        int bid=Integer.parseInt(bid_s);
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank_t1 where BankID = '"+bid+"'");
                while(rs.next()){
                   tfname.setText(rs.getString("Institution_Name"));
                    tftype.setText(rs.getString("Institution_Type"));
                    tfloc.setText(rs.getString("Location"));
                    tfcon.setText(rs.getString("Contact_Info"));
                    tflic.setText(rs.getString("Licence"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from bank_t2 where BankID = '"+bid+"'");
                while(rs2.next()){
                    tfrev.setText(String.valueOf(rs2.getInt("Revenue")));
                    tfpro.setText(rs2.getString("Products"));
                    tfca.setText(String.valueOf(rs2.getInt("Capital_Adequency")));
                    tfrc.setText(rs2.getString("Regulatory_Compliance"));

                }
            }catch(Exception e){
            System.out.println(e);
            }
   
        }else if(ae.getSource() == add) {
            String name = tfname.getText();
            String type = tftype.getText();
            String bid_s=tfbid.getText();
            int bid=Integer.parseInt(bid_s);
            String loc = tfloc.getText();
            String con=tfcon.getText();
            String lic=tflic.getText();
            String rev_s=tfrev.getText();
            int rev=Integer.parseInt(rev_s);
            String pro=tfpro.getText();
            String ca_s=tfca.getText();
            int ca=Integer.parseInt(ca_s);
            String rc=tfrc.getText();
            try{
                Conn c=new Conn();
                String query = "UPDATE bank_t1 SET  Institution_Name = ?, Institution_Type = ?, BankID = ?, Location = ?, Contact_Info = ?, Licence= ? WHERE BankID = '"+bid+"'";
                String query2 = "UPDATE bank_t2 SET  BankID = ?, Revenue = ?, Products = ?, Capital_Adequency = ?, Regulatory_Compliance = ? WHERE BankID = '"+bid+"'";


                PreparedStatement pstmt = c.c.prepareStatement(query);
               
                    pstmt.setString(1, name);
                    pstmt.setString(2, type);
                    pstmt.setFloat(3, bid);
                    pstmt.setString(4, loc);
                    pstmt.setString(5, con);
                    pstmt.setString(6, lic);
                    PreparedStatement pstmt2 = c.c.prepareStatement(query2);
                    pstmt2.setInt(1, bid);
                    pstmt2.setInt(2, rev);
                    pstmt2.setString(3, pro);
                    pstmt2.setInt(4, ca);
                    pstmt2.setString(5, rc);


                    int i = pstmt.executeUpdate();
                   int j = pstmt2.executeUpdate();
                   JOptionPane.showMessageDialog(null,"Records updated Successfully");


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
        new FIUpdate(0);
    }
}