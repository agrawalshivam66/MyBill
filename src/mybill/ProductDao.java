package mybill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {

	public static int save(String barcode_id,String product_name,String product_desc, int mrp, int discount,int total_unit){
		int status=0;
		try{
			Connection con=productDB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			ps.setString(1,barcode_id);
			ps.setString(2,product_name);
			ps.setString(3,product_desc);
			ps.setInt(4,mrp);
			ps.setInt(5,discount);
			ps.setInt(6, total_unit);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int delete(String barcode_id){
		int status=0;
		try{
			Connection con=productDB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where barcode_id=?");
			ps.setString(1,barcode_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int update(String barcode_id,String product_name,String product_desc, int mrp, int discount, int total_unit){
		int status=0;
		try{
			Connection con=productDB.getConnection();
			PreparedStatement ps=con.prepareStatement("update product set product_name=?, product_desc=?, mrp=?, discount=?, total_unit=? where barcode_id = ?");
			
			ps.setString(1,product_name);
			ps.setString(2,product_desc);
			ps.setInt(3,mrp);
			ps.setInt(4,discount);
			ps.setInt(5, total_unit);
			ps.setString(6,barcode_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        
           /**
     * select all rows in the warehouses table
     */
    public static product selectAll(String barcode_id){
        String sql = "SELECT * FROM product where barcode_id ="+barcode_id;
        String product_name="";
        String product_desc="";
        int mrp=0;
        int discount = 0;
        int total_unit = 0;
        try {
            Connection conn = productDB.getConnection();     
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
           
            while (rs.next()) {
                product_name=rs.getString("product_name");
                product_desc=rs.getString("product_desc");
                mrp = rs.getInt("mrp");
                discount = rs.getInt("discount");
                total_unit = rs.getInt("total_unit");
            }
             conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        product pro = new product(barcode_id, product_name, product_desc, mrp, discount, total_unit);
        return pro;
    }
    public static product selectAllProducts(){
        String sql = "SELECT * FROM product";
        String product_name="";
        String barcode_id="";
        String product_desc="";
        int mrp=0;
        int discount = 0;
        int total_unit = 0;
        try {
            Connection conn = productDB.getConnection();     
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
           
            while (rs.next()) {
                barcode_id=rs.getString("barcode_id");
                product_name=rs.getString("product_name");
                product_desc=rs.getString("product_desc");
                mrp = rs.getInt("mrp");
                discount = rs.getInt("discount");
                total_unit = rs.getInt("total_unit");
            }
            conn.close();
             
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        product pro = new product(barcode_id, product_name, product_desc, mrp, discount, total_unit);
        return pro;
    }
	}

