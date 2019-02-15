package mybill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

}

