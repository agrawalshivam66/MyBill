package mybill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class productDB{
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:product.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
	public static void main(String[] args) {
       getConnection();
       
    }
    
}

