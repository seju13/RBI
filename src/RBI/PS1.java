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

public class PS1 extends JFrame implements ActionListener {
	String username;
    JButton vFI, AFI,FId,FIu,add;
         PS1( ){
        //this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,128,128));
        p1.setBounds(0,0,1600,100);
        add(p1);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
//        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(5,0,70,70);
//        p1.add(image);
        
        JLabel heading=new JLabel("Payment Systems");
        heading.setBounds(80,30,390,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        vFI =new JButton("View Records");
        vFI.setBounds(450,20,150,50);
        vFI.setBackground(new Color(0,128,128));
        vFI.setForeground(Color.WHITE);
        vFI.addActionListener(this);
        p1.add(vFI);
        
        
        
        AFI =new JButton("Add Records");
        AFI.setBounds(630,20,150,50);
        AFI.setBackground(new Color(0,128,128));
        AFI.setForeground(Color.WHITE);
        AFI.addActionListener(this);
        p1.add(AFI);
        
        FId=new JButton("Delete Records");
        FId.setBounds(800,20,150,50);
        FId.setBackground(new Color(0,128,128));
        FId.setForeground(Color.WHITE);
        FId.addActionListener(this);
        p1.add(FId);
        
        FIu=new JButton("Update Records");
        FIu.setBounds(970,20,150,50);
        FIu.setBackground(new Color(0,128,128));
        FIu.setForeground(Color.WHITE);
        FIu.addActionListener(this);
        p1.add(FIu);
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/PSpic.png"));
        Image i5=i4.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(0,0,1300,900);
        add(image1);
        
        add = new JButton("BACK");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,600,100,25);
        add.addActionListener(this);
        add(add);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==vFI){
        	  JFrame frame = new 	PSView();
              frame.setTitle("Payment Systems");
              frame.setSize(500, 300);
              frame.setLocationRelativeTo(null);
              frame.setVisible(true);
        
            
        }
         else if(ae.getSource()==AFI){
             new PSInsert();
         }
         else if(ae.getSource()==FId){
        	 new PSDelete();
        }else if(ae.getSource()==add){
        	new Dashboard();
        }
         
     }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PS1();
	}

}
