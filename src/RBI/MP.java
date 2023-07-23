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

public class MP extends JFrame implements ActionListener {
	String username;
    JButton vFI, AFI,FId,FIu,add;
    MP( ){
        //this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(171, 120, 78));
        p1.setBounds(0,0,1600,100);
        add(p1);
        
        JLabel heading=new JLabel("Monetary Policy");
        heading.setBounds(80,25,390,40);
        heading.setForeground(new Color(222, 184, 135));
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        vFI =new JButton("View Records");
        vFI.setBounds(450,20,150,50);
        vFI.setBackground(new Color(222, 184, 135));
        vFI.setForeground(Color.BLACK);
        vFI.addActionListener(this);
        p1.add(vFI);
        
        
        
        AFI =new JButton("Add Records");
        AFI.setBounds(630,20,150,50);
        AFI.setBackground(new Color(222, 184, 135));
        AFI.setForeground(Color.BLACK);
        AFI.addActionListener(this);
        p1.add(AFI);
        
        FId=new JButton("Delete Records");
        FId.setBounds(800,20,150,50);
        FId.setBackground(new Color(222, 184, 135));
        FId.setForeground(Color.BLACK);
        FId.addActionListener(this);
        p1.add(FId);
        
        FIu=new JButton("Update Records");
        FIu.setBounds(970,20,150,50);
        FIu.setBackground(new Color(222, 184, 135));
        FIu.setForeground(Color.BLACK);
        FIu.addActionListener(this);
        p1.add(FIu);
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/monpic.jpg"));
        Image i5=i4.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(0,70,1300,700);
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
        	 JFrame frame = new MPView();
             frame.setTitle("Monetary Policy");
             frame.setSize(500, 300);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
        
            
        }
         else if(ae.getSource()==AFI){
             new MPInsert();
         }
         else if(ae.getSource()==FIu){
             new MPUpdate(0);
         }
         
         else if(ae.getSource()==FId){
        	 new MPDelete();
        }else if(ae.getSource()==add){
        	new Dashboard();
        }
        
     }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MP();
	}

}
