package JDBC_Connection;

//RowSet with event handling

 
import javax.sql.RowSetEvent;  
import javax.sql.RowSetListener;  
import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  
  
public class Java_JDBC_OracleDatabase9 {  
        public static void main(String[] args) throws Exception {  
                 Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //Creating and Executing RowSet  
    JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
    rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");  
    rowSet.setUsername("hr");  
    rowSet.setPassword("hr");  
                   
        rowSet.setCommand("select * from user420");  
        rowSet.execute();  
                   
    //Adding Listener and moving RowSet  
    rowSet.addRowSetListener(new MyListener());  
  
                 while (rowSet.next()) {  
                        // Generating cursor Moved event  
                        System.out.println("Id: " + rowSet.getInt(1));  
                        System.out.println("Name: " + rowSet.getString(2));  
                         
                }  
                 
        }  
}  
  
class MyListener implements RowSetListener {  
      public void cursorMoved(RowSetEvent event) {  
                System.out.println("Cursor Moved...");  
      }  
     public void rowChanged(RowSetEvent event) {  
                System.out.println("Cursor Changed...");  
     }  
     public void rowSetChanged(RowSetEvent event) {  
                System.out.println("RowSet changed...");  
     }  
}  