package RBI;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FIInsert extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
    
    JLabel labelprice;
    JComboBox comboid;
    JTextField tftype,tfid,tflocation,tfcontact,tflicence,tfrevenue,tfproducts,tfadequency,tfcompliance,labelname;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back,add;
    
    FIInsert(){
        
        
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        
        JLabel lblname=new JLabel("Institution Name:");
        lblname.setBounds(30,50,150,25);
        add(lblname);
        
        labelname=new JTextField();
        labelname.setBounds(220,50,150,25);
        add(labelname);
        
        JLabel lbltype=new JLabel("Institution Type:");
        lbltype.setBounds(30,90,150,25);
        add(lbltype);
        
        tftype = new JTextField();
        tftype.setBounds(220,90,150,25);
        add(tftype);
    
        JLabel lblid=new JLabel("Bank ID:");
        lblid.setBounds(30,130,150,25);
        add(lblid);

        tfid=new JTextField();
        tfid.setBounds(220,130,150,25);
        add(tfid);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(30,170,150,25);
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(220,170,150,25);
        add(tflocation);
        
         JLabel lblcontact=new JLabel("Contact info:");
        lblcontact.setBounds(30,210,150,25);
        add(lblcontact);
        
         tfcontact=new JTextField();
        tfcontact.setBounds(220,210,150,25);
        add(tfcontact);
        
        JLabel lbllicence=new JLabel("Licence");
        lbllicence.setBounds(30,250,150,25);
        add(lbllicence);
        
        tflicence=new JTextField();
        tflicence.setBounds(220,250,150,25);
        add(tflicence);
        
       JLabel lblrevenue=new JLabel("Revenue");
        lblrevenue.setBounds(30,280,150,25);
        add(lblrevenue);
        
        tfrevenue=new JTextField();
        tfrevenue.setBounds(220,280,150,25);
        add(tfrevenue);
        
        JLabel lblproducts=new JLabel("Products");
        lblproducts.setBounds(30,310,150,25);
        add(lblproducts);
        
        tfproducts=new JTextField();
        tfproducts.setBounds(220,310,150,25);
        add(tfproducts);
        
        JLabel lbladequency=new JLabel("Capital Adequency");
        lbladequency.setBounds(30,340,150,25);
        add(lbladequency);
        
        tfadequency=new JTextField();
        tfadequency.setBounds(220,340,150,25);
        add(tfadequency);
        
        JLabel lblcompliance=new JLabel("Regulatory Compliance");
        lblcompliance.setBounds(30,370,150,25);
        add(lblcompliance);
        
        tfcompliance=new JTextField();
        tfcompliance.setBounds(220,370,150,25);
        add(tfcompliance);
        
         setVisible(true);
         
         add = new JButton("Add");
	        add.setBackground(Color.BLACK);
	        add.setForeground(Color.WHITE);
	        add.setBounds(70,430,100,25);
	        add.addActionListener(this);
	        add(add);
                

	        setVisible(true);
    }
                public void actionPerformed(ActionEvent arg0){
	        if(arg0.getSource() == add){
	            String IName=labelname.getText();
	            String Itype= tftype.getText(); // Get the phone number as a string
	            String BankID_s = tfid.getText();
                    int BankID=Integer.parseInt(BankID_s);// Convert the phone number string into an integer
	            String location = tflocation.getText(); // Get the phone number as a string
	            String contact = tfcontact.getText();
                    String licence = tflicence.getText();
                    String revenue_s = tfrevenue.getText();
                    int revenue=Integer.parseInt(revenue_s);
                    String product = tfproducts.getText();
                    String rc= tfcompliance.getText();
	            String ca_s = tfadequency.getText();
                    int ca=Integer.parseInt(ca_s);// Get the phone number as a string
	      
	            
	           
	          
	            try{
	                Conn c=new Conn();
	                String query = " insert into bank_t1(Institution_Name,Institution_Type,BankID,Location,Contact_Info,Licence) values(?,?,?,?,?,?) ";
	            	
	            	
	            	

	            	PreparedStatement prep_stmt;
	            	prep_stmt=c.c.prepareStatement(query);
	            	prep_stmt.setString(1,IName);
	            	prep_stmt.setString(2,Itype);
	            	prep_stmt.setInt(3,BankID);
	            	prep_stmt.setString(4,location);
	            	prep_stmt.setString(5,contact);
	            	prep_stmt.setString(6,licence);
	            	
	            	
	            	prep_stmt.execute();
	            	
	            	
	            	
	            	String query2 = " insert into bank_t2(BankID,Revenue,Products,Capital_Adequency,Regulatory_Compliance) values(?,?,?,?,?) ";
	            	
	            	
	            	

	            	PreparedStatement prep_stmt2;
	            	prep_stmt2=c.c.prepareStatement(query2);
	            	prep_stmt2.setInt(1,BankID);
	            	prep_stmt2.setInt(2,revenue);
	            	prep_stmt2.setString(3,product);
	            	prep_stmt2.setInt(4,ca);
	            	prep_stmt2.setString(5,rc);
	            	
	            	
	            	
	            	
	            	prep_stmt2.execute();
	                    
	                    
	                
	                   JOptionPane.showMessageDialog(null,"Records added Successfully");

	                
	                setVisible(false);
	        }catch(Exception e) {
	        	
	        }
	        }
	            
	        else{
	            setVisible(false);
	        }
	        
	    }
                
        
    public static void main(String[] args){
        new FIInsert();
    }

}
