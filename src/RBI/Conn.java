package RBI;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
    	 final String DB_URL ="jdbc:mysql://localhost:3306/rbi";
    	 final String USER = "root";
    	 final String PASS="Mysql@123";
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting to the database");
            c=DriverManager.getConnection(DB_URL,USER,PASS);
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}