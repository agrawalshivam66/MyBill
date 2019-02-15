/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;


/**
 *
 * @author Shivam-PC
 */
public class PrintBill {
    
    public static void writeFile(){
        FileWriter fr = null;
        BufferedWriter br = null;
    try{
          
        File file = new File("Bill.txt");
        System.out.println(file.getAbsolutePath());
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
        br.write("Order ID-");
        br.newLine();
        br.newLine();
        br.write("name		quantity	price");
        br.newLine();
        br.newLine();
        br.write("Total price- Rs. ");
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
    
    public static void printFile(File file){
       
    }
    
    public static void main(String[] args) {
        
    
    }
    
    
    
}
