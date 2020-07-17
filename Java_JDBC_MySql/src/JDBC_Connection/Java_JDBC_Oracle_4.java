package JDBC_Connection;

// CallableStatement use

/*
 * create table
 * 
 * --> create table user420(id number(10), name varchar2(200));  
 * 
 * create stored procedure to call
 * 
 *--> create or replace procedure "INSERTR"  
(id IN NUMBER,  
name IN VARCHAR2)  
is  
begin  
insert into user420 values(id,name);  
end;  /

Sum stored Procedure:


create or replace function sum4  
(n1 in number,n2 in number)  
return number  
is   
temp number(8);  
begin  
temp :=n1+n2;  
return temp;  
end;  
/  


 */

import java.sql.*; // Step 1 :  import sql package which contains the classes for JDBC

public class Java_JDBC_Oracle_4 {
	
	// JDBC driver name and database url
	final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// Database Credentials
	final static String USER = "hr";
	final static String PASS =  "hr";
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
				
				Class.forName(JDBC_DRIVER);
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				
				CallableStatement stmt=con.prepareCall("{call insertR(?,?)}");  
				stmt.setInt(1,1011);  
				stmt.setString(2,"Amit");  
				stmt.execute();  
				  
				System.out.println("success");  

				
	/*			// calling Sum stored procedure
				CallableStatement stmt=con.prepareCall("{?= call sum4(?,?)}");  
				stmt.setInt(2,10);  
				stmt.setInt(3,43);  
				stmt.registerOutParameter(1,Types.INTEGER);  
				stmt.execute();  
				  
				System.out.println(stmt.getInt(1));  
	
				*/
			
			}
		catch(SQLException s) {
			s.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
	}

}
