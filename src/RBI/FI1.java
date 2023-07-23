package RBI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FI1 extends JFrame implements ActionListener {
	String username;
    JButton vFI, AFI,FId,FIu,vI,add;
    
         FI1( ){
        //this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(43, 84, 126));
        p1.setBounds(0,0,1600,100);
        add(p1);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
//        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(5,0,70,70);
//        p1.add(image);
        
        JLabel heading=new JLabel("Financial Institutions");
        heading.setBounds(80,10,390,70);
        heading.setForeground(new Color(219, 233, 250));
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        vFI =new JButton("View Records");
        vFI.setBounds(450,20,150,50);
        vFI.setBackground(new Color(219, 233, 250));
        vFI.setForeground(Color.BLACK);
        vFI.addActionListener(this);
        p1.add(vFI);
        
        
        
        AFI =new JButton("Add Records");
        AFI.setBounds(630,20,150,50);
        AFI.setBackground(new Color(219, 233, 250));
        AFI.setForeground(Color.BLACK);
        AFI.addActionListener(this);
        p1.add(AFI);
        
        FId=new JButton("Delete Records");
        FId.setBounds(800,20,150,50);
        FId.setBackground(new Color(219, 233, 250));
        FId.setForeground(Color.BLACK);
        FId.addActionListener(this);
        p1.add(FId);
        
        FIu=new JButton("Update Records");
        FIu.setBounds(970,20,150,50);
        FIu.setBackground(new Color(219, 233, 250));
        FIu.setForeground(Color.BLACK);
        FIu.addActionListener(this);
        p1.add(FIu);
        
        
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/FIP.jpg"));
        Image i5=((ImageIcon) i4).getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(0,0,1300,700);
        add(image1);
        
        add = new JButton("BACK");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,500,100,25);
        add.addActionListener(this);
        add(add);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==vFI){
        	 JFrame frame = new FIView();
             frame.setTitle("Financial Institutions");
             frame.setSize(500, 500);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
        
            
        }
         else if(ae.getSource()==AFI){
             new FIInsert();
         }
         else if(ae.getSource()==FId){
        	 new FIDelete();
        }
         else if(ae.getSource()==FIu){
        	 new FIUpdate(0);
        }else if(ae.getSource()==add){
        	new Dashboard();
        }
     }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FI1();
	}

}
