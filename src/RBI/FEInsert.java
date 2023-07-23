package RBI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class FEInsert extends JFrame implements ActionListener{

    Choice c1,c2;

     JTextField t1;

   

    JLabel labelprice;

    JComboBox comboid;

    JTextField tfdate,tfcurr ,tfexr,  tfTtype,tfTval,tfCP,tfpur, tfSdate;

    JRadioButton rmale,rfemale;

    JButton checkprice,bookpackage,back,add;

   

    FEInsert(){

       

        setBounds(450,00,850,550);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);


        JLabel lbldate=new JLabel("Date");

        lbldate.setBounds(30,50,150,25);

        add(lbldate);

       

        tfdate=new JTextField();

        tfdate.setBounds(220,50,150,25);

        add(tfdate);

       

        JLabel lblcurr=new JLabel("Currencies");

        lblcurr.setBounds(30,90,150,25);

        add(lblcurr);

       

        tfcurr = new JTextField();

        tfcurr .setBounds(220,90,150,25);

        add(tfcurr);

   

        JLabel lblexr=new JLabel("Exchange Rate");

        lblexr.setBounds(30,130,150,25);

        add(lblexr);


        tfexr=new JTextField();

       tfexr.setBounds(220,130,150,25);

        add(tfexr);


        JLabel  lblTtype=new JLabel("Transaction Type");

        lblTtype.setBounds(30,170,150,25);

        add(lblTtype);

       

        tfTtype=new JTextField();

         tfTtype.setBounds(220,170,150,25);

        add( tfTtype);

       

        JLabel lblTval=new JLabel("Bank ID");

        lblTval.setBounds(30,210,150,25);

        add(lblTval);

       

         tfTval=new JTextField();

         tfTval.setBounds(220,210,150,25);

         add(tfTval);

       

        JLabel lblCP=new JLabel("Payment type");

        lblCP.setBounds(30,270,150,25);

        add(lblCP);

       

        tfCP=new JTextField();

        tfCP.setBounds(220,270,150,25);

        add(tfCP);


        JLabel lblpur=new JLabel("Payment Operator");

        lblpur.setBounds(30,320,150,25);

        add(lblpur);

       

        tfpur=new JTextField();

        tfpur.setBounds(220,320,150,25);

        add(tfpur);


       JLabel lblSdate=new JLabel("Payment Participant");

       lblSdate.setBounds(30,380,150,25);

       add(lblSdate);

       

        tfSdate=new JTextField();

        tfSdate.setBounds(220,380,150,25);

        add(tfSdate);

        setVisible(true);

     

        add = new JButton("Add");

       add.setBackground(Color.BLACK);

       add.setForeground(Color.WHITE);

       add.setBounds(70,460,100,25);

       add.addActionListener(this);

       add(add);

       setVisible(true);

    }

    public void actionPerformed(ActionEvent arg0){

       if(arg0.getSource() == add){

        String Date= tfdate.getText();

        String Curr = tfcurr.getText();

         String Exr_s = tfexr.getText();

         int Exr=Integer.parseInt(Exr_s);

         String Ttype = tfTtype.getText();

         String Tval_s = tfTval.getText();

         int Tval=Integer.parseInt(Tval_s);

         String CP = tfCP.getText();

         String Pur=tfpur.getText();

         String SDate=tfSdate.getText();

     

                try{

               Conn c=new Conn();

String query = " insert into foreign_exchange1(Date,Currencies,Exchange_Rate,Transaction_type,Transaction_Value,CounterParty,Purpose,Settlement_Date)"+" values(?,?,?,?,?,?,?,?) ";

PreparedStatement prep_stmt;

prep_stmt=c.c.prepareStatement(query);

prep_stmt.setString(1,Date);

prep_stmt.setString(2,Curr);

prep_stmt.setInt(3,Exr);

prep_stmt.setString(4,Ttype);

prep_stmt.setInt(5,Tval);

prep_stmt.setString(6,CP);

prep_stmt.setString(7,Pur);

prep_stmt.setString(8,SDate);


prep_stmt.execute();


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

        new FEInsert();

    }


}

