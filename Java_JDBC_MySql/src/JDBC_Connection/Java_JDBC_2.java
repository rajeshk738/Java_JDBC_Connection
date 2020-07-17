package JDBC_Connection;

import java.sql.*; // Step 1 :  import sql package which contains the classes for JDBC

public class Java_JDBC_2 {
	
	// JDBC driver name and database url
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/rajesh";
	
	// Database Credentials
	final static String USER = "root";
	final static String PASS =  "root";
	
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
			String sql = "select id,name,age from students";
			ResultSet rs = st.executeQuery(sql);
		
			// Step 5 : Extract data from result set
			
			while(rs.next()) {
				// Retrieve by column name or column number
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt(3);
				
				// Displaying the values
				
				System.out.println("Id = "+id+", Name = "+name+", Age = "+age);
			
			}
			

			// Step 6 : clean-up environment
			rs.close();
			st.close();
			con.close();
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
