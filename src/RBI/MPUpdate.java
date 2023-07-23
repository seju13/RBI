package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class MPUpdate extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfdate,tfItype,tfIvalue,tfeid;
    JRadioButton rmale,rfemale;
    JButton add,back,search;
    MPUpdate(int eid){
    	
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 224));
       
        JLabel text=new JLabel("Update Monetary Policy");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
       
       
       
        JLabel lbleid=new JLabel("Instrument_Value");
        lbleid.setBounds(30,50,150,25);
        add(lbleid);
       
        tfeid=new JTextField();
        tfeid.setBounds(220,50,150,25);
        add(tfeid);
       
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(70,100,100,25);
        search.addActionListener(this);
        add(search);

       
        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(30,140,150,25);
        add(lbldate);
       
        tfdate=new JTextField();
        tfdate.setBounds(220,140,150,25);
        add(tfdate);
       
        JLabel lbIType=new JLabel("Instrument Type");
        lbIType.setBounds(30,180,150,25);
        add(lbIType);
       
        tfItype=new JTextField();
        tfItype.setBounds(220,180,150,25);
        add(tfItype);
   
        JLabel lblIvalue=new JLabel("Target Variable");
        lblIvalue.setBounds(30,210,150,25);
        add(lblIvalue);

        tfIvalue=new JTextField();
        tfIvalue.setBounds(220,210,150,25);
        add(tfIvalue);
    
     
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
        	
        String iv_s=tfeid.getText();
            int iv=Integer.parseInt(iv_s);
           
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from monetary_policy where Instrument_Value = '"+iv+"'");
                while(rs.next()){
                	tfdate.setText(rs.getString("Date"));
                   tfItype.setText(rs.getString("Instrument_type"));
                   tfIvalue.setText(rs.getString("Target_Variable"));
                   
                }
            }catch(Exception e){
            System.out.println(e);
            }
   
        }else if(ae.getSource() == add) {
            
            String target=tfIvalue.getText();
            String date=tfdate.getText();
            String iv_s=tfeid.getText();
            int iv=Integer.parseInt(iv_s);
            String IType=tfItype.getText();
            try{
                Conn c=new Conn();
                String query = "UPDATE monetary_policy SET  Date = ?, Instrument_type = ?, Instrument_Value = ?, Target_Variable = ? WHERE  Instrument_Value= '"+iv+"'";
               
               
               
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                   
                    pstmt.setString(1, date);
                    pstmt.setString(2, IType);
                    pstmt.setInt(3, iv);
                    pstmt.setString(4,target);
                    
                    int i = pstmt.executeUpdate();
                    System.out.println(i);
                if (i > 0){
                   JOptionPane.showMessageDialog(null,"Records Updated Successfully");
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
        new MPUpdate(0);
    }
}

