/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybill;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Shivam-PC
 */
public class viewReport extends javax.swing.JFrame {

    /**
     * Creates new form viewProducts
     */
    public viewReport() {
         setExtendedState(this.MAXIMIZED_BOTH); 
        initComponents();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateChooserStart.setDateFormat(dateFormat);
        dateChooserStart.setAutoScroll(true);
        dateChooserEnd.setDateFormat(dateFormat);
        dateChooserEnd.setAutoScroll(true);
        
    }
    
     private void DisplayOrder(){
         DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
         model.setRowCount(0);
         String StartDate = dateChooserStart.getText();
         String EndDate = dateChooserEnd.getText();
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate startDate = LocalDate.parse(StartDate, dtf);
         LocalDate endDate = LocalDate.parse(EndDate, dtf);
         for (LocalDate date = startDate; date.isBefore(endDate)||date.isEqual(endDate); date = date.plusDays(1))
            {
                String ord_date = date.format(dtf);
                ArrayList<Order> ordList = orderDao.FindOrderDate(ord_date);
          
            for (Order ord : ordList){ 
                String barcode_id = ord.barcode_id;
                String product_name = ord.product_name;
                String time = ord.time;
                String Order_id = ord.Order_id;
                int mrp = ord.mrp;
                int discount = ord.discount;
                int quantity = ord.quantity;
                float price = ord.price;
                String payment_method = ord.payment_method;
                
            Object[] item={Order_id, barcode_id, product_name, time, ord_date, mrp, discount, quantity, price, payment_method};
            model.addRow(item);
            }
            }
         
            
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dateChooserStart = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateChooserEnd = new datechooser.beans.DateChooserCombo();
        ExportButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Barcode ID", "Product Name", "Time", "Date", "MRP", "Discount ", "Quantity", "Price", "Payment Method"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(5).setCellRenderer(cellCenter());
            OrderTable.getColumnModel().getColumn(6).setCellRenderer(cellCenter() );
            OrderTable.getColumnModel().getColumn(7).setCellRenderer(cellCenter() );
            OrderTable.getColumnModel().getColumn(8).setCellRenderer(cellCenter() );
        }

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("View Report");

        dateChooserStart.setCalendarPreferredSize(new java.awt.Dimension(350, 350));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dateChooserStart, org.jdesktop.beansbinding.ELProperty.create("${dch_autoScroll}"), dateChooserStart, org.jdesktop.beansbinding.BeanProperty.create("dch_autoScroll"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dateChooserStart, org.jdesktop.beansbinding.ELProperty.create("${dch_combo_dateFormat}"), dateChooserStart, org.jdesktop.beansbinding.BeanProperty.create("dch_combo_dateFormat"));
        bindingGroup.addBinding(binding);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Start Date:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("End Date:");

        dateChooserEnd.setCalendarPreferredSize(new java.awt.Dimension(350, 350));

        ExportButton.setText("Export Report");
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ExportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(764, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BackButton)
                        .addComponent(SearchButton)
                        .addComponent(ExportButton))
                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private DefaultTableCellRenderer cellCenter(){
          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );  
          return centerRenderer;
      }
    
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
       DisplayOrder();
        
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        // TODO add your handling code here:
            DefaultTableModel dtm = (DefaultTableModel)OrderTable.getModel();
            Workbook wb = new HSSFWorkbook();
            CreationHelper createhelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("Order Report Sheet");
            Row row = null;
            Cell cell = null;
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Order ID");
            sheet.setColumnWidth(0, 4000);
            header.createCell(1).setCellValue("Barcode ID");
            sheet.setColumnWidth(1, 4000);
            header.createCell(2).setCellValue("Product Name");
            sheet.setColumnWidth(2, 7000);
            header.createCell(3).setCellValue("Time");
            sheet.setColumnWidth(3, 3000);
            header.createCell(4).setCellValue("Date");
            sheet.setColumnWidth(4, 3000);
            header.createCell(5).setCellValue("MRP");
            sheet.setColumnWidth(5, 3000);
            header.createCell(6).setCellValue("Discount");
            sheet.setColumnWidth(6, 2000);
            header.createCell(7).setCellValue("Quantity");
            sheet.setColumnWidth(7, 2000);
            header.createCell(8).setCellValue("Price");
            sheet.setColumnWidth(8, 3000);
            header.createCell(9).setCellValue("Payment Method");
            sheet.setColumnWidth(9, 4000);
            
            
            
             
            for (int i=1;i <= dtm.getRowCount();i++) {
                row = sheet.createRow(i);
                for (int j=0;j<dtm.getColumnCount();j++) {
                    cell = row.createCell(j);
                    switch (dtm.getValueAt(i-1, j).getClass().getSimpleName()){
                        case "Integer":
                             cell.setCellValue(Integer.parseInt((String.valueOf(dtm.getValueAt(i-1, j)))));
                             break;
                        case "String":
                             cell.setCellValue(String.valueOf(dtm.getValueAt(i-1, j)));
                             break;
                        case "Float":
                             cell.setCellValue(Float.parseFloat(String.valueOf(dtm.getValueAt(i-1, j))));
                             break;
                        default:
                             cell.setCellValue(String.valueOf(dtm.getValueAt(i-1, j)));
                             break;
                    }
                }
            }

            try{
                
                JFrame parentFrame = new JFrame();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setPreferredSize(new Dimension(800,600));
                fileChooser.setDialogTitle("Select where you want to generate the report");   
                String path="";
                int userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    path = fileToSave.getAbsolutePath();
                    path = path.replaceAll(".xls", "");
                    }
                else{
                    return;
                }
             
            File file = new File(path+".xls");
            FileOutputStream out = new FileOutputStream(path+".xls");
            wb.write(out);
            out.close();
            JOptionPane.showMessageDialog(viewReport.this,"Report sucessfully generated");
            }
        catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(viewReport.this,"Sorry Error occured");
        } 
            
    }//GEN-LAST:event_ExportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ExportButton;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton SearchButton;
    private datechooser.beans.DateChooserCombo dateChooserEnd;
    private datechooser.beans.DateChooserCombo dateChooserStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
