package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class FIDelete extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
    
    JLabel labelprice;
    JComboBox comboid;
    JTextField tfid;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back,del;
    
    FIDelete(){
    	
        setBounds(370,150,550,300);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));        
        
        JLabel lblbid=new JLabel("BankID:");
        lblbid.setBounds(30,90,150,50);
        add(lblbid);
        
        tfid=new JTextField();
        tfid.setBounds(220,100,150,25);
        add(tfid);
      
        setVisible(true);
         
         del = new JButton("Delete");
         del.setBackground(Color.BLACK);
         del.setForeground(Color.WHITE);
         del.setBounds(70,200,100,25);
         del.addActionListener(this);
         add(del);
                

	        setVisible(true);
    }
                public void actionPerformed(ActionEvent arg){
	        if(arg.getSource() == del){
	            String BankID_s = tfid.getText();
                    int BankID=Integer.parseInt(BankID_s);// Convert the phone number string into an integer
	            
	            try{
	                Conn c=new Conn();
	               
	        		String query3 = " delete from payment_t3 where BankID= ?";
	        		PreparedStatement prep_stmt;
	        		prep_stmt=c.c.prepareStatement(query3);
	        		prep_stmt.setInt(1,BankID);
	        		prep_stmt.execute();
	        		
	        		String query4 = " delete from foreign_exchange1 where Bank_ID= ?";
	        		prep_stmt=c.c.prepareStatement(query4);
	        		prep_stmt.setInt(1,BankID);
	        		prep_stmt.execute();
	        		
	        		String query5 = " delete from rf1 where Bank_id= ?";
	        		prep_stmt=c.c.prepareStatement(query5);
	        		prep_stmt.setInt(1,BankID);
	        		prep_stmt.execute();
	        		
	        		String query = " delete from bank_t1 where BankID= ?";
	        		prep_stmt=c.c.prepareStatement(query);
	        		prep_stmt.setInt(1,BankID);
	        		prep_stmt.execute();
	        		
	        		//bank table 2
	        		String query2 = " delete from bank_t2 where BankID= ?";
	        		
	        		prep_stmt=c.c.prepareStatement(query2);			
	        		prep_stmt.setInt(1,BankID);
	        		prep_stmt.execute();
	            	
	            	JOptionPane.showMessageDialog(null,"Records Deleted Successfully");

	                
	                setVisible(false);
	        }catch(Exception e) {
	        	
	        }
	        }
	            
	        else{
	            setVisible(false);
	        }
	        
	    }
                
        
    public static void main(String[] args){
        new FIDelete();
    }

}


