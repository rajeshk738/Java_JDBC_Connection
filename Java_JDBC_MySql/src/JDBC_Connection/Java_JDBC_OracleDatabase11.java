/*
 * retrieve image from the database
 * 
 * use imgtable table in db
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

public class Java_JDBC_OracleDatabase11{
	public static void main(String[] args) {
		
		String query = "select * from imgtable";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){//now on 1st row  
			              
			Blob b=rs.getBlob(2);//2 means 2nd column data  
			byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
			              
			FileOutputStream fout=new FileOutputStream("F:\\myPhoto.jpg");  
			fout.write(barr);  
			              
			fout.close();  
			
			}
			
			System.out.println("ok");  
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


