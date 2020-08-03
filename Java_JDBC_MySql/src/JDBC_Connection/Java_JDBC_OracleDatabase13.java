/*
 * 
 
 
 * retrieve file from db
 */

package JDBC_Connection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Java_JDBC_OracleDatabase13 {
public static void main(String[] args) {

	String query = "select * from filetable";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();  
		rs.next();//now on 1st row  
		rs.next(); // 2nd row              
		Clob c=rs.getClob(2);  
		Reader r=c.getCharacterStream();              
		              
		FileWriter fw=new FileWriter("F:\\retrivefile.txt");  
		              
		int i;  
		while((i=r.read())!=-1)  
		fw.write((char)i);  
		              
		fw.close();  
		con.close();  
		              
		System.out.println("success");  
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}





