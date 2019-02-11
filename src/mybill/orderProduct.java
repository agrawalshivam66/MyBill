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
public class orderProduct {
   
        String barcode_id;
        String product_name;
        String product_desc;
        int mrp;
        int discount = 0;
        int quantity = 0;
        
            public orderProduct(String barcode_id, String product_name, String product_desc, int mrp, int discount, int quantity) {
        this.barcode_id = barcode_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.mrp = mrp;
        this.discount = discount;
        this.quantity = quantity;
    }
    
}
