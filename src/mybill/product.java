/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;

/**
 *
 * @author Shivam-PC
 */
public class product {
    String barcode_id;
     String product_name;
        String product_desc;
        int mrp;
        int discount = 0;
        int total_unit = 0;

    public product(String barcode_id, String product_name, String product_desc, int mrp, int discount, int total_unit) {
        this.barcode_id = barcode_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.mrp = mrp;
        this.discount = discount;
        this.total_unit = total_unit;
    }

    public String getBarcode_id() {
        return barcode_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public int getMrp() {
        return mrp;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTotal_unit() {
        return total_unit;
    }
        
       
        
    
}
