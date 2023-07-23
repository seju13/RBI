package RBI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    JButton FI1,FI2,PS1,PS2,PS3,EI,MP,FE,RE,viewbookedHotels,Destinations,payments,Calculators,notepad,about;
    Dashboard( ){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        JFrame frame=new JFrame();
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(56, 172, 236));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/rbiPic.jpg"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);
        //image of rbi
        JLabel heading=new JLabel("RESERVE BANK OF INDIA");
        heading.setBounds(80,10,400,60);
        heading.setForeground(new Color(237, 218, 116));
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(56, 172, 236));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        FI1=new JButton("Financial Institution");
        FI1.setBounds(0,0,350,100);
        FI1.setBackground(new Color(152, 175, 199));
        FI1.setForeground(Color.BLACK);
        FI1.setFont(new Font("Tahoma",Font.PLAIN,20));
        FI1.setMargin(new Insets(0,0,0,60));
        FI1.addActionListener(this);
        p2.add(FI1);
        
   
        
        PS1=new JButton("Payment system ");
        PS1.setBounds(0,100,350,100);
        PS1.setBackground(new Color(152, 175, 199));
        PS1.setForeground(Color.BLACK);
        PS1.setFont(new Font("Tahoma",Font.PLAIN,20));
        PS1.setMargin(new Insets(0,0,0,60));
        PS1.addActionListener(this);
        p2.add(PS1);
        
         
        
        
        
         EI=new JButton("Economic Indicators");
        EI.setBounds(0,200,300,100);
        EI.setBackground(new Color(152, 175, 199));
        EI.setForeground(Color.BLACK);
        EI.setFont(new Font("Tahoma",Font.PLAIN,20));
        EI.setMargin(new Insets(0,0,0,60));
        EI.addActionListener(this);
        p2.add(EI);
        
         MP=new JButton("Montary Policy");
        MP.setBounds(0,300,300,100);
        MP.setBackground(new Color(152, 175, 199));
        MP.setForeground(Color.BLACK);
        MP.setFont(new Font("Tahoma",Font.PLAIN,20));
        MP.setMargin(new Insets(0,0,0,60));
        MP.addActionListener(this);
        p2.add(MP);
        
         FE=new JButton("Foreign Exchange");
        FE.setBounds(0,400,300,100);
        FE.setBackground(new Color(152, 175, 199));
        FE.setForeground(Color.BLACK);
        FE.setFont(new Font("Tahoma",Font.PLAIN,20));
        FE.setMargin(new Insets(0,0,0,60));
        FE.addActionListener(this);
        p2.add(FE);
        
        RE=new JButton("Regulatory Framework");
        RE.setBounds(0,500,300,100);
        RE.setBackground(new Color(152, 175, 199));
        RE.setForeground(Color.BLACK);
        RE.setFont(new Font("Tahoma",Font.PLAIN,20));
        RE.setMargin(new Insets(0,0,0,60));
        RE.addActionListener(this);
        p2.add(RE);
        
         
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/rbiBuilding.jpg"));
        Image i5=i4.getImage().getScaledInstance(15100,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel i7=new JLabel(i4);
        i7.setBounds(300,0,1000,700);
        add(i7);
        
      
        // Create a JPanel object
        
//        JLabel text=new JLabel("Travel and Tourism Management System");
//        text.setBounds(400,70,1200,70);
//        text.setForeground(Color.RED);
//        text.setFont(new Font("Raleway",Font.PLAIN,40));
//        i7.add(text);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==FI1){
            new FI1();
        }
        else if(ae.getSource()==EI){
            new EI();
        } 
        else if(ae.getSource()==FE){
            new FE();
        }
        else if(ae.getSource()==RE){
           new RF();
        }
        else if(ae.getSource()==MP){
            new MP();
        }
        else if(ae.getSource()==PS1){
            new PS1();
        }
        
    }
     public static void main(String[] args){
        new Dashboard();
    }
}
