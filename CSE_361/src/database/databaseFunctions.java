package database;

import java.sql.*;
import dataStorage.*;
import database.DatabaseInfo;
public class databaseFunctions {
	
	

	public static void createTables(){
		Connection conn = DatabaseInfo.getConnection();
		Statement stmt = null;
		
		try{
			String query;
			query = "drop table if exists Bank";
			stmt = conn.prepareStatement(query);
			stmt.executeUpdate(query);
			
			query ="drop table if exists Account";
			stmt.executeUpdate(query);
			
			query="drop table if exists User";
			stmt.executeUpdate(query);
			

			query ="CREATE TABLE User(userId int not null primary key auto_increment,cardNumber varchar(20),PIN varchar(4))collate=latin1_general_cs";
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE Account(accountId int not null primary key auto_increment,userId int not null,availableFund double,currencyName varchar(10),exchangeRateToUSD double,exchangeRateFromUSD double,type varchar(10),foreign key (userId) references User(userId))collate=latin1_general_cs";
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE Bank(bankId int not null primary key auto_increment,accountId int not null,bankName varchar(255),foreign key (accountId) references Account(accountId))collate=latin1_general_cs";
			stmt.executeUpdate(query);
			
			query = "INSERT INTO User(cardNumber, PIN) values ('0321 3213 4313 5543', '3214')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO User(cardNumber, PIN) values ('4321 4315 6542 4523', '3534')";
			stmt.executeUpdate(query);
			
			
			query="INSERT INTO User(cardNumber, PIN) values ('6589 2554 5425 5424', '5425')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO User(cardNumber, PIN) values ('6892 5425 5657 6956', '8659')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO User(cardNumber, PIN) values ('8491 5456 3112 4902', '0900')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type)"+ "values ((SELECT userId FROM User WHERE userId = 1), 4813.43, 'USD', 1.00, 1.00, 'checking')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type) values ((SELECT userId FROM User WHERE userId = 1), 14314.31, 'USD', 1.00, 1.00, 'saving')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type) values ((SELECT userId FROM User WHERE userId = 2), 5432401, 'VND', 0.000044, 22831.05, 'checking')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type) values ((SELECT userId FROM User WHERE userId = 4), 68194, 'CNY', 0.16, 6.33, 'checking')";
			stmt.executeUpdate(query);
			
			
			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type) values ((SELECT userId FROM User WHERE userId = 5), 542153, 'JPY', 0.0094, 106.4, 'saving')";
			stmt.executeUpdate(query);

			query="INSERT INTO Account(userId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type) values ((SELECT userId FROM User WHERE userId = 3), 34132, 'GBP', 1.39, 0.72, 'checking')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 1), 'Wells Fargo')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 3), 'Techcom Bank')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 5), 'Mizuho Trust & Banking')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 2), 'US BANK')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 4), 'Hua Xia Bank')";
			stmt.executeUpdate(query);
			
			query="INSERT INTO Bank(accountId, bankName) values ((SELECT accountId FROM Account WHERE accountId = 6), 'Barclays')";
			stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		}
		catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
         }finally{
           //finally block used to close resources
           try{
              if(stmt != null)
                 stmt.close();
           }catch(SQLException se2){
           }try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
	}}}
	
	public static User verify(String cardNumber,String pin){
		User c=null;
		int dbPIN=0;
		Connection db = DatabaseInfo.getConnection();
		PreparedStatement stmt=null;
		try{
			
			stmt = db.prepareStatement("Select PIN from User where cardNumber = "+"'"+cardNumber+"'");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				   dbPIN=rs.getInt(1);
			}
		if(dbPIN == Integer.parseInt(pin)){
			c= new User(cardNumber,dbPIN);
		}
	}catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
       //Handle errors for Class.forName
       e.printStackTrace();
     }finally{
       //finally block used to close resources
       try{
          if(stmt != null)
             stmt.close();
       }catch(SQLException se2){
       }try{
          if(db != null)
             db.close();
       }catch(SQLException se){
           se.printStackTrace();
       }}
		return c;
	}
	public static Account getAccount(String card, String Type){
		Account A=null;
		Connection db = DatabaseInfo.getConnection();
		PreparedStatement stmt=null;
		try{
			
			stmt = db.prepareStatement("Select accountId, availableFund, currencyName, exchangeRateToUSD, exchangeRateFromUSD, type, bankName From Account where cardNumber ="+"'"+card+"'"+"and type ="+"'"+Type+"'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				   long accountnumber = rs.getLong("accountId");
				   double availableFund = rs.getDouble("availableFund");
				   String currency = rs.getString("currencyName");
				   double rateTo = rs.getDouble("exchangeRateToUSD");
				   double rateFrom = rs.getDouble("exchangeRateFromUSD");
				   String bank = rs.getString("bankName");
				   if(rateTo!=1){
				   A = new Account(accountnumber,Type,availableFund,bank, currency, rateTo,rateFrom);}
				   else{
					   A = new Account(accountnumber,Type,availableFund,bank, currency);
				   }
			}
	}catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
       //Handle errors for Class.forName
       e.printStackTrace();
     }finally{
       //finally block used to close resources
       try{
          if(stmt != null)
             stmt.close();
       }catch(SQLException se2){
       }try{
          if(db != null)
             db.close();
       }catch(SQLException se){
           se.printStackTrace();
       }}
		return A;
	}
	public static void updateFunds(double x, long number){
		Connection db = DatabaseInfo.getConnection();
		Statement stmt=null;
		try{
			String query = "Update availableFund ="+"'"+x+"'"+"Where accountId ="+"'"+number+"'";
			stmt = db.prepareStatement(query);
			stmt.executeUpdate(query);
			
	}catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
       //Handle errors for Class.forName
       e.printStackTrace();
     }finally{
       //finally block used to close resources
       try{
          if(stmt != null)
             stmt.close();
       }catch(SQLException se2){
       }try{
          if(db != null)
             db.close();
       }catch(SQLException se){
           se.printStackTrace();
       }}
	}
}
