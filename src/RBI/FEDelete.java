package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class FEDelete extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
    
    JLabel labelprice;
    JComboBox comboid;
    JTextField tfid;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back,del;
    
    FEDelete(){
    	
        setBounds(300,150,550,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel lbleid=new JLabel("Transaction Value:");
        lbleid.setBounds(30,90,150,25);
        add(lbleid);
        
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
	            String tvalue = tfid.getText();
                    int tv=Integer.parseInt(tvalue);
	            
	            try{
	                Conn c=new Conn();
	                String query = " delete from foreign_exchange1 where Transaction_Value= ?";
	        		PreparedStatement prep_stmt;
	        		prep_stmt=c.c.prepareStatement(query);
	        		prep_stmt.setInt(1,tv);
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
        new FEDelete();
    }
}






