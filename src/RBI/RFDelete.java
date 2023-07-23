package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class RFDelete extends JFrame implements ActionListener{
    Choice c1,c2;
     JTextField t1;
    
    JLabel labelprice;
    //JComboBox comboid;
    JTextField tfid;
    JRadioButton rmale,rfemale;
    JButton checkprice,bookpackage,back,del;
    
    RFDelete(){
    	
        setBounds(370,150,550,300);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 224));
        
        
        JLabel lblrid=new JLabel("RID:");
        lblrid.setBounds(30,90,150,25);
        add(lblrid);
        
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
	            String rf = tfid.getText();
                    int rfw=Integer.parseInt(rf);
	            
	            try{
	                Conn c=new Conn();
	                String query = " delete from rf1 where RID= ?";
	            	String query2 = " delete from regulation_indicator where RID= ?";
	            	PreparedStatement prep_stmt;
	            	prep_stmt=c.c.prepareStatement(query);
	            	prep_stmt.setInt(1,rfw);
	            	prep_stmt.execute();
	            	prep_stmt=c.c.prepareStatement(query2);
	            	prep_stmt.setInt(1,rfw);
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
        new RFDelete();
    }
}







