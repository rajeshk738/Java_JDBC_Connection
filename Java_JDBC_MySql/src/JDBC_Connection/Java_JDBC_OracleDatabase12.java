/*
 * create a table in db
 
 CREATE TABLE  "FILETABLE"   
   (    "ID" NUMBER,   
    "NAME" CLOB  
   )  /
   
 
 * 
 * 
 * store file in the database
 */

package JDBC_Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Java_JDBC_OracleDatabase12 {
	
public static void main(String[] args) {
		
		String query = "insert into filetable values(?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			File f=new File("F:\\\\Users\\\\JavaFile\\\\file.txt");  
			FileReader fr=new FileReader(f);  
			              
			ps.setInt(1,101);  
			ps.setCharacterStream(2,fr,(int)f.length());  
			int i=ps.executeUpdate();  
			
			System.out.println(i+"records affected");  // file inserted into db and cannot be viewed
			
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}





