package mybill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class orderDB{
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/order.db";
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
       int i = orderDao.save("12334", "abbc", "laptop", "lenovo", 100000, 10, 1);
       System.out.print(i);
	}
    
}

