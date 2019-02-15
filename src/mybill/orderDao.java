package mybill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class orderDao {
		
	public static String getDate(Date date) {
	    String date_format = "dd/MM/yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(date_format);
	    String formattedDate= dateFormat.format(date);
	    return formattedDate;
	}
	
	
	public static String getTime(Date date) {
	    String time_format = "hh:mm:ss a";
	    DateFormat timeFormat = new SimpleDateFormat(time_format);
	    String formattedTime= timeFormat.format(date);
	    return formattedTime;
	}

	public static int save(String order_id, String barcode_id, String product_name, String order_date, String order_time, int mrp, int discount,int quantity, float price){
		int status=0;
		try{
			Connection con=orderDB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orderbill values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,order_id);
			ps.setString(2,barcode_id);
			ps.setString(3,product_name);
			ps.setString(4,order_date);
			ps.setString(5,order_time);
			ps.setInt(6,mrp);
			ps.setInt(7,discount);
			ps.setInt(8, quantity);
                        ps.setFloat(9,price);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        
       public static ArrayList<Order> FindOrder(String OrderId){
        ArrayList<Order> ordList = new ArrayList<>();
        String sql = "SELECT * FROM orderbill where order_id='"+OrderId+"';";
        String product_name="";
        String barcode_id="";
        String time = "";
        String date = "";
        int mrp=0;
        int discount = 0;
        int quantity = 0;
        float price = 0; 
        try {
            Connection conn = orderDB.getConnection();     
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
           
            while (rs.next()) {
                barcode_id=rs.getString("barcode_id");
                product_name=rs.getString("product_name");
                time = rs.getString("order_time");
                date = rs.getString("order_date");
                mrp = rs.getInt("mrp");
                discount = rs.getInt("discount");
                quantity = rs.getInt("quantity");
                price = rs.getFloat("price");
                
                Order odr = new Order(barcode_id, product_name, time, date, mrp, discount, quantity, price);
                ordList.add(odr);
            }
            conn.close();
             
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return ordList;
    }

}

