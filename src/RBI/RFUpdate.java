package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RFUpdate extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfdate,tfItype,tfIvalue,tfrid,tfcd,tfra;
    JRadioButton rmale,rfemale;
    JButton add,back,search;
    RFUpdate(int Rid){
    	
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 224));
       
        JLabel text=new JLabel("Update Regulatory Framework");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
       
       
       
        JLabel lbleid=new JLabel("RID");
        lbleid.setBounds(30,50,150,25);
        add(lbleid);
       
        tfrid=new JTextField();
        tfrid.setBounds(220,50,150,25);
        add(tfrid);
       
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(70,100,100,25);
        search.addActionListener(this);
        add(search);

       
        JLabel lbldate=new JLabel("Category");
        lbldate.setBounds(30,140,150,25);
        add(lbldate);
       
        tfdate=new JTextField();
        tfdate.setBounds(220,140,150,25);
        add(tfdate);
       
        JLabel lbIType=new JLabel("Regulation Title");
        lbIType.setBounds(30,180,150,25);
        add(lbIType);
       
        tfItype=new JTextField();
        tfItype.setBounds(220,180,150,25);
        add(tfItype);
   
        JLabel lblIvalue=new JLabel("Implementation Date");
        lblIvalue.setBounds(30,210,150,25);
        add(lblIvalue);

        tfIvalue=new JTextField();
        tfIvalue.setBounds(220,210,150,25);
        add(tfIvalue);
    
        JLabel lblcd=new JLabel("Compliance Date");
        lblcd.setBounds(30,240,150,25);
        add(lblcd);

        tfcd=new JTextField();
        tfcd.setBounds(220,240,150,25);
        add(tfcd);
        
        JLabel lblra=new JLabel("Regulatory Authority");
        lblra.setBounds(30,280,150,25);
        add(lblra);

        tfra=new JTextField();
        tfra.setBounds(220,280,150,25);
        add(tfra);

        
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
        	
        String ri_s=tfrid.getText();
            int ri=Integer.parseInt(ri_s);
           
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from rf1 where RID = '"+ri+"'");
                while(rs.next()){
                	tfdate.setText(rs.getString("Category"));
                   tfItype.setText(rs.getString("Regulation_Title"));
                   tfIvalue.setText(rs.getString("Implementation_date"));
                   tfcd.setText(rs.getString("Compliance_date"));
                   tfra.setText(rs.getString("Regulatory_Authority"));
                   
                }
            }catch(Exception e){
            System.out.println(e);
            }
   
        }else if(ae.getSource() == add) {
            
        	String date=tfdate.getText();
        	String rt=tfItype.getText();
            String ri_s=tfrid.getText();
            int iv=Integer.parseInt(ri_s);
            String impdate=tfIvalue.getText();
            String cdate=tfcd.getText();
            String ra=tfra.getText();

            
            try{
                Conn c=new Conn();
                String query = "UPDATE rf1 SET  Category = ?,  Regulation_Title= ?,RID = ?, Implementation_date = ?, Compliance_date = ?,Regulatory_Authority = ? WHERE  RID= '"+iv+"'";
               
               
               
                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                   
                    pstmt.setString(1, date);
                    pstmt.setString(2, rt );
                    pstmt.setInt(3, iv);
                    pstmt.setString(4,impdate);
                    pstmt.setString(5,cdate);
                    pstmt.setString(6,ra);
                    
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
        new RFUpdate(0);
    }
}


