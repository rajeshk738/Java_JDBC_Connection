package JDBC_Connection;

import java.sql.*; // Step 1 :  import sql package which contains the classes for JDBC

public class Java_JDBC_OracleDatabase_3 {
	
	// JDBC driver name and database url
	final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// Database Credentials
	final static String USER = "hr";
	final static String PASS =  "hr";
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			// Step 2 : Register the JDBC Driver
			Class.forName(JDBC_DRIVER);
			
			// Step 3 : Open a connection
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			
			// Step 4 : Execute a query
			System.out.println("Creating statement...");
			st = con.createStatement();
			String sql = "SELECT LAST_NAME,FIRST_NAME,SALARY FROM EMPLOYEES WHERE SALARY >= 15000";
			
			System.out.println(st.execute(sql)); // execute() returns true if data returned or false if not data returned
			//executeUpdate() is used for insert,update and delete operations on database it returns the number of rows effecteds
			
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("\n\nResult Set meta data\n");
			ResultSetMetaData rsmd=rs.getMetaData();   // metadata of the ResultSet table
			  
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
		
			System.out.println("\n\nData Base meta data\n");
			DatabaseMetaData dbmd=con.getMetaData();   // database meta data
			  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			
			
			System.out.println("\n\nDisplying the result set values\n");
			// Step 5 : Extract data from result set
			
			while(rs.next()) {
				// Retrieve by column name or column number
				
				String id = rs.getString(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				
				// Displaying the values
				
				System.out.println("Name = "+id+" "+name+", salary = "+salary);
			
			}
			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// finally block used to close connections
			
			try {
				if(st != null)
					st.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				}
		} 
		
		System.out.println("Good Bye@");
		
	}

}
