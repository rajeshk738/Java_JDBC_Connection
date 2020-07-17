package JDBC_Connection;

import java.sql.*;
public class Java_JDBC_OracleDatabase_5 {
	public static void main(String args[])throws Exception{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
		con.setAutoCommit(false);  // by default auto commit is true 
		  
		Statement stmt=con.createStatement();  
		stmt.executeUpdate("insert into user420 values(190,'abhi')");  
		stmt.executeUpdate("insert into user420 values(191,'umesh')");  
		 
		System.out.println("done");
		con.commit();
		
		
	// 	con.rollback(); // roll back to previous save point or committed
		con.close();  
		}

}
