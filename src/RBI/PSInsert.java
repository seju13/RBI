package RBI;


import javax.swing.*;

import java.awt.*;

import java.sql.*;

import java.awt.event.*;


public class PSInsert extends JFrame implements ActionListener{

    Choice c1,c2;

     JTextField t1;

   

    JLabel labelprice;

    JComboBox comboid;

    JTextField tfpid,tftid ,tfdate, tfava,tfbid,tfptype,tfoper, tfpart,tfvol,tfval,tftime;

    JRadioButton rmale,rfemale;

    JButton checkprice,bookpackage,back,add;

   

    PSInsert(){

       

       

        setBounds(450,100,850,550);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

       

        JLabel lblpid=new JLabel("Payment ID");

        lblpid.setBounds(30,50,150,25);

        add(lblpid);

       

        tfpid=new JTextField();

        tfpid.setBounds(220,50,150,25);

        add(tfpid);

       

        JLabel lbtid=new JLabel("Transaction ID");

        lbtid.setBounds(30,90,150,25);

        add(lbtid);

       

        tftid = new JTextField();

        tftid .setBounds(220,90,150,25);

        add(tftid );

   

        JLabel lbdate=new JLabel("Date");

        lbdate.setBounds(30,130,150,25);

        add(lbdate);


        tfdate=new JTextField();

        tfdate.setBounds(220,130,150,25);

        add(tfdate);

       

        JLabel  lbava =new JLabel("Availability");

        lbava.setBounds(30,170,150,25);

        add(lbava);

       

        tfava=new JTextField();

        tfava.setBounds(220,170,150,25);

        add(tfava);

       

        JLabel lbbid=new JLabel("Bank ID");

        lbbid.setBounds(30,210,150,25);

        add(lbbid);

       

         tfbid=new JTextField();

         tfbid.setBounds(220,210,150,25);

        add(tfbid);

       

        JLabel lbptype=new JLabel("Payment type");

       lbptype.setBounds(30,250,150,25);

        add(lbptype);

       

        tfptype=new JTextField();

       tfptype.setBounds(220,250,150,25);

        add(tfptype);


       JLabel lboper=new JLabel("Payment Operator");

        lboper.setBounds(30,290,150,25);

        add( lboper);

       

        tfoper=new JTextField();

       tfoper.setBounds(220,290,150,25);

        add(tfoper);


       JLabel lbpart=new JLabel("Payment Participant");

       lbpart.setBounds(30,320,150,25);

        add(lbpart);

       

        tfpart=new JTextField();

       tfpart.setBounds(220,320,150,25);

        add( tfpart);

       

JLabel lbvol=new JLabel("Transaction Volume");

       lbvol.setBounds(30,350,150,25);

        add(lbvol);

       

        tfvol=new JTextField();

       tfvol.setBounds(220,350,150,25);

        add( tfvol);


JLabel lbval=new JLabel("Transaction Value");

        lbval.setBounds(30,380,150,25);

        add( lbval);

       

        tfval=new JTextField();

       tfval.setBounds(220,380,150,25);

        add( tfval);


JLabel lbtime=new JLabel("Settlement time");

       lbtime.setBounds(30,410,150,25);

        add(lbtime);

       

        tftime=new JTextField();

       tftime.setBounds(220,410,150,25);

        add( tftime);

       

       

       

       

         setVisible(true);

         

         add = new JButton("Add");

       add.setBackground(Color.BLACK);

       add.setForeground(Color.WHITE);

       add.setBounds(70,450,100,25);

       add.addActionListener(this);

       add(add);

               


       setVisible(true);

    }

                public void actionPerformed(ActionEvent arg0){

       if(arg0.getSource() == add){

        String PID_s = tfpid.getText();

         int PID=Integer.parseInt(PID_s);

           String TID_s = tftid.getText();

         int TID=Integer.parseInt(TID_s);

         String Date = tfdate.getText();

         String Ava = tfava.getText();

         String bid_s = tfbid.getText();

         int BID=Integer.parseInt(bid_s);

         String ptype = tfptype.getText();

         String Poper=tfoper.getText();

         String Ppart=tfpart.getText();

         String Tvol=tfvol.getText();

String Tval=tfval.getText();

String Ttime=tftime.getText();

       

           

     

           try{

               Conn c=new Conn();

          String query = " insert into payment_t3(Payment_ID,Date,TransactionID,Availability)"+" values(?,?,?,?) ";


PreparedStatement prep_stmt;

prep_stmt=c.c.prepareStatement(query);

prep_stmt.setInt(1,PID);

prep_stmt.setString(2,Date);

prep_stmt.setLong(3,TID);

prep_stmt.setString(4,Ava);


prep_stmt.execute();

       

String query2 = " insert into payment_t4(Payment_ID,Type,Operator,Participant,TransactionID)"+" values(?,?,?,?,?) ";

       

 PreparedStatement prep_stmt2;

prep_stmt2=c.c.prepareStatement(query2);

prep_stmt2.setInt(1,PID);

prep_stmt2.setString(2,ptype);

prep_stmt2.setString(3,Poper);

prep_stmt2.setString(4,Ppart);

prep_stmt2.setLong(5,TID);


prep_stmt2.execute();


String query3 = " insert into payment_t5(TransactionID,Volume,Value,Time)"+" values(?,?,?,?) ";


PreparedStatement prep_stmt3;

prep_stmt3=c.c.prepareStatement(query3);

prep_stmt3.setLong(1,TID);

prep_stmt3.setString(2,Tvol);

prep_stmt3.setString(3,Tval);

prep_stmt3.setString(4,Ttime);


prep_stmt3.execute();





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

        new PSInsert();

    }


}

