package RBI;


import javax.swing.*;

import java.awt.*;

import java.sql.*;

import java.awt.event.*;


public class RFInsert extends JFrame implements ActionListener{

    Choice c1,c2;

     JTextField t1;

   

    JLabel labelprice;

    JComboBox comboid;

    JTextField tfcat, tfRT ,tfIdate,  tfCdate,tfRA, tfrid;

    JRadioButton rmale,rfemale;

    JButton checkprice,bookpackage,back,add;

   

    RFInsert(){

       

       

        setBounds(250,120,850,550);

        setLayout(null);

        getContentPane().setBackground(new Color(255, 255, 224));



        JLabel lblcat=new JLabel("Category");

        lblcat.setBounds(30,50,150,25);

        add(lblcat);

       

        tfcat=new JTextField();

        tfcat.setBounds(220,50,150,25);

        add(tfcat);

       

        JLabel lblRT=new JLabel("Regulatory Title");

        lblRT.setBounds(30,90,150,25);

        add(lblRT);

       

        tfRT = new JTextField();

         tfRT .setBounds(220,90,150,25);

        add(tfRT);

   

        JLabel lblIdate=new JLabel("Implementation Date");

        lblIdate.setBounds(30,130,150,25);

        add(lblIdate);


        tfIdate=new JTextField();

      tfIdate.setBounds(220,130,150,25);

        add(tfIdate);


        JLabel  lblCdate=new JLabel("Compliance Date");

        lblCdate.setBounds(30,170,150,25);

        add(lblCdate);

       

        tfCdate=new JTextField();

         tfCdate.setBounds(220,170,150,25);

        add(tfCdate);

       

        JLabel lblRA=new JLabel("Regulatory Authority");

        lblRA.setBounds(30,210,150,25);

        add(lblRA);

       

         tfRA=new JTextField();

         tfRA.setBounds(220,210,150,25);

        add(tfRA);

       

        JLabel lblrid=new JLabel("RID");

      lblrid.setBounds(30,250,150,25);

        add(lblrid);

       

        tfrid=new JTextField();

        tfrid.setBounds(220,250,150,25);

        add( tfrid);

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

        String Category= tfcat.getText();

        String Regulation_Title = tfRT.getText();

         String ImpDate =tfIdate.getText();

         String CompDate = tfCdate.getText();

         String RegAuth = tfRA.getText();

         String Rid_s = tfrid .getText();

         int Rid=Integer.parseInt(Rid_s);

  

  try{

               Conn c=new Conn();

String query = " insert into rf1(Category,Regulation_Title,Implementation_date,Compliance_date,Regulatory_Authority,RID)"+" values(?,?,?,?,?,?) ";


PreparedStatement prep_stmt;

prep_stmt=c.c.prepareStatement(query);

prep_stmt.setString(1,Category);

prep_stmt.setString(2,Regulation_Title);

prep_stmt.setString(3,ImpDate);

prep_stmt.setString(4,CompDate);

prep_stmt.setString(5,RegAuth);

prep_stmt.setInt(6,Rid);


prep_stmt.execute();


JOptionPane.showMessageDialog(null,"Records added Successfully");


  setVisible(false);

       }catch(Exception e) {

        System.out.println(e);

       }

       }   else{

           setVisible(false);

       }
       }
        public static void main(String[] args){
        new RFInsert();

        }
}

