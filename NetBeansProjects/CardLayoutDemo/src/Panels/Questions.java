/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import InterfaceClasses.ModelTable;
import InterfaceClasses.NonEditableModel;
import InterfaceClasses.RowTable;
import InterfaceClasses.Table;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static jxl.CellReferenceHelper.getColumnReference;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import layout.GeneratorControllerInterface;
import layout.GeneratorModelInterface;

/**
 *
 * @author ernesto
 */
public class Questions extends javax.swing.JPanel {


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        excelTable = new javax.swing.JTable();

        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("-");
        removeButton.setMaximumSize(new java.awt.Dimension(40, 31));
        removeButton.setMinimumSize(new java.awt.Dimension(40, 31));
        removeButton.setPreferredSize(new java.awt.Dimension(40, 31));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        excelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(excelTable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        addButtonAction();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        removeButtonAction();
    }//GEN-LAST:event_removeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable excelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    public  Table questionTable;
    public  ModelTable questionTableModel;
    public GeneratorControllerInterface gci;
    private final int excelTable_MAX_ROWS_TO_SHOW = 10;
    private final int questionTable_TEXTFIELD_WIDTH = 20;

    
//    private GeneratorControllerInterface gci;
//    private GeneratorModelInterface gmi;


    public Questions(GeneratorControllerInterface gci) {
        initComponents();
//        myInitComponentes(gci);
    }

    public void myInitComponents(GeneratorControllerInterface gci) {
        this.gci = gci;
        questionTableModel   =   new ModelTable();
        questionTableModel.mustNotBeEmpty(true);
        questionTableModel.setMaxRows(10);
        
        
        excelTable  = new JTable();
        excelTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        excelTable.setAutoscrolls(false);
        excelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excelTable1MouseClicked(evt);
            }
        });
        
        //inicializando la tabla de preguntas
        
    }
    
    public void questionTableInit(ModelTable questionTableModel){
        questionTable    =  new Table(questionTableModel);  
        questionTable.setLayout(new GridBagLayout());        
        questionTable.updateTable(questionTableModel);
        
        scrollPane.add(questionTable);
        scrollPane.setViewportView(questionTable);
    }
    
    public void loadExcel(String excelPath){
        NonEditableModel model = new NonEditableModel();
        excelTable.setModel(model);
        excelTable = excelTableLoad(excelTable, excelPath);
        jScrollPane2.setViewportView(excelTable);
        
    }
    
    public JTable excelTableLoad(JTable excelTable, String path) {
        
            excelTable.setFocusable(false);
            excelTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            excelTable.setCellSelectionEnabled(true);
            NonEditableModel model = (NonEditableModel) excelTable.getModel();
        try {
            File file = new File(path);
            Workbook excel  = Workbook.getWorkbook(file);
            Sheet hoja      = excel.getSheet(0);
            int columns     = hoja.getColumns();
            int rows       = hoja.getRows();            
            String  data    = null;
            
            if(rows >= excelTable_MAX_ROWS_TO_SHOW) rows = excelTable_MAX_ROWS_TO_SHOW;       //If the excel has more than 10 rows then we show 10 rows 
            
            for(int i=0; i < columns; i++){
                model.addColumn(getColumnReference(i));
            }
            
            for(int f = 0; f < rows; f++){
                model.addRow(new Object[0]);
                for(int c = 0; c < excelTable_MAX_ROWS_TO_SHOW; c++){
                    data   = hoja.getCell(c,f).getContents();
                    model.setValueAt(data, f, c);
                };
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return excelTable;
    }
    
    private void excelTable1MouseClicked(java.awt.event.MouseEvent evt){
        int row = excelTable.rowAtPoint(evt.getPoint());
        int col = excelTable.columnAtPoint(evt.getPoint());

        if(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() != null){
        if(JTextField.class == KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getClass()){
            JTextField text = (JTextField) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            text.setText((String) excelTable.getValueAt(row, col));
        };
        }
    }
    
    public RowTable questionsTableAddRow(int tableSize){
        JLabel  questionNumber  = new JLabel("Pregunta "+ Integer.toString(tableSize + 1) + ":");
        JTextField question = new JTextField();
        question.setColumns(questionTable_TEXTFIELD_WIDTH);
        
        RowTable row    = new RowTable();
        row.addComponent(questionNumber);
        row.addComponent(question);
        
        System.out.println(questionNumber.getText());
        return row;
    }

    public void addButtonAction(){
        gci.questions_buttonAdd(questionTable, questionTableModel, questionsTableAddRow(questionTableModel.getTotalRows()));
    }

    public void removeButtonAction(){
        gci.question_buttonRemove(questionTable, questionTableModel);
    }
}