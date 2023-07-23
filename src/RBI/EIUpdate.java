package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EIUpdate extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfdate,tfItype,tfIvalue,tfPvalue,tfcha,tfeid;
    JRadioButton rmale,rfemale;
    JButton add,back,search;
    EIUpdate(int eid){
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 255, 255));
        
        JLabel text=new JLabel("Update economic indicator");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        
        
        JLabel lbleid=new JLabel("EID");
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
        
        JLabel lbIType=new JLabel("Indicator Type");
        lbIType.setBounds(30,180,150,25);
        add(lbIType);
        
        tfItype=new JTextField();
        tfItype.setBounds(220,180,150,25);
        add(tfItype);
    
        JLabel lblIvalue=new JLabel("Indicator Value");
        lblIvalue.setBounds(30,210,150,25);
        add(lblIvalue);

        tfIvalue=new JTextField();
        tfIvalue.setBounds(220,210,150,25);
        add(tfIvalue);
        
        JLabel lblPvalue=new JLabel("Previous Value");
        lblPvalue.setBounds(30,240,150,25);
        add(lblPvalue);
        
        tfPvalue=new JTextField();
        tfPvalue.setBounds(220,240,150,25);
        add(tfPvalue);
        
        JLabel lblcha=new JLabel("Change");
        lblcha.setBounds(30,270,150,25);
        add(lblcha);
        
        tfcha =new JTextField();
        tfcha.setBounds(220,270,150,25);
        add(tfcha);
        
        
        
     
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
        	String eid_s=tfeid.getText();
            int eid=Integer.parseInt(eid_s);
           
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from economic_indicator where EID = '"+eid+"'");
                while(rs.next()){
                   tfIvalue.setText(rs.getString("IValue"));
                    tfPvalue.setText(rs.getString("PreValues"));
                    tfcha.setText(String.valueOf(rs.getInt("Changes")));
                    tfdate.setText(rs.getString("Date"));
                    tfeid.setText(rs.getString("EID"));
                    tfItype.setText(rs.getString("IType"));
                    
                }
            }catch(Exception e){
            System.out.println(e);
            }
   
        }else if(ae.getSource() == add) {
        	String IValue_s = tfIvalue.getText();
            double IValue=Double.parseDouble(IValue_s);
            String PValue_s = tfPvalue.getText();
            double PreValues=Double.parseDouble(PValue_s);
            String Chan_s = tfcha.getText();
            double Cha=Double.parseDouble(Chan_s);
            String date=tfdate.getText();
            String eid_s=tfeid.getText();
            int eid=Integer.parseInt(eid_s);
            String IType=tfItype.getText();
            try{
                Conn c=new Conn();
                String query = "UPDATE economic_indicator SET  IValue = ?, PreValues = ?, Changes = ?, Date = ?, EID = ?, IType= ? WHERE EID = '"+eid+"'";
                
                
                
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                   
                    pstmt.setDouble(1, IValue);
                    pstmt.setDouble(2, PreValues);
                    pstmt.setDouble(3, Cha);
                    pstmt.setString(4, date);
                    pstmt.setInt(5, eid);
                    pstmt.setString(6, IType);
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
        new EIUpdate(0);
    }
}


