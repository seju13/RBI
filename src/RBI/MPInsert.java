package RBI;


import javax.swing.*;

import java.awt.*;

import java.sql.*;

import java.awt.event.*;


public class MPInsert extends JFrame implements ActionListener{

    Choice c1,c2;

     JTextField t1;

   

    JLabel labelprice;

    JComboBox comboid;

    JTextField  tfdate, tfItype ,tfIval,  tfTV;

    JRadioButton rmale,rfemale;

    JButton checkprice,bookpackage,back,add;

   

    MPInsert(){

       

       

        setBounds(250,120,850,550);

        setLayout(null);

        getContentPane().setBackground(new Color(255, 255, 224));


        JLabel lbldate=new JLabel("Date");

        lbldate.setBounds(30,50,150,25);

        add(lbldate);

       

        tfdate=new JTextField();

        tfdate.setBounds(220,50,150,25);

        add( tfdate);

       

        JLabel lblItype=new JLabel("Instrument Type");

        lblItype.setBounds(30,90,150,25);

        add(lblItype);

       

        tfItype = new JTextField();

         tfItype .setBounds(220,90,150,25);

        add(tfItype);

   

        JLabel lblIval=new JLabel("Instrument Value");

        lblIval.setBounds(30,130,150,25);

        add(lblIval);


        tfIval=new JTextField();

      tfIval.setBounds(220,130,150,25);

        add(tfIval);


        JLabel  lblTV =new JLabel("Target Variable");

         lblTV .setBounds(30,170,150,25);

        add( lblTV );

       

        tfTV=new JTextField();

         tfTV.setBounds(220,170,150,25);

        add(tfTV);

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

        String Date=tfdate.getText();

        String it = tfItype.getText();

        String iv_s =tfIval.getText();

        int iv=Integer.parseInt(iv_s);

        String tv = tfTV.getText();

  try{

     Conn c=new Conn();

String query = " insert into monetary_policy(Date,Instrument_type,Instrument_Value,Target_Variable,Impact)"+" values(?,?,?,?,?) ";


PreparedStatement prep_stmt;

prep_stmt=c.c.prepareStatement(query);

prep_stmt.setString(1,Date);

prep_stmt.setString(2,it);

prep_stmt.setInt(3,iv);

prep_stmt.setString(4,tv);

prep_stmt.setString(5,"-");



prep_stmt.execute();

JOptionPane.showMessageDialog(null,"Records added Successfully");


  setVisible(false);

       }catch(Exception e) {
        System.out.println(e);
       }
       }   else{
           setVisible(false);
       }
   } public static void main(String[] args){

        new MPInsert();

    }


}
