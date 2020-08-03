package JDBC_Connection;

// Executing batch sql commands

import java.sql.*;
public class Java_JDBC_OracleDatabase7 {
	public static void main(String args[])throws Exception{  
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
		con.setAutoCommit(false);  
		  
		Statement stmt=con.createStatement	();  
		stmt.addBatch("insert into user420 values(190,'abhi')");  
		stmt.addBatch("insert into user420 values(191,'umesh')");  
		  
		stmt.executeBatch();//executing the batch  
		  
		System.out.println("done");
		con.commit();  
		con.close();  
		
		}
}
