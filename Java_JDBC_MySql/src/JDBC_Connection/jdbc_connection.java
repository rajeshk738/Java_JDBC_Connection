package JDBC_Connection;
/*
 * 
 * Inserting Data into Database
 */
import java.sql.*;
public class jdbc_connection {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/rajesh";
		String user = "root";
		String pwd = "root";
		String query = "insert into rajesh_table values (5,'ram')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");  // registering the driver
		
		System.out.println("connecting Database ");
		
		Connection con = DriverManager.getConnection(url,user,pwd);  // connection establishment using DriverManager getConnection method
		
		
		System.out.println("Creating Statement");
		
		Statement st = con.createStatement(); // creating statement
	
	
		int count = st.executeUpdate(query); // executeUpdate to insert data and returns the total row affected
		
		System.out.println(count);  // no of rows affected
		
		st.close(); // closing the statement
		con.close(); // closing the connection
	}

}
