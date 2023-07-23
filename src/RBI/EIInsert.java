package RBI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EIInsert extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
    
    JLabel labelprice;
    JComboBox comboid;
    JTextField tfdate,tfItype,tfeid,tfIvalue,tfPvalue,tfch;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back,add;
    
    EIInsert(){
        
        
        setBounds(250,120,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 255, 255));
        
        JLabel lblIvalue=new JLabel("Indicator value");
        lblIvalue.setBounds(30,50,150,25);
        add(lblIvalue);
        
        tfIvalue=new JTextField();
        tfIvalue.setBounds(220,50,150,25);
        add(tfIvalue);
        
        JLabel lblPvalue=new JLabel("Previous value");
        lblPvalue.setBounds(30,90,150,25);
        add(lblPvalue);
        
        tfPvalue = new JTextField();
        tfPvalue.setBounds(220,90,150,25);
        add(tfPvalue);
    
        JLabel lblch=new JLabel("Change");
        lblch.setBounds(30,130,150,25);
        add(lblch);

        tfch=new JTextField();
        tfch.setBounds(220,130,150,25);
        add(tfch);
        
        JLabel lbleid=new JLabel("Economic Indicator ID");
        lbleid.setBounds(30,170,150,25);
        add(lbleid);
        
        tfeid=new JTextField();
        tfeid.setBounds(220,170,150,25);
        add(tfeid);
        
        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(30,210,150,25);
        add(lbldate);
        
         tfdate=new JTextField();
         tfdate.setBounds(220,210,150,25);
        add(tfdate);
        
        JLabel lblItype=new JLabel("Indicator type");
        lblItype.setBounds(30,250,150,25);
        add(lblItype);
        
        tfItype=new JTextField();
        tfItype.setBounds(220,250,150,25);
        add(tfItype);
        
        
        
       
        
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
	        	String Ivalue_s = tfIvalue.getText();
	            double Ivalue=Double.parseDouble(Ivalue_s);
	            String Pvalue_s = tfPvalue.getText();
	            double Pvalue=Double.parseDouble(Pvalue_s);
                String change_s = tfch.getText();
                double change=Double.parseDouble(change_s);
                String eid_s= tfeid.getText(); 
	            int eid=Integer.parseInt(eid_s);
	            String date=tfdate.getText();
	            String type = tfItype.getText();
	            
	          
	            try{
	                Conn c=new Conn();
	            	String query = " insert into economic_indicator(IValue,PreValues,Changes,EID,Date,IType) values(?,?,?,?,?,?) ";
	        
	        	
	        		PreparedStatement prep_stmt;
	        		prep_stmt=c.c.prepareStatement(query);
	        		prep_stmt.setDouble(1,Ivalue);
	        		prep_stmt.setDouble(2,Pvalue);
	        		prep_stmt.setDouble(3,change);
	        		prep_stmt.setInt(4,eid);
	        		prep_stmt.setString(5,date);
	        		prep_stmt.setString(6,type);
	        		prep_stmt.execute();
	                    
	                    
	                
	                   JOptionPane.showMessageDialog(null,"Records added Successfully");

	                
	                setVisible(false);
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	        }
	            
	        else{
	            setVisible(false);
	        }
	        
	    }
                
        
    public static void main(String[] args){
        new EIInsert();
    }

}
