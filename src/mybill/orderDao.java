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
	    System.out.println("Current day  " + formattedDate);
	    return formattedDate;
	}
	
	
	public static String getTime(Date date) {
	    String time_format = "hh:mm:ss a";
	    DateFormat timeFormat = new SimpleDateFormat(time_format);
	    String formattedTime= timeFormat.format(date);
	    System.out.println("Current time  " + formattedTime);
	    return formattedTime;
	}

	public static int save(String order_id, String barcode_id, String product_name,String product_desc, int mrp, int discount,int quantity){
		int status=0;
		Date date = new Date();
		String order_date = getDate(date);
		String order_time = getTime(date);
		try{
			Connection con=orderDB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orderbill values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,order_id);
			ps.setString(2,barcode_id);
			ps.setString(3,product_name);
			ps.setString(4,product_desc);
			ps.setString(5,order_date);
			ps.setString(6,order_time);
			ps.setInt(7,mrp);
			ps.setInt(8,discount);
			ps.setInt(9, quantity);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}

