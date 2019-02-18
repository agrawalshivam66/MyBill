/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.Date;
 
public class HelloWorldPrinter implements Printable{
    ArrayList<Order> ordList=null;
    float total_price=0;
    String order_id;
    String PaymentMethod;
    
     void  initOrder(ArrayList<Order> ordList, String order_id, String PaymentMethod){
        this.ordList = ordList;
        this.order_id = order_id;
        this.PaymentMethod = PaymentMethod;
    }
 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        g2d.setFont(new Font("Arial",Font.BOLD,15));
        
        g.drawString ("Vitous Mall", 50, 10);
        g2d.setFont(new Font("Monospaced",Font.BOLD,10));
 
        g.drawString("Bahavddihpur, Patel Nagar, Akbarpur", 10, 30);
       
        g.drawString("Uttar Pradesh, pin-224122, mob-9616454925", 10, 45);
        
        g.drawString("Date- "+orderDao.getDate(new Date()), 50, 60);
        
        g.drawString("Order ID- "+order_id, 50, 75);
        
        g.drawString("Payment method- "+PaymentMethod, 50, 90);
        g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
        g.drawString(String.format("%20s %10s %10s \r\n","Product Name","Quantity","Price"), 10, 105);
        int y = 0;
        for (Order ord : ordList){ 
                y+=15;
                String product_name = ord.product_name;
                int quantity = ord.quantity;
                float price = ord.price;
                total_price += price;
                g.drawString(String.format("%20s %10s %10s \r\n", product_name,String.valueOf(quantity),String.valueOf(price)),10,105+y);
                
        }
        g2d.setFont(new Font("Monospaced",Font.BOLD,10));
        g.drawString("Total price-Rs."+String.valueOf(total_price), 50, 120+y);
        g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
        g.drawString("	Thank You, Visit Again :) ", 10, 135+y);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    public void startPrinting(){
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    
}