/*
 * storing image in the database
 * 
 * create table in db
 * 
 
 CREATE TABLE  "IMGTABLE"   
   (    "NAME" VARCHAR2(4000),   
    "PHOTO" BLOB  
   )  /  
 
 * 
 */

package JDBC_Connection;


import java.sql.*;
import java.io.*;

public class Java_JDBC_OracleDatabase10{
	public static void main(String[] args) {
		
		String query = "insert into imgtable values(?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Rajesh");
			
			FileInputStream fin = new FileInputStream("F:\\Users\\JavaFile\\photo.jpg");
			ps.setBinaryStream(2, fin,fin.available());
			
			int i = ps.executeUpdate();
			System.out.println(i+"records affected");  // image inserted into db and cannot be viewed
			
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


