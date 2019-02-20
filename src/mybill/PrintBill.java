/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;




/**
 *
 * @author Shivam-PC
 */
public class PrintBill {
    
    public static void writeFile(ArrayList<Order> ordList, String order_id, String PaymentMethod){
        FileWriter fr = null;
        BufferedWriter br = null;
        float total_price = 0;
        File file = null;
    try{
        file = new File("Bill.txt");
        fr = new FileWriter(file);
        br = new BufferedWriter(fr);
        
        br.write (String.format("%20s \r\n","Vitous Mall"));
        br.newLine();
        br.write("Bahavddihpur, Patel Nagar, Akbarpur");
        br.newLine();
        br.write("Uttar Pradesh, pin-224122, mob-9616454925");
        br.newLine();
        br.newLine();
        br.write("      Date- "+orderDao.getDate(new Date()));
        br.newLine();
        br.write("      Order ID- "+order_id);
        br.newLine();
        br.write("      Payment method- "+PaymentMethod);
        br.newLine();
        br.newLine();
        br.write(String.format("%20s %10s %10s \r\n","Product Name","Quantity","Price"));
        for (Order ord : ordList){ 
                String product_name = ord.product_name;
                int quantity = ord.quantity;
                float price = ord.price;
                total_price += price;
                br.write(String.format("%20s %10s %10s \r\n", product_name,String.valueOf(quantity),String.valueOf(price)));
                
        }
        br.write(String.format("\r\n"+"%30s %10s \r\n","Total price-","Rs."+String.valueOf(total_price)));
        br.newLine();
        br.newLine();
        br.write("	Thank You, Visit Again :) ");
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    finally{
        try{
        br.close();
        fr.close();
           
    }
        catch(Exception e){
            System.out.println(e);
        }
    }
        
    }
}
