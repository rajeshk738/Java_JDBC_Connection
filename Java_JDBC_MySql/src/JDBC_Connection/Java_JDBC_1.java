/*
 * 1. import package --> import java.sql.*;
 * 2. Load the mysql-connector java jar file into the project 
 * 		download mysql-connector/J  and add zip of mysql connector using add external Jar in the project
 * 		register the drive ---> com.mysql.cj.jdbc.Driver
 * 3. Create Connection ---> Connection
 * 4. Create a Statement ---> Statement
 * 5. Execute query ----> 
 * 6. process the results--->ResultSet
 * 7. close the connection
 * 
 */

package JDBC_Connection;

import java.sql.*;  
public class Java_JDBC_1 {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/rajesh";
		String user = "root";
		String pwd = "root";
		String query = "select * from rajesh_table";
		
		Class.forName("com.mysql.cj.jdbc.Driver");  // registering the driver
		
		System.out.println("connecting Database ");
		
		Connection con = DriverManager.getConnection(url,user,pwd);  // connection establishment using DriverManager getConnection method
		
		
		System.out.println("Creating Statement");
		
		Statement st = con.createStatement(); // creating statement
	
		ResultSet rs = st.executeQuery("select * from students order by id"); //executing the query and ResultSet pointer points to result table
		
		
		while(rs.next())   // Processing the results
		{
			int id1 = rs.getInt("id");   // column id value
			
		//	int id1 = rs.getInt(1); // Here 1 is the column1 index
			
			String name1 = rs.getString("name"); // column name value
			
		//  String name1 = rs.getString(2); // Here 2 is the column2 index
			
			System.out.println(id1+", "+name1);
		}
				
		
		
		st.close(); // closing the statement
		con.close(); // closing the connection
	}

}
