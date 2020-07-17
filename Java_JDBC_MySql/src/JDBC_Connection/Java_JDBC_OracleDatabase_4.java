package JDBC_Connection;

// PreparedStatement use

import java.sql.*; // Step 1 :  import sql package which contains the classes for JDBC

public class Java_JDBC_OracleDatabase_4 {
	
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
				
				String sql = "insert into rajesh values(?,?)"; // create table rajesh
				st = con.prepareStatement(sql);
				st.setInt(1, 10);
				st.setString(2, "Rajesh");
				
				int i = st.executeUpdate();
				System.out.println(i+" records inserted");
			
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
				e.printStackTrace();
			}
		} 
		
		System.out.println("Good Bye@");
		
	}

}
