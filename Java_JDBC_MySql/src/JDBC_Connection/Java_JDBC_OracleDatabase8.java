package JDBC_Connection;

// JDBCRowSet usage

import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  
  
public class Java_JDBC_OracleDatabase8 {  
        public static void main(String[] args) throws Exception {  
                 Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //Creating and Executing RowSet  
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
        rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");  
        rowSet.setUsername("hr");  
        rowSet.setPassword("hr");  
                   
        rowSet.setCommand("select * from user420");  
        rowSet.execute();  
                   
    while (rowSet.next()) {  
                        // Generating cursor Moved event  
                        System.out.println("Id: " + rowSet.getInt(1));  
                        System.out.println("Name: " + rowSet.getString(2));  
                         
                }  
                 
        }  
}  