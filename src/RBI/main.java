package RBI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;


public class main {
	static final String DB_URL ="jdbc:mysql://localhost:3306/rbi";
	static final String USER = "root";
	static final String PASS="Mysql@123";
	
	public main() {
		
	}

	public static void main(String args[]) throws SQLException
	{
		
		Connection conn = null;
		Statement stmt = null;
		//char c='y';
		int n = 0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to the Database");
			
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
		do
		{
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();	
			System.out.println("Menu:\n1.Insert\n2.Display\n3.Update\n4.Delete");
			System.out.println("***********************************Enter Your choice:************************************");
			BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
			int a=Integer.parseInt(b.readLine());
		switch(a)
		{
		    case 1:{
			System.out.println("***********************************Inserting :***********************************");
			
			//which table?
			
			System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions\n6.Monetary Policy");
			System.out.println("Enter choice:");
			
			int table_choice=Integer.parseInt(b.readLine());
			
			
			switch(table_choice) {
			case 1: {
				
				
				
			break;
				//stmt.executeUpdate(query);
			}
			
			case 2:{
				
				break;
			}
			
			//economic indicator 
			
			case 3: {

				break;
			}
			
			case 4:{
				//Foreign Exchange
				
				break;
				
			}
			 // bank tables 
			case 5:{
				
				
				break;
				
				
			}
			case 6:{
			//monetary policy
                
				
			
			}
			
			}
			
			conn.close();
			break;
		}
			
		     // default:System.out.println("Wrong input!!");
			
			
			
		
		case 2:{
			System.out.println("***********************************DISPLAY***********************************");
			
			//which table?
			
			System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions\n6.Monetary Policy");
			System.out.println("Enter choice:");
			
			int table_choice=Integer.parseInt(b.readLine());
			
			switch(table_choice) {
			case 1: {
				//payment systems table 1
				
				System.out.println("***********************************Payment Systems***********************************");
				String query1 = " select * from payment_t3";
				int count1 = 0;
				ResultSet rs=stmt.executeQuery(query1);
				while(rs.next())
				{
				String PaymentID=rs.getString("Payment_ID");
				long TransactionID=rs.getLong("TransactionID");
				String Date=rs.getString("Date");
				String Availability=rs.getString("Availability");
				String output = "Data %d: %d - %s - %s -%s";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count1,TransactionID, Date,Availability,PaymentID));
				}
				
				//table 2
				
				System.out.println("Database contains:");
				String query2 = " select * from payment_t4" ;
				int count2 = 0;
				ResultSet res=stmt.executeQuery(query2);
				while(res.next())
				{
				String PaymentID=res.getString("Payment_ID");
				String Type=res.getString("Type");
				String Operator=res.getString("Operator");
				String Particpant=res.getString("Participant");
				long TransactionID=res.getLong("TransactionID");
				String output = "Data %d: %d - %s - %s -%s -%s ";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count2,TransactionID,Type,Operator,Particpant,PaymentID));
				}
				
				//table 3
				
				System.out.println("Database contains:");
				String query3 = " select * from payment_t5" ;
				int count3 = 0;
				ResultSet resu=stmt.executeQuery(query3);
				while(resu.next())
				{
				long TID=resu.getLong("TransactionID");
				int Volume=resu.getInt("Volume");
				int Value=resu.getInt("Value");
				String Time=resu.getString("Time");
				String output = "Data %d: %d - %d - %s -%d ";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count3,Value,Volume,Time,TID));
				}
				break;
			}
			//table reg_frameworks
				case 2:{
					
					System.out.println("***********************************Regulatory Framework***********************************");
					String query1 = " select * from rf1" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					
					while(rs.next())
					{
					String Category=rs.getString("Category");
					String Regulation_Title=rs.getString("Regulation_Title");
					String Implementation_date=rs.getString("Implementation_date");
					String II=rs.getString("Insitutions_involved");
					String Compliance_date=rs.getString("Compliance_date");
					String Regulatory_Authority=rs.getString("Regulatory_Authority");
					int BankID=rs.getInt("Bank_id");
					int RID=rs.getInt("RID");
					
					String output = "Data %d: %s  %s - %s -%s -%s - %s - %d - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Category,Regulation_Title,Implementation_date,II,Compliance_date,Regulatory_Authority,BankID,RID));
					}
					break;
				}
				
				case 3:{
					//economic indicator
					System.out.println("***********************************Economic Indicator***********************************");
					String query1 = " select * from economic_indicator" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Date=rs.getString("Date");
					String Itype=rs.getString("Itype");
					Double IValue=rs.getDouble("IValue");
					String PreValues=rs.getString("PreValues");
					String Change=rs.getString("Change");
					String Frequency=rs.getString("Frequency");
					int EID=rs.getInt("EID");
					String output = "Data %d: %s - %s - %f -%s -%s - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Date,Itype,IValue,PreValues,Change,Frequency,EID));
					}
					break;
				}
				case 4:{
					//Foreign Exchange
					System.out.println("***********************************Foreign Exchange***********************************");
					String query1 = " select * from  foreign_exchange1" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Date=rs.getString("Date");
					String Curriences=rs.getString("Currencies");
					Double Er=rs.getDouble("Exchange_Rate");
					String TT=rs.getString("Transaction_type");
					int TV=rs.getInt("Transaction_Value");
					String CP=rs.getString("CounterParty");
					String Purpose=rs.getString("Purpose");
					String SD=rs.getString("Settlement_Date");
					int Bankid=rs.getInt("Bank_ID");
					String output = "Data %d: %s - %s - %f -%s -%d - %s - %s - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Date,Curriences,Er,TT,TV,CP,Purpose,SD,Bankid));
					}
					break;
				}
				
				case 5:{
					// bank tables
					System.out.println("***********************************BANK***********************************");
					String query1 = " select * from bank_t1" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Institution_Name=rs.getString("Institution_Name");
					String Institution_Type=rs.getString("Institution_Type");
                     int Bank_Id=rs.getInt("BankID");
                    String Location=rs.getString("Location");
                    String Contact_Info=rs.getString("Contact_Info");
					String Licence=rs.getString("Licence");
					String output = "Data %d: %s - %s - %s -%s -%d - %s ";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Licence,Institution_Type,Institution_Name,Location,Bank_Id,Contact_Info));
					}
					
					System.out.println("Database contains:");
					String query2 = " select * from bank_t2" ;
					int count2 = 0;
					ResultSet res=stmt.executeQuery(query2);
					while(res.next())
					{
					int Bank_ID=res.getInt("BankID");
					int Revenue=res.getInt("Revenue");
					String Products=res.getString("Products");
					String Regulatory_Compliance=res.getString("Regulatory_Compliance");
					int Capital_Adequency=res.getInt("Capital_Adequency");
	
					String output = "Data %d: %d - %s - %d -%s -%d ";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count2,Bank_ID,Regulatory_Compliance,Revenue,Products,Capital_Adequency));
					}
					
				}
				case 6:{	
					//monetary policy
					System.out.println("***********************************Monetary Policy***********************************");
					String query1 = " select * from monetary_policy" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Date=rs.getString("Date");
					String Instrument_type=rs.getString("Instrument_type");
                    int Instrument_Value=rs.getInt("Instrument_Value");
                    String Target_Variable=rs.getString("Target_Variable");
                    String Impact=rs.getString("Impact");
                    String output = "Data %d: %s - %s - %d  -%s - %s ";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Date,Instrument_type,Instrument_Value,Target_Variable,Impact));
					}
				}
			}
			conn.close();
			break;
		}
			case 3:
			   {
			      System.out.println("***********************************UPDATE***********************************");
			      System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions");
			      System.out.println("Enter choice:");
			      
			      int table_choice=Integer.parseInt(b.readLine());
			      
			      int c;
				String query;
				PreparedStatement prep_stmt;
				switch(table_choice) {
			      case 1: {
			         //payment table 1
			         System.out.println("Enter Payment_ID to be updated:");
			         String Payment_ID=b.readLine();
			         System.out.println("What do you want to update: \n1.Transaction ID \n2.Availability \n3.Payment Operator \n4.Payment Participants");
	
			         c=Integer.parseInt(b.readLine());
			         switch(c) {
			         case 1:
			         {
			        	 System.out.println("Enter Transaction_ID to be updated");
				         String tid = b.readLine();

				         query = " update payment_t5 set TransactionID=?" + " where TransactionID=(select TransactionID from payment_t3 where Payment_ID= ?)";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setString(1, tid);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute();
				         
				         query = " update payment_t4 set TransactionID=?" + " where TransactionID=(select TransactionID from payment_t3 where Payment_ID= ?)";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setString(1, tid);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute();

				         query = " update payment_t3 set TransactionID=?" + " where Payment_ID= ?";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setString(1, tid);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute(); 
				         break;
			         }
			         case 2:
			         {
			        	 System.out.println("Enter new Availability:");
				         int avail = Integer.parseInt(b.readLine());
				         query = " update payment_t3 set Availability=?" + " where Payment_ID= ?";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setInt(1, avail);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute();
				         break;
			         }
			         case 3:
			         {
				    	 System.out.println("Enter new Payment Operator:");
				         String PO = b.readLine();
				         query = " update payment_t4 set Operator=?" + " where Payment_ID= ?";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setString(1, PO);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute();
				         break;
			         }
			         case 4:
			         {
			        	 System.out.println("Enter new Payment Participant:");
				         String PP = b.readLine();
				         query = " update payment_t4 set Participant=?" + " where Payment_ID= ?";
				         prep_stmt=conn.prepareStatement(query);
				         prep_stmt.setString(1, PP);
				         prep_stmt.setString(2,Payment_ID);
				         prep_stmt.execute();
				         break;
			         }
			        	 
			         }
			     
			         break;
			      }
			      case 2:{
			    	  //Regulatory Frameworks 2
			    	  System.out.println("Enter Implementation Date to be updated:");
			            String dat= b.readLine();
			            System.out.println("Want to do you update? \n1.Category \n2.Regulation Title \n3.Regulatory Authority ?");
			            c=Integer.parseInt(b.readLine());
			            switch(c) {
			            case 1:
			            {
			            	System.out.println("Enter Category to be updated");
				            String Category = b.readLine();
				            query = " update rf1 set Category=?" + " where Implementation_date= ?";
				            prep_stmt=conn.prepareStatement(query);
				            prep_stmt.setString(1, Category);
				            prep_stmt.setString(2,dat);
				            prep_stmt.execute();
				            break;
			            }
			            case 2:
			            {
			            	 System.out.println("Enter Regulation Title to be updated");
				             String rt = b.readLine();
				             query = " update rf1 set Regulation_Title=?" + " where Implementation_date= ?";
				             prep_stmt=conn.prepareStatement(query);
				             prep_stmt.setString(1, rt);
				             prep_stmt.setString(2,dat);
				             prep_stmt.execute();
				             break;
			            }
			            case 3:
			            {
			            	System.out.println("Enter Regulatory Authority to be updated");
				            String RegulatoryAuthority = b.readLine();
				            query = " update rf1 set  Regulatory_Authority=?" + " where Implementation_date= ?";
				            prep_stmt=conn.prepareStatement(query);
				            prep_stmt.setString(1, RegulatoryAuthority);
				            prep_stmt.setString(2,dat);
				            prep_stmt.execute();
				            break;
			            }
			         }
			          
			            break;
			      }
			      case 3 :{
			    	  //economic indicator
			    	  System.out.println("Enter Date to be updated:");
			            String dat= b.readLine();
			            System.out.println("Want do you want to update? \n1.Indicator type \n2.IVAlue \n3.PreValue");
			            c=Integer.parseInt(b.readLine());
			            switch(c) {
			            case 1:
			            {
			            	System.out.println("Enter Itype to be updated");
				               String itype = b.readLine();

				               query = " update economic_indicator set IType=?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setString(1, itype);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();
				               break;
			            }
			            case 2:
			            {
			            	  System.out.println("Enter new IValue:");
				               int IValue = Integer.parseInt(b.readLine());
				               query = " update economic_indicator set IValue=?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setInt(1, IValue);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();	
				               break;
			            }
			            case 3:
			            {
			            	 System.out.println("Enter new PreValues:");
				               int PV = Integer.parseInt(b.readLine());
				               query = " update  economic_indicator set PreValues=?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setInt(1, PV);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();
				               break;
			            }
			            }
			  
		
						break;
			            
			      }
			      
			         case 4: {
			            //Foreign exchange
			            System.out.println("Enter Date to be updated:");
			            String dat= b.readLine();
			            System.out.println("Want do you want to update? \n1.Transaction type \n2.Purpose \n3.Counter Party");
			            c=Integer.parseInt(b.readLine());
			            switch(c) {
			            case 1:
			            {
			            	System.out.println("Enter new Transaction type:");
				               String tt = b.readLine();
				               query = " update foreign_exchange1 set Transaction_type=?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setString(1, tt);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();
				               break;
			            }
			            case 2:
			            {
			            	  System.out.println("Enter new Purpose");
				               String prs = b.readLine();
				               query = " update foreign_exchange1 set Purpose= ?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setString(1, prs);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();
				               break;
			            }
			            case 3:
			            {
			            	  System.out.println("Enter new Counter party");
				               String cp = b.readLine();
				               query = " update foreign_exchange1 set CounterParty= ?" + " where Date= ?";
				               prep_stmt=conn.prepareStatement(query);
				               prep_stmt.setString(1, cp);
				               prep_stmt.setString(2,dat);
				               prep_stmt.execute();
				               break;
			            }
			            }
			           
			            break;
			         }
			         case 5:{
			        	 //2 banks
			        	 System.out.println("Enter BankID to be updated:");
				            String bi= b.readLine();
				            System.out.println("Want do you want to update ? \n1.Location \n2.Licence \n3.Products \n4.Revenue");
				            c=Integer.parseInt(b.readLine());
				            switch(c) {
				            case 1:
				            {
				            	System.out.println("Enter new Location");
					            String Location = b.readLine();

					               query = " update bank_t1 set Location =?" + " where BankID= ?";
					               prep_stmt=conn.prepareStatement(query);
					               prep_stmt.setString(1, Location);
					               prep_stmt.setString(2,bi);
					               prep_stmt.execute();
					               break;
				            }
				            case 2:
				            {
				            	System.out.println("Enter new Licence");
					            String lic = b.readLine();

					               query = " update bank_t1 set Licence =?" + " where BankID= ?";
					               prep_stmt=conn.prepareStatement(query);
					               prep_stmt.setString(1, lic);
					               prep_stmt.setString(2,bi);
					               prep_stmt.execute();
	                          break;
				            }
				            case 3:
				            {
				            	System.out.println("Enter new Products");
					               String Products = b.readLine();

					               query = " update bank_t2 set Products =?" + " where BankID= ?";
					               prep_stmt=conn.prepareStatement(query);
					               prep_stmt.setString(1, Products);
					               prep_stmt.setString(2,bi);
					               prep_stmt.execute();
					               break;
				            }
				            case 4:
				            {
				            	System.out.println("Enter new Revenue");
					            int Revenue = Integer.parseInt(b.readLine());

					               query = " update bank_t2 set Revenue =?" + " where BankID= ?";
					               prep_stmt=conn.prepareStatement(query);
					               prep_stmt.setInt(1, Revenue);
					               prep_stmt.setString(2,bi);
					               prep_stmt.execute();
					               break;
				            }
				            }
				            
							break;
			         }
			         case 6:{
			            //Monetary policy table
			        	  System.out.println("Enter Date to be updated:");
			              String dat= b.readLine();
			              System.out.println("What do you want do update?\n 1. Instrument type\n 2.Instrument Value\n 3. Target Variable");
			              c=Integer.parseInt(b.readLine());
			              switch(c){
			                case 1:
			                {
			                 System.out.println("Enter new Instrument type");
			                 String inst=b.readLine();

			                 query = " update monetary_policy set Instrument_type =?" + " where Date= ?";
			                 prep_stmt=conn.prepareStatement(query);
			                 prep_stmt.setString(1, inst);
			                 prep_stmt.setString(2,dat);
			                 prep_stmt.execute();
			                 break;
			                }
			                case 2:
			                {
			                 System.out.println("Enter new Instrument value: ");
			                 int insv=Integer.parseInt(b.readLine());

			                 query = " update monetary_policy set Instrument_Value = ?" + " where Date= ?";
			                 prep_stmt=conn.prepareStatement(query);
			                 prep_stmt.setInt(1, insv);
			                 prep_stmt.setString(2,dat);
			                 prep_stmt.execute();
			                 break;
			              }
			              case 3:
			              {
			                 System.out.println("Enter new Target Variable: ");
			                 int tv=Integer.parseInt(b.readLine());

			                 query = " update monetary_policy set Target_Variable= ?" + " where Date= ?";
			                 prep_stmt=conn.prepareStatement(query);
			                 prep_stmt.setInt(1, tv);
			                 prep_stmt.setString(2,dat);
			                 prep_stmt.execute();
			                 break;
			              }
			           }
			           conn.close();
			           break;
			   }				}
				break;
				}
		
				
			      case 4:{
						System.out.println("***********************************DELETING***********************************");
						System.out.println("Enter table to be deleted:");
						
						//which table?
						
						System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions\n6.Monetary Policy");
						System.out.println("Enter choice:");
						
						int table_choice1=Integer.parseInt(b.readLine());
						
						
						switch(table_choice1) {
						case 1: {
							//PAYMENT SYSTEMS
							//deleting from both the tables
							//trigger to delete from the third table TID
							System.out.println("What do you want to delete? \n1.Payment \n2.transaction");
							int h=Integer.parseInt(b.readLine());
				            switch(h) {
				            case 1:
				            {
				            	
								break;
				            }
				            case 2:
				            {
				            	System.out.println("Enter Transaction_ID to be deleted:");
								String transactionID=b.readLine();	
								String query = " delete from payment_t5 where TransactionID= ?";
								PreparedStatement prep_stmt;
								prep_stmt=conn.prepareStatement(query);
								
								
										
								prep_stmt.setString(1,transactionID);
								prep_stmt.execute();
								System.out.println("********************DELETED*****************");
			                   break;
				            }
				            }
							
						
							break;
						 }
						
						
						case 2: {
							//REGULATORY FRAMEWORKS
							
							System.out.println("********************DELETED*****************");
							break;
						}
						
						case 3: {
							//ECONOMIC INDICATORS
							
							break;
						}
						
						case 4: {
							//FOREIGN EXCHANGE
							
							break;
						}
						
						case 5: {
							//FINANCIAL INSTITUTIONS
							//bank table 1
							
							
							
							break;
						}
						
						case 6: {
							//MONETARY POLICY
							
							
						}
	
						conn.close();
				
					}
						break;
			      }
			      default:System.out.println("Wrong input!!");
		}
		System.out.println("continue");
		n=Integer.parseInt(b.readLine());
		}
		while(n==1);
		while(n==1);
		}
		catch(Exception e)
		{
		System.out.println(e);
		}	
	
	}
}

