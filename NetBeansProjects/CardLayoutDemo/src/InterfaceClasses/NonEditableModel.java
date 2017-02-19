/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ernesto
 */
public class NonEditableModel extends DefaultTableModel{
    
    NonEditableModel(Object[][] data, String[] columnNames) {
        super(data, columnNames);
    }

    public NonEditableModel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
