/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;



/**
 *
 * @author Shivam-PC
 */
public class PrintBill {
    
    public static void writeFile(ArrayList<Order> ordList, String order_id){
        FileWriter fr = null;
        BufferedWriter br = null;
        float total_price = 0;
        File file = null;
    try{
        file = new File("Bill.txt");
        fr = new FileWriter(file);
        br = new BufferedWriter(fr);
        
        br.write ("	New Garments");
        br.newLine();
        br.write("jaganath road, Saintala, Bolangir");
        br.newLine();
        br.write("ph-256266, mob-8295030862");
        br.newLine();
        br.newLine();
        br.write("Date- "+orderDao.getDate(new Date()));
        br.newLine();
        br.write("Order ID-"+order_id);
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
            printFile(file);
    }
        catch(Exception e){
            System.out.println(e);
        }
    }
        
    }
    
    public static void printFile(File file){
            FileInputStream psStream=null;
            try {
               psStream = new FileInputStream(file);
            } catch (FileNotFoundException ffne) {
            }
            if (psStream == null) {
                return;
            }

            DocFlavor psInFormat = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
            SimpleDoc SD = new SimpleDoc(psStream, psInFormat, null);
            
            PrintRequestAttributeSet aset = 
                    new HashPrintRequestAttributeSet();
            aset.add(new Copies(1));
            PrintService[] services = 
              PrintServiceLookup.lookupPrintServices(psInFormat, aset);
            if (services.length > 0) {
                DocPrintJob job = services[0].createPrintJob();
               try {
                    job.print(SD, aset);
               } 
               catch (PrintException pe) {
               }
            }

       
    }
    
    public static void main(String[] args) {
        
    
    }
    
    
    
}
