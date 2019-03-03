package mybill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        
        public static int updateQuantity(String barcode_id, int quantity){
		int status=0;
		try{
			Connection con=productDB.getConnection();
			PreparedStatement ps=con.prepareStatement("update product set total_unit= total_unit-? where barcode_id = ?");
			ps.setInt(1, quantity);
			ps.setString(2,barcode_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        
       
       public static product selectAll(String barcode_id){
        String sql = "SELECT * FROM product where barcode_id='"+barcode_id+"';";
        String product_name="";
        String product_desc="";
        int mrp=0;
        int discount = 0;
        int total_unit = 0;
        try {
            Connection conn = productDB.getConnection();     
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             
             if (!rs.isBeforeFirst()) {
                 return null;
             }
           
            while (rs.next()) {
                product_name=rs.getString("product_name");
                product_desc=rs.getString("product_desc");
                mrp = rs.getInt("mrp");
                discount = rs.getInt("discount");
                total_unit = rs.getInt("total_unit");
            }
            
            
             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        product pro = new product(barcode_id, product_name, product_desc, mrp, discount, total_unit);
        return pro;
    }

    public static ArrayList<product> selectAllProducts(){
        ArrayList<product> pro = new ArrayList<>();
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
                product prod = new product(barcode_id, product_name, product_desc, mrp, discount, total_unit);
                pro.add(prod);
            }
            conn.close();
             
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return pro;
    }
    
    public static ArrayList<String[]> ProductsNames(){
        ArrayList<String[]> productList = new ArrayList<String[]>();
        String sql = "SELECT product_name,barcode_id FROM product;";
        
        try {
            Connection conn = productDB.getConnection();     
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
           
            while (rs.next()) {
                String[] productDetails=new String[2];
                productDetails[1]=rs.getString("product_name");
                productDetails[0]=rs.getString("barcode_id");
                productList.add(productDetails);
            }
            conn.close();
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return productList;
    }
	}

