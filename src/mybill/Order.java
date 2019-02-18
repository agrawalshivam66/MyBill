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
public class Order {    
        String product_name="";
        String barcode_id="";
        String time = "";
        String date = "";
        int mrp=0;
        int discount = 0;
        int quantity = 0;
        float price = 0;
        String payment_method="Cash"; 

    public Order(String barcode_id, String product_name,  String time, String date, int mrp, int discount, int quantity, float price, String payment_method){
        this.product_name = product_name;
        this.barcode_id = barcode_id;
        this.time = time;
        this.date = date;
        this.mrp = mrp;
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
        this.payment_method = payment_method;
}
}
