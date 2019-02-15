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



/**
 *
 * @author Shivam-PC
 */
public class PrintBill {
    
    public static void writeFile(String orderID){
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
